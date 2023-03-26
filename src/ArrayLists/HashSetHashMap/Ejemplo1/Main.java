package ArrayLists.HashSetHashMap.Ejemplo1;

import java.util.*;

public class Main {
    //Supongamos que tienes una lista de personas y sus edades, y deseas saber cuántas personas tienen una edad específica.
    // En este caso, puedes utilizar un HashMap para almacenar las edades como clave y
    //el número de personas con esa edad como valor.
    //Además, puedes utilizar un HashSet para almacenar las edades únicas de las personas en la lista.

    public static void main(String[] args) {
        ArrayList<Persona> listaPersonas = new ArrayList<>();
        listaPersonas.add(new Persona("Juan", 20));
        listaPersonas.add(new Persona("María", 25));
        listaPersonas.add(new Persona("Pedro", 20));
        listaPersonas.add(new Persona("Lucía", 30));
        listaPersonas.add(new Persona("José", 25));

        // almacenar las edades y el número de personas con esa edad
        HashMap<Integer, Integer> mapEdades = new HashMap<Integer, Integer>();

        // almacenar las edades únicas de las personas en la lista
        HashSet<Integer> setEdades = new HashSet<Integer>();

        for (Persona persona : listaPersonas) {
            // se agrega la edad de la persona al HashSet
            setEdades.add(persona.getEdad());

            // se verifica si la edad ya está en el HashMap
            if (mapEdades.containsKey(persona.getEdad())) {
                // si la edad ya está en el HashMap, se incrementa el contador
                int contador = mapEdades.get(persona.getEdad());
                mapEdades.put(persona.getEdad(), contador + 1);
            } else {
                // si la edad no está en el HashMap, se agrega la edad y se inicializa el contador en 1
                mapEdades.put(persona.getEdad(), 1);
            }
        }


        for (int edad : setEdades) {
            System.out.println("Hay " + mapEdades.get(edad) + " personas con " + edad + " años.");
        }
    }
}

