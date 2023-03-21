package dominandoCollections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Clase2 {

	public static void main(String[] args) {
		String curso1 = "Geometría";
		String curso2 = "Física";
		String curso3 = "Química";
		String curso4 = "Historia";

		ArrayList<String> cursos = new ArrayList<String>();
		cursos.add(curso1);
		cursos.add(curso2);
		cursos.add(curso3);
		cursos.add(curso4);
		
//		Collections.sort(cursos); // Ordena alfabeticamente
//		Collections.sort(cursos, Collections.reverseOrder()); // Ordena alfabeticamente en sentido contrario
		
//		cursos.sort(Comparator.naturalOrder()); // Ordena alfabeticamente
//		cursos.sort(Comparator.reverseOrder()); // Ordena alfabeticamente en sentido contrario
		
//		System.out.println(cursos); 
		
		List<String> nuevaLista = cursos.stream().sorted().collect(Collectors.toList()); // Ordena alfabeticamente pero creando un nuevo arreglo, por lo tanto:
		System.out.println(nuevaLista);
		
		
	}
}
