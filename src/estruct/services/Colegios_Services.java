package estruct.services;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import dto.CDR_DTO;
import dto.Colegios_DTO;

public class Colegios_Services {

	public void insertCDR(String userName, String userNick, String userPassword, int roleCode) 
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
	
	public void deleteCol(int colCode) throws SQLException, ClassNotFoundException{
		String query = "SELECT user__delete(?)";
		java.sql.Connection connection = ServicesLocator.getConnection();
		PreparedStatement preparedStatement = connection.prepareStatement(query);
		preparedStatement.setInt(1, colCode);
		preparedStatement.execute();
		preparedStatement.close();
		connection.close();
	}
	
	public void updateCol(int userCode, String userName, String userNick, String userPassword, int roleCode) 
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
	
	
	public Colegios_DTO findCOL(int cdrCode) throws SQLException, ClassNotFoundException{
		java.sql.Connection connection = ServicesLocator.getConnection();
		Statement statement = connection.createStatement (ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY); 
		String query = "SELECT * FROM user_ WHERE user_.user_code = '"+cdrCode+"'"; 
		ResultSet rs = statement.executeQuery(query);
		rs.first();
		Colegios_DTO col = new Colegios_DTO(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4));
		rs.close();
		statement.close();
		connection.close();
		return col;
	}
	
	public ArrayList<Colegios_DTO> selectAllCol() throws SQLException, ClassNotFoundException{
		ArrayList<Colegios_DTO> col = new ArrayList<Colegios_DTO>();
		String function = "{?= call select_all_colegioelectoral()}";
		java.sql.Connection connection = ServicesLocator.getConnection();
		connection.setAutoCommit(false);
		CallableStatement preparedFunction = connection.prepareCall(function);
		preparedFunction.registerOutParameter(1, java.sql.Types.OTHER);
		preparedFunction.execute();
		ResultSet rs = (ResultSet) preparedFunction.getObject(1);
		while (rs.next()){
			col.add(new Colegios_DTO(rs.getString(1), rs.getString(2),rs.getString(3),rs.getString(4)));  
		}
		rs.close();
		preparedFunction.close();
		connection.close();
		return col;
	}
	
	public void insertColegioElectoral(String codigoColegio, String nombreColegio, String direccionColegio, String circunscripcion) 
	        throws SQLException, ClassNotFoundException{
	    String query = "{call public.colegioelectoral_insert(?, ?, ?, ?)}";
	    java.sql.Connection connection = ServicesLocator.getConnection();
	    CallableStatement callableStatement = connection.prepareCall(query);
	    callableStatement.setString(1, codigoColegio);
	    callableStatement.setString(2, nombreColegio);
	    callableStatement.setString(3, direccionColegio);
	    callableStatement.setString(4, circunscripcion);
	    callableStatement.execute();
	    callableStatement.close();
	    connection.close();
	}
}
