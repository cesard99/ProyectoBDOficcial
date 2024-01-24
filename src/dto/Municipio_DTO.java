package dto;

import java.util.ArrayList;

public class Municipio_DTO {
     private ArrayList<Circunscripcion_DTO>listaCircunsc;

     public ArrayList<Circunscripcion_DTO> getListaCircunsc() {
          return listaCircunsc;
     }

     public void setListaCircunsc(ArrayList<Circunscripcion_DTO> listaCircunsc) {
          this.listaCircunsc = listaCircunsc;
     }

     public Municipio_DTO(String codigo,String name,ArrayList<Circunscripcion_DTO>List){
            setListaCircunsc(List);


     }

     
    
}
