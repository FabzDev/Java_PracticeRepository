package dominandoCollections;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashSet;
import model.*;

public class Clase14 {

	public static void main(String[] args) {
		Alumno alumno1 = new Alumno("Fabio Andres Escobar", "001");
		Alumno alumno2 = new Alumno("Yulieth Horta", "002");
		Alumno alumno3 = new Alumno("Alejandro Escobar", "003");
		Alumno alumno4 = new Alumno("Gladis Diaz", "004");
		Alumno alumno5 = new Alumno("Fabio Fernando Escobar", "005");
		Alumno alumno6 = new Alumno("Laura Escobar", "006");
		Alumno alumno7 = new Alumno("Giovanni Machado", "007");

		ArrayList<Alumno> listaAlumnos = new ArrayList<>();
		
		listaAlumnos.add(alumno1);
		listaAlumnos.add(alumno2);
		listaAlumnos.add(alumno3);
		listaAlumnos.add(alumno4);
		listaAlumnos.add(alumno5);
		listaAlumnos.add(alumno6);
		listaAlumnos.add(alumno7);

		
		System.out.println(listaAlumnos.contains(alumno7));
	}
}