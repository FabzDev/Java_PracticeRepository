package dominandoCollections;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import model.*;

public class Clase4 {
	
	public static void main(String[] args) {
		Curso curso1 = new Curso("Geometría", 30);
		Curso curso2 = new Curso("Física", 10);
		Curso curso3 = new Curso("Química", 20);
		Curso curso4 = new Curso("historia", 50);
		
		ArrayList<Curso> listaCursos = new ArrayList<>();
		listaCursos.add(curso1);
		listaCursos.add(curso2);
		listaCursos.add(curso3);
		listaCursos.add(curso4);
		
//		ArrayList<String> listaNombresCursos = new ArrayList<>();
//		listaNombresCursos.add(curso1.getNombre());
//		listaNombresCursos.add(curso2.getNombre());
//		listaNombresCursos.add(curso3.getNombre());
//		listaNombresCursos.add(curso4.getNombre());
		
		
		
		System.out.println(listaCursos.toString());
	}
}
