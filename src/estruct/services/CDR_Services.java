package estruct.services;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import dto.CDR_DTO;
import dto.Circunscripcion_DTO;

public class CDR_Services {
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
	
	public void deleteCDR(int cdrCode) throws SQLException, ClassNotFoundException{
		String query = "SELECT user__delete(?)";
		java.sql.Connection connection = ServicesLocator.getConnection();
		PreparedStatement preparedStatement = connection.prepareStatement(query);
		preparedStatement.setInt(1, cdrCode);
		preparedStatement.execute();
		preparedStatement.close();
		connection.close();
	}
	
	public void updateCDR(int userCode, String userName, String userNick, String userPassword, int roleCode) 
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
	
	
	public CDR_DTO findCDR(int cdrCode) throws SQLException, ClassNotFoundException{
		java.sql.Connection connection = ServicesLocator.getConnection();
		Statement statement = connection.createStatement (ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY); 
		String query = "SELECT * FROM user_ WHERE user_.user_code = '"+cdrCode+"'"; 
		ResultSet rs = statement.executeQuery(query);
		rs.first();
		CDR_DTO cdr = new CDR_DTO(rs.getString(1),rs.getString(2),rs.getString(3));
		rs.close();
		statement.close();
		connection.close();
		return cdr;
	}
	
	public ArrayList<CDR_DTO> selectAllCDr() throws SQLException, ClassNotFoundException{
		ArrayList<CDR_DTO> cdr = new ArrayList<CDR_DTO>();
		String function = "{?= call select_all_cdr()}";
		java.sql.Connection connection = ServicesLocator.getConnection();
		connection.setAutoCommit(false);
		CallableStatement preparedFunction = connection.prepareCall(function);
		preparedFunction.registerOutParameter(1, java.sql.Types.OTHER);
		preparedFunction.execute();
		ResultSet rs = (ResultSet) preparedFunction.getObject(1);
		while (rs.next()){
			cdr.add(new CDR_DTO(rs.getString(1), rs.getString(2),rs.getString(3)));  
		}
		rs.close();
		preparedFunction.close();
		connection.close();
		return cdr;
	}
}