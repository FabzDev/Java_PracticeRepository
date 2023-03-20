package java_pila_ejecucion;

public class TestConexion {

	public static void main(String[] args) {
				
		try(Conexion c = new Conexion()){
			c.leerDatos();
		}catch(Exception e) {
			System.out.println("Catched");
			e.printStackTrace();
		}
		
		/*
		try {
			con = new Conexion();
			con.leerDatos();			
		} catch (Exception e) {
			System.out.println("Catch them all!");
			e.printStackTrace();
		} finally {
			if(con!=null) {
				con.cerrar();				
			}
			
		}
		*/
		
	}
}
