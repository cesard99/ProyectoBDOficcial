package dto;

public class Reporte2 {
private String nomMun;
private String nomCir;
private String monCol;
private String nomCDR;
private String numElec;
private String nomYapELE;
private String dirEle;
private String causa;

public Reporte2(String nomMun,String nomCir,String monCol,String nomCDR,String numElec,String nomYapELE,String dirEle, String causa){
	setDirEle(dirEle);
	setMonCol(monCol);
	setNomCDR(nomCDR);
	setNomCir(nomCir);
	setNomMun(nomMun);
	setNomYapELE(nomYapELE);
	setNumElec(numElec);
	setCausa(causa);
}

public String getNomMun() {
	return nomMun;
}

public void setNomMun(String nomMun) {
	this.nomMun = nomMun;
}

public String getNomCir() {
	return nomCir;
}

public void setNomCir(String nomCir) {
	this.nomCir = nomCir;
}

public String getMonCol() {
	return monCol;
}

public void setMonCol(String monCol) {
	this.monCol = monCol;
}

public String getNomCDR() {
	return nomCDR;
}

public void setNomCDR(String nomCDR) {
	this.nomCDR = nomCDR;
}

public String getNumElec() {
	return numElec;
}

public void setNumElec(String numElec) {
	this.numElec = numElec;
}

public String getNomYapELE() {
	return nomYapELE;
}

public void setNomYapELE(String nomYapELE) {
	this.nomYapELE = nomYapELE;
}

public String getDirEle() {
	return dirEle;
}

public void setDirEle(String dirEle) {
	this.dirEle = dirEle;
}

public String getCausa() {
	return causa;
}

public void setCausa(String causa) {
	this.causa = causa;
}

}
