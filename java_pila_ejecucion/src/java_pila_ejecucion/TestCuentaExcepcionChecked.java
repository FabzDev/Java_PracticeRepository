package java_pila_ejecucion;

public class TestCuentaExcepcionChecked {
	public static void main(String[] args) {
		Cuenta cuenta1 = new Cuenta();
		try {
			cuenta1.deposita();
		} catch (FabioExcepcion e) {
			e.printStackTrace();
		}
	}
}
