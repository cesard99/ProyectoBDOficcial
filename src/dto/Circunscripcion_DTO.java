package dto;

import java.util.ArrayList;

public class Circunscripcion_DTO extends Registrer_DTO {

    private Municipio_DTO municipio;
    private ArrayList<Colegios_DTO> ListColegios;

    public Circunscripcion_DTO(String codigo, String Nombre, Municipio_DTO municp, ArrayList<Colegios_DTO> listColeg) {
        super(codigo, Nombre);
        setMunicipio(municp);
        setListColegios(listColeg);

    }

    public Municipio_DTO getMunicipio() {
        return municipio;
    }

    public void setMunicipio(Municipio_DTO municipio) {
        this.municipio = municipio;
    }

    public ArrayList<Colegios_DTO> getListColegios() {
        return ListColegios;
    }

    public void setListColegios(ArrayList<Colegios_DTO> listColegios) {
        ListColegios = listColegios;
    }

}
