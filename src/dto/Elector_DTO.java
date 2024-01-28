package dto;

public class Elector_DTO {
	private String CodCDR;
	private String nombreApellido;
    private String fechaNacimiento;
    private String Direccion;
    private String NumConsc;
    private String voto;
    private String causa;
    
    public String getVoto() {
        return voto;
    }

    public void setVoto(String voto) {
        this.voto = voto;
    }

    public Elector_DTO(String nombreApell, String fechaNacimiento, String Direccion,String CodCDR, String NumConsc) {
        setNombreApellido(nombreApell);
        setFechaNacimiento(fechaNacimiento);
        setDireccion(Direccion);
        setNumConsc(NumConsc); 
        setCodCDR(CodCDR);

    }

    public String getNombreApellido() {
        return nombreApellido;
    }

    public void setNombreApellido(String nombreApellido) {
        this.nombreApellido = nombreApellido;
    }

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getDireccion() {
        return Direccion;
    }

    public void setDireccion(String direccion) {
        Direccion = direccion;
    }

    public String getNumConsc() {
        return NumConsc;
    }

    public void setNumConsc(String numConsc) {
        NumConsc = numConsc;
    }

	public String getCausa() {
		return causa;
	}

	public void setCausa(String causa) {
		this.causa = causa;
	}

	public String getCodCDR() {
		return CodCDR;
	}

	public void setCodCDR(String codCDR) {
		CodCDR = codCDR;
	}

}
