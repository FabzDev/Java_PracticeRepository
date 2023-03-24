package dominandoCollections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.LinkedList;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import model.*;

public class Clase10 {

	public static final List<List<Integer>> listas = new ArrayList<List<Integer>>() {
		/**
		 * 
		 */
		private static final long serialVersionUID = 3111572527989089249L;

		{
			add(new LinkedList<>());
			add(new ArrayList<>());
		}
	};

	public static void main(String[] args) {
		Curso curso1 = new Curso("Historia", 30);
		Curso curso2 = new Curso("Algebra", 10);
		Curso curso3 = new Curso("Aritmetica", 20);
		Curso curso4 = new Curso("Geometria", 50);

		ArrayList<Curso> listaCursos = new ArrayList<>();
		listaCursos.add(curso1);
		listaCursos.add(curso2);
		listaCursos.add(curso3);
		listaCursos.add(curso4);

//		System.out.println(listaCursos);
		
		Collections.sort(listaCursos, Comparator.comparing(Curso::getNombre).reversed());
		
		int tiempo = 0;
		for(Curso curso:listaCursos) {
			tiempo += curso.getTiempo();
		}
		System.out.println(tiempo);
		
		
//		listaCursos.sort(Comparator.comparing(Curso::getNombre));
//		Collections.sort(listaCursos, Collections.reverseOrder());

		List<Curso> cursoLista = listaCursos.stream().filter(item -> !item.getNombre().equalsIgnoreCase("Java"))
				.sorted(Comparator.comparingInt(Curso::getTiempo)).collect(Collectors.toList());

		System.out.println(listaCursos.stream().mapToInt(Curso::getTiempo).max().getAsInt());

	}
}
