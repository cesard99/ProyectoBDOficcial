package dto;

public class Nominado_DTO {
	private String ocupacion;
	private String profesion;
	private int numeroTelef1;
	private String inteRev;
	private String bibliografia;
	private String NumConsc;
	private String CodCDR;
	private String CodCir;
	
	public Nominado_DTO( String NumConsc,String CodCDR, String ocupacion,String profesion,int numeroTelef1 ,String bibliografia, String inteRev,String CodCir){
		this.setOcupacion(ocupacion);
		this.setProfesion(profesion);
		this.setNumeroTelef1(numeroTelef1);
		this.setInteRev(inteRev);
		this.setBibliografia(bibliografia);
		this.setNumConsc(NumConsc);
		this.setCodCDR(CodCDR);
		this.setCodCir(CodCir);
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


	public int getNumeroTelef1() {
		return numeroTelef1;
	}


	public void setNumeroTelef1(int numeroTelef1) {
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


	public String getNumConsc() {
		return NumConsc;
	}


	public void setNumConsc(String numConsc) {
		NumConsc = numConsc;
	}


	public String getCodCDR() {
		return CodCDR;
	}


	public void setCodCDR(String codCDR) {
		CodCDR = codCDR;
	}


	public String getCodCir() {
		return CodCir;
	}


	public void setCodCir(String codCir) {
		CodCir = codCir;
	}

}
