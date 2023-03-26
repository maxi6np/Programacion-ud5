package ArrayLists.HashSetHashMap;

import java.util.HashMap;
import java.util.Map;

public class EjemploHashMap {
    public static void main(String[] args) {
        // Creamos un HashMap para guardar los nombres y edades de las personas
        HashMap<String, Integer> edades = new HashMap<>();

        // Agregamos algunas personas y sus edades al HashMap
        edades.put("Juan", 25);
        edades.put("María", 30);
        edades.put("Pedro", 40);
        edades.put("Luisa", 35);

        // Imprimimos el HashMap completo
        System.out.println("HashMap completo: " + edades);

        // Obtenemos la edad de María usando el método get()
        int edadMaria = edades.get("María");
        System.out.println("La edad de María es: " + edadMaria);

        // Iteramos sobre todas las personas en el HashMap usando un ciclo for-each
        for (String nombre : edades.keySet()) {
            int edad = edades.get(nombre);
            System.out.println(nombre + " tiene " + edad + " años.");
        }

        // Comprobamos si el HashMap contiene una persona llamada "Juan"
        boolean contieneJuan = edades.containsKey("Juan");
        System.out.println("El HashMap contiene a Juan: " + contieneJuan);

        // Comprobamos si el HashMap contiene alguna persona de 20 años
        boolean contieneVeinte = edades.containsValue(20);
        System.out.println("El HashMap contiene a alguien de 20 años: " + contieneVeinte);

        // Removemos a Pedro del HashMap usando el método remove()
        int edadPedro = edades.remove("Pedro");
        System.out.println("Se ha eliminado a Pedro, que tenía " + edadPedro + " años.");
        System.out.println("HashMap actualizado: " + edades);

        // Obtenemos el número de elementos en el HashMap usando el método size()
        int numPersonas = edades.size();
        System.out.println("El HashMap tiene " + numPersonas + " elementos.");

        // Vaciamos el HashMap usando el método clear()
        edades.clear();
        System.out.println("HashMap vaciado: " + edades);
    }
}
