package dominandoCollections;

import java.util.ArrayList;

public class Clase1 {

    public static void main(String[] args) {
        String var1 = "Ejemplo1";
        String var2 = "Ejemplo2";
        String var3 = "Ejemplo3";
        String var4 = "Ejemplo4";

        ArrayList<String> lista = new ArrayList<String>();
        lista.add(var1);
        lista.add(var2);
        lista.add(var3);
        lista.add(var4);

        System.out.println(lista); // Llamando al metodo toString por defecto
        lista.remove(2); // Eliminar elemento por medio del indice
        lista.set(0, "El vacile punto com"); // Cambiando el contenido de un elemento por medio del indice y el contenido
        System.out.println(lista.size()); // Imprimiendo el valor del tamaño de la lista
        lista.add(2, var3); // Agregando un elemento por medio del indice y el contenido

        System.out.println(lista);


    }

}
