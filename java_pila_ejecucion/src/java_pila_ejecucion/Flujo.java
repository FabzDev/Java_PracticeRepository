package java_pila_ejecucion;

public class Flujo {

	public static void main(String[] args) {
		System.out.println("Inicio main");
		try {
			metodo1();
		} catch (Exception e) {

			e.printStackTrace();
		}
		System.out.println("Fin main");
	}

	private static void metodo1() throws FabioExcepcion {
		System.out.println("Inicio metodo1");
		metodo2();
		int a = 50/0;
		Cuenta c = null;
		c.deposita();
		System.out.println("Fin metodo1");
	}

	private static void metodo2() throws FabioExcepcion {
		System.out.println("Inicio metodo2");
		throw new FabioExcepcion("Testeando mensaje: Alejando mi hijo bello");
	}
}
