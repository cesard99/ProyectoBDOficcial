package estruct.util;

import javax.swing.table.DefaultTableModel;

public class CreateNominadoTablemodel extends DefaultTableModel{
	@SuppressWarnings("serial")
	
			public CreateNominadoTablemodel(){
				String[] nombreColumnas = {"Nombre","Codigo","CodCDR","Ocupacion","Profesion","tefefono","integracionRev","CodCIrcunscripcion","voto","Causa"};
				this.setColumnIdentifiers(nombreColumnas);
			
		
	}
}
