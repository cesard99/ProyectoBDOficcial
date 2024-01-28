package estruct.services;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;

import dto.Municipio_DTO;
import dto.Registrer_DTO;
import dto.Reporte1;
import dto.Reporte2;
import dto.Reporte3;
import dto.Reporte4;
import dto.Reporte5;

public class Reportes_Services {
	
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
	
	public ArrayList<Reporte2> selectreporte2AllElectNoVoto() throws SQLException, ClassNotFoundException{
		ArrayList<Reporte2> users = new ArrayList<Reporte2>();
		String function = "{?= call listadoelectnovotaron()}";
		java.sql.Connection connection = ServicesLocator.getConnection();
		connection.setAutoCommit(false);
		CallableStatement preparedFunction = connection.prepareCall(function);
		preparedFunction.registerOutParameter(1, java.sql.Types.OTHER);
		preparedFunction.execute();
		ResultSet rs = (ResultSet) preparedFunction.getObject(1);
		while (rs.next()){
			users.add(new Reporte2(rs.getString(1), rs.getString(2), rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7), rs.getString(8)));
		}
		rs.close();
		preparedFunction.close();
		connection.close();
		return users;
	}
	public ArrayList<Reporte2> selectreporte2AllElectNoVotoCir(String nom) throws SQLException, ClassNotFoundException {//OK al palo
	    ArrayList<Reporte2> users = new ArrayList<Reporte2>();
	    String function = "{?= call listadoelectnovotaroncircunsdada(?)}";
	    java.sql.Connection connection = ServicesLocator.getConnection();
	    connection.setAutoCommit(false);
	    CallableStatement preparedFunction = connection.prepareCall(function);
	    preparedFunction.setString(2, nom); // Pasar el parámetro al procedimiento almacenado
	    preparedFunction.registerOutParameter(1, java.sql.Types.OTHER);
	    preparedFunction.execute();
	    ResultSet rs = (ResultSet) preparedFunction.getObject(1);
	    while (rs.next()) {
	        users.add(new Reporte2(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8)));
	    }
	    rs.close();
	    preparedFunction.close();
	    connection.close();
	    return users;
	}
	public ArrayList<Reporte2> selectreporte2AllElectNoVotoMun(String nom) throws SQLException, ClassNotFoundException {//OK al palo
	    ArrayList<Reporte2> users = new ArrayList<Reporte2>();
	    String function = "{?= call listadoelectnovotaronmundada(?)}";
	    java.sql.Connection connection = ServicesLocator.getConnection();
	    connection.setAutoCommit(false);
	    CallableStatement preparedFunction = connection.prepareCall(function);
	    preparedFunction.setString(2, nom); // Pasar el parámetro al procedimiento almacenado
	    preparedFunction.registerOutParameter(1, java.sql.Types.OTHER);
	    preparedFunction.execute();
	    ResultSet rs = (ResultSet) preparedFunction.getObject(1);
	    while (rs.next()) {
	        users.add(new Reporte2(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8)));
	    }
	    rs.close();
	    preparedFunction.close();
	    connection.close();
	    return users;
	}
	public ArrayList<Reporte2> selectreporte2AllElectNoVotoCDR(String nom) throws SQLException, ClassNotFoundException {//OK al palo
	    ArrayList<Reporte2> users = new ArrayList<Reporte2>();
	    String function = "{?= call listadoelectnovotaroncdrdada(?)}";
	    java.sql.Connection connection = ServicesLocator.getConnection();
	    connection.setAutoCommit(false);
	    CallableStatement preparedFunction = connection.prepareCall(function);
	    preparedFunction.setString(2, nom); // Pasar el parámetro al procedimiento almacenado
	    preparedFunction.registerOutParameter(1, java.sql.Types.OTHER);
	    preparedFunction.execute();
	    ResultSet rs = (ResultSet) preparedFunction.getObject(1);
	    while (rs.next()) {
	        users.add(new Reporte2(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8)));
	    }
	    rs.close();
	    preparedFunction.close();
	    connection.close();
	    return users;
	}
	public ArrayList<Reporte3> selectreporte3MunCantNom() throws SQLException, ClassNotFoundException{
		ArrayList<Reporte3> users = new ArrayList<Reporte3>();
		String function = "{?= call listadomunicipiomasnominado()}";
		java.sql.Connection connection = ServicesLocator.getConnection();
		connection.setAutoCommit(false);
		CallableStatement preparedFunction = connection.prepareCall(function);
		preparedFunction.registerOutParameter(1, java.sql.Types.OTHER);
		preparedFunction.execute();
		ResultSet rs = (ResultSet) preparedFunction.getObject(1);
		while (rs.next()){
			users.add(new Reporte3(rs.getString(1), rs.getInt(2)));
		}
		rs.close();
		preparedFunction.close();
		connection.close();
		return users;
	}
	
	public ArrayList<Reporte4> selectreporte4ListNom() throws SQLException, ClassNotFoundException {//OK al palo
	    ArrayList<Reporte4> users = new ArrayList<Reporte4>();
	    String function = "{?= call listadonominados()}";
	    java.sql.Connection connection = ServicesLocator.getConnection();
	    connection.setAutoCommit(false);
	    CallableStatement preparedFunction = connection.prepareCall(function);
	    preparedFunction.registerOutParameter(1, java.sql.Types.OTHER);
	    preparedFunction.execute();
	    ResultSet rs = (ResultSet) preparedFunction.getObject(1);
	    while (rs.next()) {
	        users.add(new Reporte4(rs.getString(1), rs.getString(2), Integer.toString(rs.getInt(3)), rs.getString(4), Integer.toString(rs.getInt(5)), rs.getString(6), rs.getString(7), Integer.toString(rs.getInt(8)),rs.getString(9),rs.getString(10),rs.getString(11)));
	    }
	    rs.close();
	    preparedFunction.close();
	    connection.close();
	    return users;
	}
	
	public ArrayList<Reporte5> selectreporte5ListPart() throws SQLException, ClassNotFoundException {//OK al palo
	    ArrayList<Reporte5> users = new ArrayList<Reporte5>();
	    String function = "{?= call listadoparte()}";
	    java.sql.Connection connection = ServicesLocator.getConnection();
	    connection.setAutoCommit(false);
	    CallableStatement preparedFunction = connection.prepareCall(function);
	    preparedFunction.registerOutParameter(1, java.sql.Types.OTHER);
	    preparedFunction.execute();
	    ResultSet rs = (ResultSet) preparedFunction.getObject(1);
	    while (rs.next()) {
	        users.add(new Reporte5(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), Integer.toString(rs.getInt(5)), rs.getTimestamp(6).toString(), Integer.toString(rs.getInt(7)), Integer.toString(rs.getInt(8)),Integer.toString(rs.getInt(9)),Integer.toString(rs.getInt(10)),Integer.toString(rs.getInt(11)), Integer.toString(rs.getInt(12))));
	    }
	    rs.close();
	    preparedFunction.close();
	    connection.close();
	    return users;
	}
	
	
	
	}
	
	
	
	
	
	
	
	
	
	
	


