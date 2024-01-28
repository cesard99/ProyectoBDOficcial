package estruct.services;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import dto.Municipio_DTO;
import dto.Registrer_DTO;
import dto.Reporte1;

public class Reportes_Services {
	/*public ArrayList<Reporte1> selectreporte1() throws SQLException, ClassNotFoundException{
		ArrayList<Reporte1> users = new ArrayList<Reporte1>();
		String function = "{?, = call obtenerlistadoporcircunscripciondada()}";
		java.sql.Connection connection = ServicesLocator.getConnection();
		connection.setAutoCommit(false);
		CallableStatement preparedFunction = connection.prepareCall(function);
		preparedFunction.registerOutParameter(1, java.sql.Types.OTHER);
		preparedFunction.execute();
		ResultSet rs = (ResultSet) preparedFunction.getObject(1);
		while (rs.next()){
			users.add(new Reporte1(rs.getString(1), rs.getString(2), rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7)));
		}
		rs.close();
		preparedFunction.close();
		connection.close();
		return users;
	}*/
	public ArrayList<Reporte1> selectreporte1AllCir() throws SQLException, ClassNotFoundException{
		ArrayList<Reporte1> users = new ArrayList<Reporte1>();
		String function = "{?= call obtenerlistadoporcircunscripcionall()}";
		java.sql.Connection connection = ServicesLocator.getConnection();
		connection.setAutoCommit(false);
		CallableStatement preparedFunction = connection.prepareCall(function);
		preparedFunction.registerOutParameter(1, java.sql.Types.OTHER);
		preparedFunction.execute();
		ResultSet rs = (ResultSet) preparedFunction.getObject(1);
		while (rs.next()){
			users.add(new Reporte1(rs.getString(1), rs.getString(2), rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7)));
		}
		rs.close();
		preparedFunction.close();
		connection.close();
		return users;
	}
	public ArrayList<Reporte1> selectreporte1CirDada2(String nom) throws SQLException, ClassNotFoundException {//OK al palo
	    ArrayList<Reporte1> users = new ArrayList<Reporte1>();
	    String function = "{?= call obtenerlistadoporcircunscripciondada(?)}";
	    java.sql.Connection connection = ServicesLocator.getConnection();
	    connection.setAutoCommit(false);
	    CallableStatement preparedFunction = connection.prepareCall(function);
	    preparedFunction.setString(2, nom); // Pasar el parámetro al procedimiento almacenado
	    preparedFunction.registerOutParameter(1, java.sql.Types.OTHER);
	    preparedFunction.execute();
	    ResultSet rs = (ResultSet) preparedFunction.getObject(1);
	    while (rs.next()) {
	        users.add(new Reporte1(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7)));
	    }
	    rs.close();
	    preparedFunction.close();
	    connection.close();
	    return users;
	}
	public ArrayList<Reporte1> selectreporte1CDRDada(String nom) throws SQLException, ClassNotFoundException{
		ArrayList<Reporte1> users = new ArrayList<Reporte1>();
		String function = "{?= call obtenerlistadopocdrdada(?)}";
		java.sql.Connection connection = ServicesLocator.getConnection();
	    connection.setAutoCommit(false);
	    CallableStatement preparedFunction = connection.prepareCall(function);
	    preparedFunction.setString(2, nom); // Pasar el parámetro al procedimiento almacenado
	    preparedFunction.registerOutParameter(1, java.sql.Types.OTHER);
	    preparedFunction.execute();
	    ResultSet rs = (ResultSet) preparedFunction.getObject(1);
	    while (rs.next()) {
	        users.add(new Reporte1(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7)));
	    }
	    rs.close();
	    preparedFunction.close();
	    connection.close();
	    return users;
	}
	
	}
	
	
	
	
	
	
	
	
	
	
	


