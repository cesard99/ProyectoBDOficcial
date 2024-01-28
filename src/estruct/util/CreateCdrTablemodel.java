package estruct.util;

import javax.swing.table.DefaultTableModel;

public class CreateCdrTablemodel extends DefaultTableModel{
	@SuppressWarnings("serial")
	
			public CreateCdrTablemodel(){
				String[] nombreColumnas = {"CDR","Codigo","nombre Presidente", "Codigo colegio"};
				this.setColumnIdentifiers(nombreColumnas);
			
		
	}
}
