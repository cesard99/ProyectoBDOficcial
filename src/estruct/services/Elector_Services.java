package estruct.services;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;

import dto.Elector_DTO;
import dto.Registrer_DTO;

public class Elector_Services {
	public void insertElector(String codCDR, String numelect, String nombre, String direc, Date date) 
			throws SQLException, ClassNotFoundException{
		String query = "SELECT elector_insert(?,?,?,?,?)";
		java.sql.Connection connection = ServicesLocator.getConnection();
		PreparedStatement preparedStatement = connection.prepareStatement(query);
		preparedStatement.setString(1, codCDR);
		preparedStatement.setString(2, numelect);
		preparedStatement.setString(3, nombre);
		preparedStatement.setString(4, direc);
		preparedStatement.setDate(5, new java.sql.Date(date.getTime()));
		preparedStatement.execute();
		preparedStatement.close();
		connection.close();
	}
	
	public void deleteUser(int userCode) throws SQLException, ClassNotFoundException{
		String query = "SELECT users__delete(?)";
		java.sql.Connection connection = ServicesLocator.getConnection();
		PreparedStatement preparedStatement = connection.prepareStatement(query);
		preparedStatement.setInt(1, userCode);
		preparedStatement.execute();
		preparedStatement.close();
		connection.close();
	}
	
	public void updateUser(String usser, String userpass, String rol, int code) 
			throws SQLException, ClassNotFoundException{
		String query = "SELECT users__update(?,?,?,?,?)";
		java.sql.Connection connection = ServicesLocator.getConnection();
		PreparedStatement preparedStatement = connection.prepareStatement(query);
		preparedStatement.setString(1, usser);
		preparedStatement.setString(2, userpass);
		preparedStatement.setString(3, rol);
		preparedStatement.setInt(4, code);
		preparedStatement.execute();
		preparedStatement.close();
		connection.close();
	}
	
	public void updateUserWithoutPassword(int userCode, String userName, String userNick, int roleCode) 
			throws SQLException, ClassNotFoundException{
		String query = "SELECT users__update_without_password(?,?,?,?)";
		java.sql.Connection connection = ServicesLocator.getConnection();
		PreparedStatement preparedStatement = connection.prepareStatement(query);
		preparedStatement.setInt(1, userCode);
		preparedStatement.setString(2, userName);
		preparedStatement.setString(3, userNick);
		preparedStatement.setInt(4, roleCode);
		preparedStatement.execute();
		preparedStatement.close();
		connection.close();
	}
	
	public Registrer_DTO findUser(int userCode) throws SQLException, ClassNotFoundException{
		java.sql.Connection connection = ServicesLocator.getConnection();
		Statement statement = connection.createStatement (ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY); 
		String query = "SELECT * FROM users_ WHERE users_.users_code = '"+userCode+"'"; 
		ResultSet rs = statement.executeQuery(query);
		rs.first();
		Registrer_DTO user = new Registrer_DTO(rs.getString(1), rs.getString(2), rs.getString(3), rs.getInt(4));                 //(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getInt(5)); 
		rs.close();
		statement.close();
		connection.close();
		return user;
	}
	
	public ArrayList<Elector_DTO> selectAllElect() throws SQLException, ClassNotFoundException{
		ArrayList<Elector_DTO> users = new ArrayList<Elector_DTO>();
		String function = "{?= call select_all_elector()}";
		java.sql.Connection connection = ServicesLocator.getConnection();
		connection.setAutoCommit(false);
		CallableStatement preparedFunction = connection.prepareCall(function);
		preparedFunction.registerOutParameter(1, java.sql.Types.OTHER);
		preparedFunction.execute();
		ResultSet rs = (ResultSet) preparedFunction.getObject(1);
		while (rs.next()){
			users.add(new Elector_DTO(rs.getString(3), rs.getString(5).toString(), rs.getString(4), rs.getString(1), rs.getString(2)));
		}
		rs.close();
		preparedFunction.close();
		connection.close();
		return users;
	}
}

