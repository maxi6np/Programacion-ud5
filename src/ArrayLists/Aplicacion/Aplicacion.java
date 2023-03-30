package ArrayLists.Aplicacion;

import java.util.HashMap;
import java.util.HashSet;

public class Aplicacion {
    public HashMap<String, HashSet<String>> miDiccionario;

    public Aplicacion() {
        miDiccionario = new HashMap<>();
    }

    public void anadirSinonimo(String palabra, String sinonimo) {

        // Si la palabra ya existe en el diccionario, añade el sinónimo al HashSet correspondiente
        if (miDiccionario.containsKey(palabra)) {
            miDiccionario.get(palabra).add(sinonimo);
        } else {
            // Si la palabra no existe, crea un nuevo HashSet con el sinónimo y lo añade al HashMap
            HashSet<String> sinonimos = new HashSet<>();
            sinonimos.add(sinonimo);
            miDiccionario.put(palabra, sinonimos);
        }
    }

    public boolean borrarSinonimo(String palabra, String sinonimo) {
        //Busca la palabra en el diccinario
        HashSet<String> sinonimos = miDiccionario.get(palabra);

        if (sinonimo != null) {
            //Si encuentra el sinonimo lo borra del grupo correspondiente
            boolean eliminado = sinonimos.remove(sinonimo);
            if (sinonimos.isEmpty()) {
                //Si el conjunto de sinonimos esta vacio, elimina la palabra
                miDiccionario.remove(palabra);
            }
            return eliminado;
        } else {
            //Si no encuentra la palabra, devuelve false
            return false;
        }

    }

    public HashSet<String> obtenerSinonimo(String palabra) {
        return miDiccionario.get(palabra);
    }

    public void anadirDiccionario(HashMap<String, HashSet<String>> diccionario) {

        for (String clave : diccionario.keySet()) {
            HashSet<String> sinonimos = diccionario.get(clave);
            for (String sinonimo: sinonimos) {
                anadirSinonimo(clave,sinonimo);
            }
        }
    }

    public void imprimirDiccionario() {
        for (String palabra : miDiccionario.keySet()) {
            System.out.print(palabra + ": ");
            HashSet<String> sinonimos = miDiccionario.get(palabra);
            for (String sinonimo : sinonimos) {
                System.out.print(sinonimo + " ");
            }
            System.out.println();
        }

    }
}
