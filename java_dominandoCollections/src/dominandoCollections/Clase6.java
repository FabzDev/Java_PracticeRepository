package dominandoCollections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import model.*;

public class Clase6 {
	
	public static void main(String[] args) {
		Curso curso1 = new Curso("PHP", 30, new ArrayList<>());
		curso1.addClase(new Clase("ArrayList"));
		curso1.addClase(new Clase("List"));
		curso1.addClase(new Clase("LinkedList"));
		
		ArrayList<Curso> cursos = new ArrayList<>();
		cursos.add(curso1);
		
		System.out.println(cursos.get(0).getClaseList());
	}
}
