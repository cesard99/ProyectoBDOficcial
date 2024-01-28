package dto;

public class Reporte4 {
private String nomMun;
private String nomCir;
private String numVuelta;
private String nomYapELE;
private String edad;
private String integraRev;
private String dirEle;
private String telefono;
private String ocupacion;
private String profecion;
private String biblio;

public Reporte4(String nomMun,String nomCir,String numVuelta,String nomYapELE,String edad,String integraRev,String dirEle, String telefono, String ocupacion,String profecion,String biblio){
	setBiblio(biblio);
	setDirEle(dirEle);
	setEdad(edad);
	setIntegraRev(integraRev);
	setNomCir(nomCir);
	setNomMun(nomMun);
	setNomYapELE(nomYapELE);
	setNumVuelta(numVuelta);
	setOcupacion(ocupacion);
	setProfecion(profecion);
	setTelefono(telefono);
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

public String getNumVuelta() {
	return numVuelta;
}

public void setNumVuelta(String numVuelta) {
	this.numVuelta = numVuelta;
}

public String getNomYapELE() {
	return nomYapELE;
}

public void setNomYapELE(String nomYapELE) {
	this.nomYapELE = nomYapELE;
}

public String getEdad() {
	return edad;
}

public void setEdad(String edad) {
	this.edad = edad;
}

public String getIntegraRev() {
	return integraRev;
}

public void setIntegraRev(String integraRev) {
	this.integraRev = integraRev;
}

public String getDirEle() {
	return dirEle;
}

public void setDirEle(String dirEle) {
	this.dirEle = dirEle;
}

public String getTelefono() {
	return telefono;
}

public void setTelefono(String telefono) {
	this.telefono = telefono;
}

public String getOcupacion() {
	return ocupacion;
}

public void setOcupacion(String ocupacion) {
	this.ocupacion = ocupacion;
}

public String getProfecion() {
	return profecion;
}

public void setProfecion(String profecion) {
	this.profecion = profecion;
}

public String getBiblio() {
	return biblio;
}

public void setBiblio(String biblio) {
	this.biblio = biblio;
}
}

