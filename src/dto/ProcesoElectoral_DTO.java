package dto;

public class ProcesoElectoral_DTO {

	private String serial;
	private String numElect;
	private String numCDR;
	private int numVuelt;
	private int cantVotos;
	public ProcesoElectoral_DTO(String serial,String numElect,String numCDR,int numVuelt,int cantVotos) {
		// TODO Auto-generated constructor stub
	}
	public String getSerial() {
		return serial;
	}
	public void setSerial(String serial) {
		this.serial = serial;
	}
	public String getNumElect() {
		return numElect;
	}
	public void setNumElect(String numElect) {
		this.numElect = numElect;
	}
	public String getNumCDR() {
		return numCDR;
	}
	public void setNumCDR(String numCDR) {
		this.numCDR = numCDR;
	}
	public int getNumVuelt() {
		return numVuelt;
	}
	public void setNumVuelt(int numVuelt) {
		this.numVuelt = numVuelt;
	}
	public int getCantVotos() {
		return cantVotos;
	}
	public void setCantVotos(int cantVotos) {
		this.cantVotos = cantVotos;
	}

}
