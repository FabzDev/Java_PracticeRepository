package java_pila_ejecucion;

public class Conexion implements AutoCloseable{

	public Conexion() {
		System.out.println("Iniciando Conexión");
	}

	public void leerDatos() {
		System.out.println("Recibiendo Datos");
		throw new IllegalStateException();

	}

	public void cerrar() {
		System.out.println("Cerrando Conexión");
	}

	@Override
	public void close() throws Exception {
		cerrar();
		
	}

}
