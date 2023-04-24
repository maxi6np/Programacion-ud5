package ArrayLists.HashSetHashMap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class Ejercicio2 {
    //Supongamos que tienes una lista de palabras y deseas saber cuántas veces aparece cada palabra en la lista.
    //En este caso, puedes utilizar un HashMap para almacenar las palabras como clave y
    //el número de veces que aparece cada palabra como valor.
    //Además, puedes utilizar un HashSet para almacenar las palabras únicas en la lista.

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


        for (String palabra : listaPalabras) {
            int contador = 0;

            for (String palabraLista : listaPalabras) {
                if (palabraLista.equals(palabra)){
                    contador++;
                }
                mapPalabras.put(palabra, contador);
            }
        }

        for (String palabra : mapPalabras.keySet()) {
            System.out.println("La palabra \"" + palabra + "\" aparece " + mapPalabras.get(palabra) + " veces.");
        }

    }
}

