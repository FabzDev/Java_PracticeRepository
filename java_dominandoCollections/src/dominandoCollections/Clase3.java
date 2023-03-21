package dominandoCollections;

import java.util.ArrayList;

public class Clase3 {

	public static void main(String[] args) {
		String var1 = "Clase1";
		String var2 = "Clase2";
		String var3 = "Clase3";
		String var4 = "Clase4";

		ArrayList<String> listaString = new ArrayList<String>();
		listaString.add(var1);
		listaString.add(var2);
		listaString.add(var3);
		listaString.add(var4);
		
		System.out.println(listaString);

		for(int i=0; i<listaString.size(); i++) {
			System.out.println(listaString.get(i));
		}
		
		for (String item : listaString) {
			System.out.println(item);
		}
		
		System.out.println();
		
		listaString.forEach(item -> {
			System.out.println(item);
		});
	}

}
