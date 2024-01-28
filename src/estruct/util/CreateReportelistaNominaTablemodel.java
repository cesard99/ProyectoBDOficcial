package estruct.util;

import javax.swing.table.DefaultTableModel;

public class CreateReportelistaNominaTablemodel extends DefaultTableModel{
	@SuppressWarnings("serial")
	
			public CreateReportelistaNominaTablemodel(){
				String[] nombreColumnas = {"Municipio","Circunscripcion","Numero Vuelta", "Nombre","Edad","Integracion Rev","Direcc","telefono","ocupacion","profesion","bibliografia"};
				this.setColumnIdentifiers(nombreColumnas);
			
		//
	}
}
