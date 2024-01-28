package estruct.util;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import dto.CDR_DTO;
import estruct.services.CDR_Services;
public class TestConnection {
	private static CDR_Services c = new CDR_Services();
	private static CDR_DTO x;
    public static void main(String[] args) {
        
    	String url = "jdbc:postgresql://localhost:5432/ProyectoEleccion";
        String user = "postgres";
        String password = "1234";

        try {
            Connection connection = DriverManager.getConnection(url, user, password);
            System.out.println("Conexión exitosa a la base de datos PostgreSQL");
            connection.close();
        } catch (SQLException e) {
            System.out.println("Error al conectar a la base de datos PostgreSQL: " + e.getMessage());
        }
try {
    		
			x =c.findCDR(1);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
        
        
        
        
     	
    
}

//("localhost", "ProyectoEleccion", "postgres", "dejesusraul"); 1234