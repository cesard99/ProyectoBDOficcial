package estruct.services;



import java.sql.SQLException;
import estruct.util.Connection;




public class ServicesLocator {
	private static CDR_Services CDR_Services = null;
	private static Circunscripcion_Services Circunscripcion_Services = null;
	private static Colegios_Services Colegios_Services = null;
	private static Elector_Services Elector_Services = null;
	private static ElectorNoVoto_Services ElecNoVoto_Services = null;
	private static Municipio_Services Municipio_Services = null;
	private static Nominado_Services Nominado_Services = null;
	public static Parte_Services Parte_Services = null;
	public static Registrer_Services registrer_Services = null;
	public static ProcesoElectoral_services ProcesoElectoral_services = null;
	
	public static CDR_Services getCDR_Services(){
		if(CDR_Services == null)
			CDR_Services = new CDR_Services(null, null, null, null);
		return CDR_Services;
	}
	public static Circunscripcion_Services getCircunscripcion_Services(){
		if(Circunscripcion_Services == null)
			Circunscripcion_Services = new Circunscripcion_Services(null, null, null, null);
		return Circunscripcion_Services;
	}
	public static Colegios_Services getColegios_Services(){
		if(Colegios_Services == null)
			Colegios_Services = new Colegios_Services(null, null, null, null, null);
		return Colegios_Services;
	}
	
	public static Elector_Services getElector_Services(){
		if(Elector_Services == null)
			Elector_Services = new Elector_Services(null, null, null, 0, null);
		return Elector_Services;
	}
	public static ElectorNoVoto_Services getElectorNoVoto_Services(){
		if(ElecNoVoto_Services == null)
			ElecNoVoto_Services = new ElectorNoVoto_Services(null, null, null, 0, null, null);
		return ElecNoVoto_Services;
	}
	public static Municipio_Services getMunicipio_Services(){
		if(Municipio_Services == null)
			Municipio_Services = new Municipio_Services(null, null, null);
		return Municipio_Services;
	}
	public static Nominado_Services getNominado_Services(){
		if(Nominado_Services == null)
			Nominado_Services = new Nominado_Services(null, null, null, 0, null, null, null, null, null, null, null);
		return Nominado_Services;
	}
	public static Parte_Services getParte_Services(){
		if(Parte_Services == null)
			Parte_Services = new Parte_Services(null, null, 0, 0, 0, 0);
		return Parte_Services;
	}
	public static Registrer_Services getRegistrer_Services(){
		if(registrer_Services == null)
			registrer_Services = new Registrer_Services() ;
		return registrer_Services;
	}
	
	public static ProcesoElectoral_services getProcesoElectoral_services(){
		if(ProcesoElectoral_services == null)
			ProcesoElectoral_services = new ProcesoElectoral_services(null, null, null, 0, 0) ;
		return ProcesoElectoral_services;
	}
	
	public static java.sql.Connection getConnection(){
		Connection connection = null;
		try {
			connection = new Connection("localhost", "ProyectoEleccion", "postgres", "1234");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return connection.getConnection();
	}
	
	
	
}