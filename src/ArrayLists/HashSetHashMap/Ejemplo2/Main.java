package ArrayLists.HashSetHashMap.Ejemplo2;

import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class Main {
    //Supongamos que tienes una lista de palabras y deseas saber cuántas veces aparece cada palabra en la lista.
    // En este caso, puedes utilizar un HashMap para almacenar las palabras como clave y
    // el número de veces que aparece cada palabra como valor.
    // Además, puedes utilizar un HashSet para almacenar las palabras únicas en la lista.

    public static void main(String[] args) {
        ArrayList<String> listaPalabras = new ArrayList<String>();
        listaPalabras.add("hola");
        listaPalabras.add("mundo");
        listaPalabras.add("hola");
        listaPalabras.add("java");
        listaPalabras.add("mundo");
        listaPalabras.add("programación");


        // almacenar las palabras y el número de veces que aparece cada palabra
        HashMap<String, Integer> mapPalabras = new HashMap<String, Integer>();

        // almacenar las palabras únicas en la lista
        HashSet<String> setPalabras = new HashSet<>(listaPalabras);

        for (String palabra : setPalabras) {
            int contador = 0;

            // se cuenta el número de veces que aparece cada palabra en la lista
            for (String palabraLista : listaPalabras) {
                if (palabraLista.equals(palabra)){
                    contador++;
                }
                // se agrega la palabra y su contador al HashMap
                mapPalabras.put(palabra, contador);
            }
        }

        for (String palabra : mapPalabras.keySet()) {
            System.out.println("La palabra \"" + palabra + "\" aparece " + mapPalabras.get(palabra) + " veces.");
        }

    }
}

