package estruct.util;

import javax.swing.table.DefaultTableModel;

public class CreateMunicipioTablemodel extends DefaultTableModel{
	@SuppressWarnings("serial")
	
			public CreateMunicipioTablemodel(){
				String[] nombreColumnas = {"Municipio","Codigo"};
				this.setColumnIdentifiers(nombreColumnas);
			
		
	}
}
