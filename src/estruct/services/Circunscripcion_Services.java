package estruct.services;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import dto.Circunscripcion_DTO;

public class Circunscripcion_Services  {

		
		public void insertCir(String userName, String userNick, String userPassword, int roleCode) 
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
		
		public void deleteCir(int userCode) throws SQLException, ClassNotFoundException{
			String query = "SELECT user__delete(?)";
			java.sql.Connection connection = ServicesLocator.getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, userCode);
			preparedStatement.execute();
			preparedStatement.close();
			connection.close();
		}
		
		public void updateCir(int userCode, String userName, String userNick, String userPassword, int roleCode) 
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
		
		
		public Circunscripcion_DTO findCir(int cirCode) throws SQLException, ClassNotFoundException{
			java.sql.Connection connection = ServicesLocator.getConnection();
			Statement statement = connection.createStatement (ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY); 
			String query = "SELECT * FROM user_ WHERE user_.user_code = '"+cirCode+"'"; 
			ResultSet rs = statement.executeQuery(query);
			rs.first();
			Circunscripcion_DTO cir = new Circunscripcion_DTO(rs.getString(1), rs.getString(2),rs.getString(3));
			rs.close();
			statement.close();
			connection.close();
			return cir;
		}
		
		public ArrayList<Circunscripcion_DTO> selectAllCIR() throws SQLException, ClassNotFoundException{
			ArrayList<Circunscripcion_DTO> cir = new ArrayList<Circunscripcion_DTO>();
			String function = "{?= call select_all_circunscripcion()}";
			java.sql.Connection connection = ServicesLocator.getConnection();
			connection.setAutoCommit(false);
			CallableStatement preparedFunction = connection.prepareCall(function);
			preparedFunction.registerOutParameter(1, java.sql.Types.OTHER);
			preparedFunction.execute();
			ResultSet rs = (ResultSet) preparedFunction.getObject(1);
			while (rs.next()){
				cir.add(new Circunscripcion_DTO(rs.getString(1), rs.getString(2),rs.getString(3)));  
			}
			rs.close();
			preparedFunction.close();
			connection.close();
			return cir;
		}
		
		public void insertCircunscripcion(String codigoCircunscripcion, String nombreCircunscripcion, String municipio) 
		        throws SQLException, ClassNotFoundException{
		    String query = "{call public.circunscripcion_insert(?, ?, ?)}";
		    java.sql.Connection connection = ServicesLocator.getConnection();
		    CallableStatement callableStatement = connection.prepareCall(query);
		    callableStatement.setString(1, codigoCircunscripcion);
		    callableStatement.setString(2, nombreCircunscripcion);
		    callableStatement.setString(3, municipio);
		    callableStatement.execute();
		    callableStatement.close();
		    connection.close();
		}
	}
	     
	    




