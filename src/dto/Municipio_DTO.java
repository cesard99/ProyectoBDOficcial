package dto;

import java.util.ArrayList;

public class Municipio_DTO {
    private String codigo;
    private String name;
	private ArrayList<Circunscripcion_DTO>listaCircunsc;

     public ArrayList<Circunscripcion_DTO> getListaCircunsc() {
          return listaCircunsc;
     }

     public void setListaCircunsc(ArrayList<Circunscripcion_DTO> listaCircunsc) {
          this.listaCircunsc = listaCircunsc;
     }

     public Municipio_DTO(String codigo,String name){
            this.codigo=codigo;
            this.name=name;
            


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

     
    
}
