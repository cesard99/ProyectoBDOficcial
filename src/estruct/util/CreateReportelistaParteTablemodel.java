package estruct.util;

import javax.swing.table.DefaultTableModel;

public class CreateReportelistaParteTablemodel extends DefaultTableModel{
	@SuppressWarnings("serial")
	
			public CreateReportelistaParteTablemodel(){
				String[] nombreColumnas = {"Municipio","Circunscripcion","Colegio", "CDR","numero vuelta","Fecha-hora","Numero Parte","Votos total","Electores añadidos","Electores eliminados","Total Elector","total votos parte anterior"};
				this.setColumnIdentifiers(nombreColumnas);
			
		
	}
}
