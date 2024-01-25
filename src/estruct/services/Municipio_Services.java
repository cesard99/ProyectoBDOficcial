package estruct.services;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import dto.Municipio_DTO;



public class Municipio_Services {
	public void insertMunicipio(String userName, String userNick, String userPassword, int roleCode) 
			throws SQLException, ClassNotFoundException{
		String query = "SELECT user__insert(?,?,?,?)";
		java.sql.Connection connection = ServicesLocator.getConnection();
		PreparedStatement preparedStatement = connection.prepareStatement(query);
		preparedStatement.setString(1, userName);
		preparedStatement.setString(2, userNick);
		preparedStatement.setString(3, userPassword);
		preparedStatement.setInt(4, roleCode);
		preparedStatement.execute();
		preparedStatement.close();
		connection.close();
	}
	
	public void deleteMunicipio(int userCode) throws SQLException, ClassNotFoundException{
		String query = "SELECT user__delete(?)";
		java.sql.Connection connection = ServicesLocator.getConnection();
		PreparedStatement preparedStatement = connection.prepareStatement(query);
		preparedStatement.setInt(1, userCode);
		preparedStatement.execute();
		preparedStatement.close();
		connection.close();
	}
	
	public void updateUser(int userCode, String userName, String userNick, String userPassword, int roleCode) 
			throws SQLException, ClassNotFoundException{
		String query = "SELECT user__update(?,?,?,?,?)";
		java.sql.Connection connection = ServicesLocator.getConnection();
		PreparedStatement preparedStatement = connection.prepareStatement(query);
		preparedStatement.setInt(1, userCode);
		preparedStatement.setString(2, userName);
		preparedStatement.setString(3, userNick);
		preparedStatement.setString(4, userPassword);
		preparedStatement.setInt(5, roleCode);
		preparedStatement.execute();
		preparedStatement.close();
		connection.close();
	}
	
	
	public Municipio_DTO findUser(int muniCode) throws SQLException, ClassNotFoundException{
		java.sql.Connection connection = ServicesLocator.getConnection();
		Statement statement = connection.createStatement (ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY); 
		String query = "SELECT * FROM user_ WHERE user_.user_code = '"+muniCode+"'"; 
		ResultSet rs = statement.executeQuery(query);
		rs.first();
		Municipio_DTO muni = new Municipio_DTO(rs.getString(1), rs.getString(2));
		rs.close();
		statement.close();
		connection.close();
		return muni;
	}
	
	public ArrayList<Municipio_DTO> selectAllMun() throws SQLException, ClassNotFoundException{
		ArrayList<Municipio_DTO> muni = new ArrayList<Municipio_DTO>();
		String function = "{?= call select_all_municipio()}";
		java.sql.Connection connection = ServicesLocator.getConnection();
		connection.setAutoCommit(false);
		CallableStatement preparedFunction = connection.prepareCall(function);
		preparedFunction.registerOutParameter(1, java.sql.Types.OTHER);
		preparedFunction.execute();
		ResultSet rs = (ResultSet) preparedFunction.getObject(1);
		while (rs.next()){
			muni.add(new Municipio_DTO(rs.getString(1), rs.getString(2)));  
		}
		rs.close();
		preparedFunction.close();
		connection.close();
		return muni;
	}
}
     
    

