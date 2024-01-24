package estruct.util;

import javax.swing.table.DefaultTableModel;

@SuppressWarnings("serial")
public class CreateUserTablemodel extends DefaultTableModel {
		public CreateUserTablemodel(){
			String[] nombreColumnas = {"Usuario", "Rol"};
			this.setColumnIdentifiers(nombreColumnas);
		
	}
}
