package ArrayLists.HashSetHashMap;

import java.util.HashSet;
import java.util.Iterator;

public class EjemploHashSet {
    public static void main(String[] args) {
        // Creamos un HashSet para guardar algunos números
        HashSet<Integer> numeros = new HashSet<>();

        // Agregamos algunos números al HashSet
        numeros.add(3);
        numeros.add(6);
        numeros.add(2);
        numeros.add(9);
        numeros.add(1);

        // Imprimimos el HashSet completo
        System.out.println("HashSet completo: " + numeros);

        // Comprobamos si el HashSet contiene el número 6
        boolean contieneSeis = numeros.contains(6);
        System.out.println("El HashSet contiene el número 6: " + contieneSeis);

        // Removemos el número 2 del HashSet usando el método remove()
        boolean removido = numeros.remove(2);
        System.out.println("Se ha eliminado el número 2: " + removido);
        System.out.println("HashSet actualizado: " + numeros);

        // Iteramos sobre todos los elementos en el HashSet usando un iterador
        System.out.print("Elementos del HashSet: ");
        Iterator<Integer> iterador = numeros.iterator();
        while (iterador.hasNext()) {
            int numero = iterador.next();
            System.out.print(numero + " ");
        }
        System.out.println();

        // Vaciamos el HashSet usando el método clear()
        numeros.clear();
        System.out.println("HashSet vaciado: " + numeros);
    }
}
