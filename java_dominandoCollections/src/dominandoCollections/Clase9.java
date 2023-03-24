package dominandoCollections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.LinkedList;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import model.*;

public class Clase9 {

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
		Curso curso5 = new Curso("Fisica", 60);
		Curso curso6 = new Curso("Quimica", 80);
		Curso curso7 = new Curso("Geofrafia", 70);
		Curso curso8 = new Curso("Educacion Fisica", 30);

		ArrayList<Curso> listaCursos = new ArrayList<>();
		listaCursos.add(curso1);
		listaCursos.add(curso2);
		listaCursos.add(curso3);
		listaCursos.add(curso4);
		listaCursos.add(curso5);
		listaCursos.add(curso6);
		listaCursos.add(curso7);
		listaCursos.add(curso8);

		List<Curso> cursoLista = listaCursos.stream().sorted(Comparator.comparingInt(Curso::getTiempo)).collect(Collectors.toList());

//		List<Curso> cursoLista = listaCursos.stream().filter(item -> !item.getNombre().equalsIgnoreCase("Historia"))
//				.sorted(Comparator.comparingInt(Curso::getTiempo)).collect(Collectors.toList());
//		System.out.println(cursoLista.stream().mapToInt(Curso::getTiempo).sum());

		System.out.println(cursoLista.stream().mapToInt(Curso::getTiempo).average().getAsDouble());
		System.out.println(cursoLista.stream().mapToInt(Curso::getTiempo).max().getAsInt());
		System.out.println(cursoLista.stream().mapToInt(Curso::getTiempo).min().getAsInt());
	
		Map<String, List<Curso>> groupCurso = listaCursos.stream().collect(Collectors.groupingBy(Curso::getNombre));
		
		groupCurso.forEach((key, value) -> System.out.println(key + value.size()));
		
	}
}
