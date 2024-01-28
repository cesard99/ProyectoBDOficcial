package estruct.util;

import javax.swing.table.DefaultTableModel;

public class CreateElectTablemodel extends DefaultTableModel{
	@SuppressWarnings("serial")
	
			public CreateElectTablemodel(){
				String[] nombreColumnas = {"Nombre","Codigo","CodCDR","Direccion","Fecha-Naciemiento","voto","Causa"};
				this.setColumnIdentifiers(nombreColumnas);
			
		
	}
}
