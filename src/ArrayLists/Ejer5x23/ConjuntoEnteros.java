package ArrayLists.Ejer5x23;

import java.util.HashSet;
import java.util.Iterator;

public class ConjuntoEnteros {
    public static void main(String[] args) {
        ConjuntoEnteros c = new ConjuntoEnteros(5);

        c.addNumeros(2);
        c.addNumeros(3);
        c.addNumeros(4);
        c.addNumeros(5);
        c.addNumeros(6);

        c.borrarPares();
        c.printConjunto();
    }
    HashSet<Integer> enteros;

    public ConjuntoEnteros(int tamanio) {
        enteros = new HashSet<>(tamanio);
    }

    public HashSet<Integer> getPares() {
        HashSet<Integer> pares = new HashSet<Integer>();
        Iterator<Integer> it = enteros.iterator();

        while (it.hasNext()) {
            int numero = it.next();
            if (numero % 2 == 0) {
                pares.add(numero);
            }
        }
        return pares;
    }

    public void addNumeros(int n) {
        enteros.add(n);
    }

    public void printConjunto() {
        for (int numero : enteros) {
            System.out.println(numero);
        }
    }

    public void borrarPares() {
        Iterator<Integer> it = enteros.iterator();

        while (it.hasNext()) {
            int numero = it.next();
            if (numero % 2 == 0) {
                it.remove();
            }
        }
    }


}
