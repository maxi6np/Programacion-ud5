package ArrayLists.HashSetHashMap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Ejercicio3 {
    //Supongamos que tienes una lista de estudiantes con sus notas en una clase y
    // deseas saber cuál es la nota promedio para cada estudiante.
    // En este caso, puedes utilizar un HashMap para almacenar los estudiantes como clave
    // y una lista de notas como valor.
    // Además, puedes utilizar un HashSet para almacenar los estudiantes únicos en la lista.

    public static void main(String[] args) {

        List<String> listaEstudiantes = new ArrayList<String>();
        listaEstudiantes.add("Juan:6");
        listaEstudiantes.add("Ana:8");
        listaEstudiantes.add("Juan:7");
        listaEstudiantes.add("Pedro:9");
        listaEstudiantes.add("Pedro:3");
        listaEstudiantes.add("Ana:10");

HashMap<String, List<Integer>> mapEstudiantes = new HashMap<String, List<Integer>>();

        for (String estudiante : listaEstudiantes) {
            String[] partes = estudiante.split(":");
            String nombre = partes[0];
            int nota = Integer.parseInt(partes[1]);

            //se verifica si el nombre esta en el hashmap
            if (mapEstudiantes.containsKey(nombre)){
                // si el estudiante ya está en el HashMap, se agrega la nota a su lista de notas
                List<Integer> notas = mapEstudiantes.get(nombre);
                notas.add(nota);
            }else{
                // si el estudiante no está en el HashMap, se crea una nueva lista de notas y se agrega al HashMap
                List<Integer> notas = new ArrayList<>();
                notas.add(nota);
                mapEstudiantes.put(nombre,notas);
            }
        }

        for (String estudiante : mapEstudiantes.keySet()){
            List<Integer> notas = mapEstudiantes.get(estudiante);
            System.out.println("Estudiante: " + estudiante);
            System.out.print("Notas: ");
            double suma = 0;

            for (int nota : notas){
                System.out.print(nota + " ");
                suma += nota;
            }
            System.out.println();
            double promedio = suma / notas.size();
            System.out.println("Promedio: " + promedio);
            System.out.println("---------------------------");

        }
    }
}
