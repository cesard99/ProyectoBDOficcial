package estruct.util;

import javax.swing.table.DefaultTableModel;

public class createReporte1Tablemodel extends DefaultTableModel{
	@SuppressWarnings("serial")
	
			public createReporte1Tablemodel(){
				String[] nombreColumnas = {"Municipio", "Circunscripcion","Colegio","CDR","CodigoE","Nombre","Direcc"};
				this.setColumnIdentifiers(nombreColumnas);
			
		
	}
}
