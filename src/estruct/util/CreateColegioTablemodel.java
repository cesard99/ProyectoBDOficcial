package estruct.util;

import javax.swing.table.DefaultTableModel;

public class CreateColegioTablemodel extends DefaultTableModel{
	@SuppressWarnings("serial")
	
			public CreateColegioTablemodel(){
				String[] nombreColumnas = {"Colegio","Codigo","Direccion","Cod Circunscripcion"};
				this.setColumnIdentifiers(nombreColumnas);
			
		
	}
}
