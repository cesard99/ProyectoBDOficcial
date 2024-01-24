package dto;

public class ElectorNoVoto_DTO extends Elector_DTO{

    private String causa;

    
    

    public ElectorNoVoto_DTO(String nombreApellido,String fechaNacimiento,String Direccion,int numConsc,String voto,String causa ){
        super(nombreApellido, fechaNacimiento, Direccion,numConsc, voto);
        setCausa(causa);
    }

    public String getCausa() {
        return causa;
    }

    public void setCausa(String causa) {
        this.causa = causa;

    }
}
