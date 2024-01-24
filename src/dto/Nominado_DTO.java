package dto;

public class Nominado_DTO extends Elector_DTO {
	private String ocupacion;
	private String profesion;
	private String numeroTelef1;
	private String inteRev;
	private String bibliografia;
	
	
	public Nominado_DTO(String nombreApell, String fechaNacimiento,
			String Direccion, int NumConsc, String voto, String ocupacion,String profesion, String numeroTelef,String numeroTelef1 ,String bibliografia, String inteRev) {
		super(nombreApell, fechaNacimiento, Direccion, NumConsc, voto);
		this.ocupacion= ocupacion;
		this.profesion= profesion;
		this.numeroTelef1= numeroTelef1;
		this.inteRev= inteRev;
		this.bibliografia= bibliografia;
		// TODO Auto-generated constructor stub
	}


	public String getOcupacion() {
		return ocupacion;
	}


	public void setOcupacion(String ocupacion) {
		this.ocupacion = ocupacion;
	}


	public String getProfesion() {
		return profesion;
	}


	public void setProfesion(String profesion) {
		this.profesion = profesion;
	}


	public String getNumeroTelef1() {
		return numeroTelef1;
	}


	public void setNumeroTelef1(String numeroTelef1) {
		this.numeroTelef1 = numeroTelef1;
	}


	public String getInteRev() {
		return inteRev;
	}


	public void setInteRev(String inteRev) {
		this.inteRev = inteRev;
	}


	public String getBibliografia() {
		return bibliografia;
	}


	public void setBibliografia(String bibliografia) {
		this.bibliografia = bibliografia;
	}

}
