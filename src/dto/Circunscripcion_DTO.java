package dto;

import java.util.ArrayList;

public class Circunscripcion_DTO  {
	private String codigo;
	private String nombre;
    private String codmunicipio;
    private ArrayList<Colegios_DTO> ListColegios;

    public Circunscripcion_DTO(String codigo, String nombre, String codmunicipio){
       this.setCodigo(codigo);
       this.setNombre(nombre);
      this.setCodmunicipio(codmunicipio);
        setListColegios(ListColegios);

    }

    

    public ArrayList<Colegios_DTO> getListColegios() {
        return ListColegios;
    }

    public void setListColegios(ArrayList<Colegios_DTO> listColegios) {
        ListColegios = listColegios;
    }

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}



	public String getCodmunicipio() {
		return codmunicipio;
	}



	public void setCodmunicipio(String codmunicipio) {
		this.codmunicipio = codmunicipio;
	}

}
