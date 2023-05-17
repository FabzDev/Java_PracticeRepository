package annotationsJava_Practice.reflexion;

import java.beans.IntrospectionException;
import java.lang.reflect.InvocationTargetException;

public class App {
	public static void main(String[] args)
			throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, IntrospectionException, NoSuchMethodException, SecurityException {

		try {
			
			ResultadoAnalisis resultadoAnalisis = new ResultadoAnalisis();
			resultadoAnalisis.setCantidad("300 ml de agua");
			resultadoAnalisis.setInstrumento("Vaporizador");
			resultadoAnalisis.setResultado("Coeficiente energetico = 120 KJ");

			Comunicado comunicado = new Comunicado();
			comunicado.setDepartamento("Departamento de ingenieria");
			comunicado.setEncabezado("Anuncio estatal");
			comunicado.setMensaje("Todos los estudiantes tienen derecho a presentar examenes suplatorios"
					+ " sin costo si se presenta una excusa valida");

			String[] camposAnalisis = { "instrumento", "cantidad", "resultado" };
			String[] camposComunicado = { "encabezado", "departamento", "mensaje" };

			Reflexion reflex = new Reflexion();

			for (String field : camposAnalisis) {
				System.out.println((String) reflex.callGetter(resultadoAnalisis, field));
			}
			reflex.callMethod(resultadoAnalisis, "method");

			System.out.println("------------------------------------");
			
			for (String field : camposComunicado) {
				System.out.println((String) reflex.callGetter(comunicado, field));
			}
			reflex.callMethod(comunicado, "method");
			
		} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException
				| IntrospectionException e) {
			throw new RuntimeException(e);
		}
	}
}
