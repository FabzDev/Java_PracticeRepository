package dominandoCollections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class Clase5 {
	
	public static void main(String[] args) {
		Curso curso1 = new Curso("Java", 30);
		Curso curso2 = new Curso("JavaScript", 10);
		Curso curso3 = new Curso("PHP", 20);
		Curso curso4 = new Curso("Ruby", 50);
		
		ArrayList<Curso> listaCursos = new ArrayList<>();
		listaCursos.add(curso1);
		listaCursos.add(curso3);
		listaCursos.add(curso4);
		listaCursos.add(curso2);
				
		
		System.out.println(listaCursos);
		
//		listaCursos.sort(Comparator.comparing(Curso::getNombre));
//		Collections.sort(listaCursos, Collections.reverseOrder());
//		Collections.sort(listaCursos, Comparator.comparing(Curso::getNombre));
		
		List<Curso> listaCursos2 = listaCursos.stream().filter(item -> !item.getNombre().equalsIgnoreCase("Java")).sorted(Comparator.comparingInt(Curso::getTiempo)).collect(Collectors.toList());
		
		System.out.println(listaCursos2);
		
		
	}
}
