package annotationsJava_Practice;

public class Producto {
	String nombre;
	
	public boolean usuarioValido(Usuario usuario){
		   if(!usuario.getNombre().matches("[a-zA-Záàâãéèêíïóôõöúçñ\\s]+")){
		      return false;
		   }
		  
		   return true;
		}
}
