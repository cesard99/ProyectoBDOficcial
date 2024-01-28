package dto;

public class Reporte5 {
private String nomMun;
private String nomCir;
private String nomCol;
private String nomCDR;
private String numVuelta;
private String fecha_hora;
private String numparte;
private String cantElectQVotan;
private String cantElectAdd;
private String cantElectEliminados;
private String totalListadoElectores;
private String cantElectoresVotadParteAnte;

public Reporte5(String nomMun,String nomCir,String nomCol,String nomCDR,String numVuelta,String fecha_hora,String numparte, String cantElectQVotan, String cantElectAdd,String cantElectEliminados,String totalListadoElectores,String cantElectoresVotadParteAnte){
	setCantElectAdd(cantElectAdd);
	setCantElectEliminados(cantElectEliminados);
	setCantElectoresVotadParteAnte(cantElectoresVotadParteAnte);
	setCantElectQVotan(cantElectQVotan);
	setNomCDR(nomCDR);
	setNomCir(nomCir);
	setNomCol(nomCol);
	setNomMun(nomMun);
	setNumparte(numparte);
	setNumVuelta(numVuelta);
	setFecha_hora(fecha_hora);
	setTotalListadoElectores(totalListadoElectores);
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

public String getNomCol() {
	return nomCol;
}

public void setNomCol(String nomCol) {
	this.nomCol = nomCol;
}

public String getNomCDR() {
	return nomCDR;
}

public void setNomCDR(String nomCDR) {
	this.nomCDR = nomCDR;
}

public String getNumVuelta() {
	return numVuelta;
}

public void setNumVuelta(String numVuelta) {
	this.numVuelta = numVuelta;
}

public String getFecha_hora() {
	return fecha_hora;
}

public void setFecha_hora(String fecha_hora) {
	this.fecha_hora = fecha_hora;
}

public String getNumparte() {
	return numparte;
}

public void setNumparte(String numparte) {
	this.numparte = numparte;
}

public String getCantElectQVotan() {
	return cantElectQVotan;
}

public void setCantElectQVotan(String cantElectQVotan) {
	this.cantElectQVotan = cantElectQVotan;
}

public String getCantElectAdd() {
	return cantElectAdd;
}

public void setCantElectAdd(String cantElectAdd) {
	this.cantElectAdd = cantElectAdd;
}

public String getCantElectEliminados() {
	return cantElectEliminados;
}

public void setCantElectEliminados(String cantElectEliminados) {
	this.cantElectEliminados = cantElectEliminados;
}

public String getTotalListadoElectores() {
	return totalListadoElectores;
}

public void setTotalListadoElectores(String totalListadoElectores) {
	this.totalListadoElectores = totalListadoElectores;
}

public String getCantElectoresVotadParteAnte() {
	return cantElectoresVotadParteAnte;
}

public void setCantElectoresVotadParteAnte(String cantElectoresVotadParteAnte) {
	this.cantElectoresVotadParteAnte = cantElectoresVotadParteAnte;
}

}