package estruct.services;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import dto.Aux_DTO;
import dto.Registrer_DTO;

public class Aux_services {
	public void insertAux(String name) throws SQLException, ClassNotFoundException{
		String query = "SELECT aux_insert(?)";
		java.sql.Connection connection = ServicesLocator.getConnection();
		PreparedStatement preparedStatement = connection.prepareStatement(query);
		preparedStatement.setString(1, name);
		preparedStatement.execute();
		preparedStatement.close();
		connection.close();
	}
	
	public void deleteUser(int id) throws SQLException, ClassNotFoundException{
		String query = "SELECT aux__delete(?)";
		java.sql.Connection connection = ServicesLocator.getConnection();
		PreparedStatement preparedStatement = connection.prepareStatement(query);
		preparedStatement.setInt(1, id);
		preparedStatement.execute();
		preparedStatement.close();
		connection.close();
	}
	public ArrayList<Aux_DTO> selectAllAux() throws SQLException, ClassNotFoundException{
		ArrayList<Aux_DTO> aux = new ArrayList<Aux_DTO>();
		String function = "{?= call select_all_aux()}";
		java.sql.Connection connection = ServicesLocator.getConnection();
		connection.setAutoCommit(false);
		CallableStatement preparedFunction = connection.prepareCall(function);
		preparedFunction.registerOutParameter(1, java.sql.Types.OTHER);
		preparedFunction.execute();
		ResultSet rs = (ResultSet) preparedFunction.getObject(1);
		while (rs.next()){
			aux.add(new Aux_DTO(rs.getInt(1), rs.getString(2)));
		}
		rs.close();
		preparedFunction.close();
		connection.close();
		return aux;
	}
}
