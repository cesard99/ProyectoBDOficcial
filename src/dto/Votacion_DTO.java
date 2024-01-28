package dto;

public class Votacion_DTO {
	private String codigoV;
	private String numElect;
	private String codCDR;
	private String voto;
	private String causa;
	
	
	
	
	public Votacion_DTO(String codigoV,String numElect,String codCDR,String voto,String causa){
		setCausa(causa);
		setCodCDR(codCDR);
		setCodigoV(codigoV);
		setNumElect(numElect);
		setVoto(voto);
	}




	public String getCodigoV() {
		return codigoV;
	}




	public void setCodigoV(String codigoV) {
		this.codigoV = codigoV;
	}




	public String getNumElect() {
		return numElect;
	}




	public void setNumElect(String numElect) {
		this.numElect = numElect;
	}




	public String getCodCDR() {
		return codCDR;
	}




	public void setCodCDR(String codCDR) {
		this.codCDR = codCDR;
	}




	public String getVoto() {
		return voto;
	}




	public void setVoto(String voto) {
		this.voto = voto;
	}




	public String getCausa() {
		return causa;
	}




	public void setCausa(String causa) {
		this.causa = causa;
	}
}
