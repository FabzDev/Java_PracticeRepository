package dominandoCollections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import model.*;

public class Clase7 {
	
	public static void main(String[] args) {
		Curso curso1 = new Curso("PHP", 30);
		curso1.addAula(new Aula("ArrayList"));
		curso1.addAula(new Aula("List"));
		curso1.addAula(new Aula("LinkedList"));
		curso1.addAula(new Aula("Inmutable"));
		
		List<Aula> aulaList = curso1.getAulaList();
		
//		aulaList.add(new Aula("Inmutable"));
		
		ArrayList<Curso> cursos = new ArrayList<>();
		cursos.add(curso1);
		
		System.out.println(aulaList);
	}
}
