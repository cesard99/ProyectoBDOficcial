package estruct.services;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import dto.CDR_DTO;
import dto.Circunscripcion_DTO;

public class CDR_Services {
	
	public void deleteCDR(String cdrCode) throws SQLException, ClassNotFoundException{
		String query = "SELECT cdr_delete(?)";
		java.sql.Connection connection = ServicesLocator.getConnection();
		PreparedStatement preparedStatement = connection.prepareStatement(query);
		preparedStatement.setString(1, cdrCode);
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
	
	
	/*public CDR_DTO findCDR(int cdrCode) throws SQLException, ClassNotFoundException{
		java.sql.Connection connection = ServicesLocator.getConnection();
		Statement statement = connection.createStatement (ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY); 
		//String query = "SELECT * FROM user_ WHERE user_.user_code = '"+cdrCode+"'";
		String query =  "SELECT * FROM \"CDR\" WHERE \"CDR\".\"codCDR\" = '"+cdrCode+"'";
		ResultSet rs = statement.executeQuery(query);
		rs.first();
		CDR_DTO cdr = new CDR_DTO(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4));
		rs.close();
		statement.close();
		connection.close();
		return cdr;
	}*/
	public CDR_DTO findCDR(int cdrCode) throws SQLException, ClassNotFoundException {
	    java.sql.Connection connection = ServicesLocator.getConnection();
	    Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY); 
	    String query = "SELECT * FROM \"CDR\" WHERE \"CDR\".\"codCDR\" = '" + cdrCode + "'";
	    ResultSet rs = statement.executeQuery(query);
	    if (rs.next()) {
	        CDR_DTO cdr = new CDR_DTO(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4));
	        rs.close();
	        statement.close();
	        connection.close();
	        return cdr;
	    } else {
	        rs.close();
	        statement.close();
	        connection.close();
	        throw new SQLException("No se encontró ninguna fila con el código CDR " + cdrCode);
	    }
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
			cdr.add(new CDR_DTO(rs.getString(1), rs.getString(2),rs.getString(3),rs.getString(4)));  
		}
		rs.close();
		preparedFunction.close();
		connection.close();
		return cdr;
	}
	
	/*public void insertCDR(String codCDR, String nomCDR, String nomPresidente, String codCol) 
	        throws SQLException, ClassNotFoundException{
	    String query = "{call public.cdr_insert(?, ?, ?, ?)}";
	    java.sql.Connection connection = ServicesLocator.getConnection();
	    CallableStatement callableStatement = connection.prepareCall(query);
	    callableStatement.setString(1, codCDR);
	    callableStatement.setString(2, nomCDR);
	    callableStatement.setString(3, nomPresidente);
	    callableStatement.setString(4, codCol);
	    callableStatement.execute();
	    callableStatement.close();
	    connection.close();
	}*/
	public void insertCDR(String codCDR, String nomCDR, String nomPresidente, String codCol) 
	        throws SQLException, ClassNotFoundException{
	    String query = "{call public.cdr_insert(?, ?, ?, ?)}";
	    java.sql.Connection connection = ServicesLocator.getConnection();
	    CallableStatement callableStatement = connection.prepareCall(query);
	    callableStatement.setString(1, codCDR);
	    callableStatement.setString(2, nomCDR);
	    callableStatement.setString(3, nomPresidente);
	    callableStatement.setString(4, codCol);
	    callableStatement.execute();
	    callableStatement.close();
	    
	    // connection.close(); // Comenta esta línea si la conexión se administra en otro lugar
	}
}