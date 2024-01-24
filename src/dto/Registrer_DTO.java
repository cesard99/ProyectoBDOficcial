package dto;

public class Registrer_DTO {
    protected String codig;
    protected String name;

    public Registrer_DTO(String codigo, String name) {
        this.codig = codigo;
        this.name = name;
    }

    public String getCodigo() {
        return codig;
    }

    public String getName() {
        return name;
    }

}
