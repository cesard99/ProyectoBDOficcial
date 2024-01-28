package estruct.util;

import javax.swing.table.DefaultTableModel;

public class CreateReporteResumenMunTablemodel extends DefaultTableModel{
	@SuppressWarnings("serial")
	
			public CreateReporteResumenMunTablemodel(){
				String[] nombreColumnas = {"Municipio","Cantidad Circunscripciones","Cantidad Colegios","Cantidad CDR","Cantidad Total Electores"};
				this.setColumnIdentifiers(nombreColumnas);
			
		
	}
}
