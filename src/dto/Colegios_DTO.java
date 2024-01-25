package dto;

import java.util.ArrayList;

public class Colegios_DTO {
	private String codigo;
	private String name;
    private String Direccion;
    private String cirunscrp;
    private ArrayList<Elector_DTO> presentar;

    public Colegios_DTO(String codigo, String name, String Direccion, String codcirunsc) {
        setDireccion(Direccion);
        setCirunscrp(codcirunsc);;
        setPresentar(presentar);
        setCodigo(codigo);
        setName(name);
    }

    public String getDireccion() {
        return Direccion;
    }

    public void setDireccion(String direccion) {
        Direccion = direccion;
    }

    

    public ArrayList<Elector_DTO> getPresentar() {
        return presentar;
    }

    public void setPresentar(ArrayList<Elector_DTO> presentar) {
        this.presentar = presentar;
    }

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCirunscrp() {
		return cirunscrp;
	}

	public void setCirunscrp(String cirunscrp) {
		this.cirunscrp = cirunscrp;
	}

}
