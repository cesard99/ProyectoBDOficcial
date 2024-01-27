package estruct.util;

import javax.swing.table.DefaultTableModel;

public class CreateReporteResuProcesoTablemodel extends DefaultTableModel{
	@SuppressWarnings("serial")
	
			public CreateReporteResuProcesoTablemodel(){
				String[] nombreColumnas = {"Municipio","Circunscripcion","Colegio", "CDR","numero vuelta","Fecha-hora","Total Electores","Cantidad Votar","Total elect + Agregado","% voto","No Votaron","Eliminados","No voto por estar en Extranjero", "Fuera Provincia","Hospitalizado","Trabajando","Otras Causas","Desconocido"};
				this.setColumnIdentifiers(nombreColumnas);
			
		
	}
}
