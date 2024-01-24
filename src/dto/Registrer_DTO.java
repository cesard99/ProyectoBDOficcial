package dto;

public class Registrer_DTO {
    protected int codig;
    protected String name;
    protected String Rol;
    protected String pss;
    

    public Registrer_DTO(String name, String pss, String rol, int codig) {
        this.codig = codig;
        this.name = name;
        this.pss=pss;
        this.Rol=rol;
    }


	public int getCodig() {
		return codig;
	}


	public void setCodig(int codig) {
		this.codig = codig;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getRol() {
		return Rol;
	}


	public void setRol(String rol) {
		Rol = rol;
	}


	public String getPss() {
		return pss;
	}


	public void setPss(String pss) {
		this.pss = pss;
	}
}
    