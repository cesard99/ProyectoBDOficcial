package dto;

public class Reporte6 {
private String nomMun;
private String cantCir;
private String cantCol;
private String cantCDR;
private String cantElect;


public Reporte6(String nomMun,String cantCir,String cantCol,String cantCDR,String cantElect){
	setCantCDR(cantCDR);
	setCantCir(cantCir);
	setCantCol(cantCol);
	setCantElect(cantElect);
	setNomMun(nomMun);
}

public String getNomMun() {
	return nomMun;
}

public void setNomMun(String nomMun) {
	this.nomMun = nomMun;
}

public String getCantCir() {
	return cantCir;
}

public void setCantCir(String cantCir) {
	this.cantCir = cantCir;
}

public String getCantCol() {
	return cantCol;
}

public void setCantCol(String cantCol) {
	this.cantCol = cantCol;
}

public String getCantCDR() {
	return cantCDR;
}

public void setCantCDR(String cantCDR) {
	this.cantCDR = cantCDR;
}

public String getCantElect() {
	return cantElect;
}

public void setCantElect(String cantElect) {
	this.cantElect = cantElect;
}

}