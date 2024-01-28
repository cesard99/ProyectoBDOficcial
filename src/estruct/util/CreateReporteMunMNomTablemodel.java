package estruct.util;

import javax.swing.table.DefaultTableModel;

public class CreateReporteMunMNomTablemodel extends DefaultTableModel{
	@SuppressWarnings("serial")
	
			public CreateReporteMunMNomTablemodel(){
				String[] nombreColumnas = {"Municipio","Cantidad Nominado"};
				this.setColumnIdentifiers(nombreColumnas);
			
		
	}
}
