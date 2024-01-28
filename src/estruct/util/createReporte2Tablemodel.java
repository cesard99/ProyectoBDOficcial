package estruct.util;

import javax.swing.table.DefaultTableModel;

public class createReporte2Tablemodel extends DefaultTableModel{
	@SuppressWarnings("serial")
	
			public createReporte2Tablemodel(){
				String[] nombreColumnas = {"Municipio", "Circunscripcion","Colegio","CDR","CodigoE","Nombre","Direcc","Causa"};
				this.setColumnIdentifiers(nombreColumnas);
			
		
	}
}
