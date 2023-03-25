package dominandoCollections;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashSet;
public class Clase13 {

	public static void main(String[] args) {
		String alumno1 = "Fabio Escobar";
		String alumno2 = "Yulieth Horta";
		String alumno3 = "Alejandro Escobar";
		String alumno4 = "Gladis Diaz";

		ArrayList<String> listaString = new ArrayList<String>();
		listaString.add(alumno1);
		listaString.add(alumno2);
		listaString.add(alumno3);
		listaString.add(alumno4);
		
		
		Collection <String> listaAlumnos = new HashSet<>();
		
		listaAlumnos.add(alumno1);
		listaAlumnos.add(alumno2);
		listaAlumnos.add(alumno3);
		listaAlumnos.add(alumno4);
		
//		for(String alumno: listaAlumnos) {
//			System.out.println(alumno);
//		}
		
//		listaAlumnos.forEach(alumno -> {
//			System.out.println(alumno);
//		});
		
		boolean valida = listaAlumnos.contains("Alejandro Escobar");
		
		listaAlumnos.stream().max(Comparator.comparingInt(String::length)).get();
		
		System.out.println("\n" + valida);
}
}