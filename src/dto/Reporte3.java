package dto;

public class Reporte3 {
private String nomMun;
private int cantNOM;


public Reporte3(String nomMun,int cantNOM){
	setCantNOM(cantNOM);
	setNomMun(nomMun);
	
}

public String getNomMun() {
	return nomMun;
}

public void setNomMun(String nomMun) {
	this.nomMun = nomMun;
}

public int getCantNOM() {
	return cantNOM;
}

public void setCantNOM(int cantNOM) {
	this.cantNOM = cantNOM;
}

}