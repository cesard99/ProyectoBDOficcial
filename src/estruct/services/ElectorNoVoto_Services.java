package estruct.services;

public class ElectorNoVoto_Services extends Elector_Services{

    private String causa;

    
    

    public ElectorNoVoto_Services(String nombreApellido,String fechaNacimiento,String Direccion,int numConsc,String voto,String causa ){
        super();
        setCausa(causa);
    }

    public String getCausa() {
        return causa;
    }

    public void setCausa(String causa) {
        this.causa = causa;

    }
}
