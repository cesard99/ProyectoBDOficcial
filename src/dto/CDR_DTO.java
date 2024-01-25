package dto;

import java.util.ArrayList;

public class CDR_DTO  {
    private String PresidentName;
    private ArrayList<Integer> Elect;
    private String codigo;
    private String codigoCole;
    private String name;
    
    public CDR_DTO(String codigo, String name, String nombPresidente) {
        setPresidentName(nombPresidente);
        setElect(Elect);
        setCodigo(codigo);
        setName(name);

    }

    public String getPresidentName() {
        return PresidentName;
    }

    public void setPresidentName(String presidentName) {
        PresidentName = presidentName;
    }

    public ArrayList<Integer> getElect() {
        return Elect;
    }

    public void setElect(ArrayList<Integer> elect) {
        Elect = elect;
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

	public String getCodigoCole() {
		return codigoCole;
	}

	public void setCodigoCole(String codigoCole) {
		this.codigoCole = codigoCole;
	}

}
