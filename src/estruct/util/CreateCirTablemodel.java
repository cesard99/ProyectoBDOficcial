package estruct.util;

import javax.swing.table.DefaultTableModel;

public class CreateCirTablemodel extends DefaultTableModel{
	@SuppressWarnings("serial")
	
			public CreateCirTablemodel(){
				String[] nombreColumnas = {"Circunscripcion","Codigo","Cod Municipio"};
				this.setColumnIdentifiers(nombreColumnas);
			
		
	}
}
