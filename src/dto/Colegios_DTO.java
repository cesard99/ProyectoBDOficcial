package dto;

import java.util.ArrayList;

public class Colegios_DTO {

    private String Direccion;
    private Circunscripcion_DTO cirunscrp;
    private ArrayList<Elector_DTO> presentar;

    public Colegios_DTO(String codigo, String name, String Direccion, Circunscripcion_DTO cirunsc,
            ArrayList<Elector_DTO> ListaPresentar) {
        setDireccion(Direccion);
        setCirunscrp(cirunsc);;
        setPresentar(ListaPresentar);
    }

    public String getDireccion() {
        return Direccion;
    }

    public void setDireccion(String direccion) {
        Direccion = direccion;
    }

    public Circunscripcion_DTO getCirunscrp() {
        return cirunscrp;
    }

    public void setCirunscrp(Circunscripcion_DTO cirunscrp) {
        this.cirunscrp = cirunscrp;
    }

    public ArrayList<Elector_DTO> getPresentar() {
        return presentar;
    }

    public void setPresentar(ArrayList<Elector_DTO> presentar) {
        this.presentar = presentar;
    }

}
