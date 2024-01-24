package estruct.util;

public class validaciones {

		
		public static void usuario(String nombre, String usuario, String pass) throws IllegalArgumentException{
			if(nombre != null){
				try{
					noVacio(nombre);
				}
				catch(IllegalArgumentException e){
					throw new IllegalArgumentException("El nombre"+e.getMessage());
				}
			}
			try{
				noVacio(usuario);
			}
			catch(IllegalArgumentException e){
				throw new IllegalArgumentException("El nombre de usuario"+e.getMessage());
			}
			try{
				noVacio(pass);
			}
			catch(IllegalArgumentException e){
				throw new IllegalArgumentException("El campo de la contraseña"+e.getMessage());
			}
		}
		public static void noVacio(String cadena) throws IllegalArgumentException{
			if(cadena.length()>0){
				boolean nombreVacio = true;
				for(int i=0; i<cadena.length() && nombreVacio; i++)
					if(!Character.isSpaceChar(cadena.charAt(i)))
						nombreVacio = false;
				if(nombreVacio)
					throw new IllegalArgumentException(" está vacío");
			}
			else
				throw new IllegalArgumentException(" está vacío");
		}
	}
	



