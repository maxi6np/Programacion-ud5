package ArraysBidimensionales.Ejer5x11;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        final String strComienzo = "aL";
        final char chrComienzo = 'a';
        final char borrarLetra = 'r';

        ListaNombres lista = new ListaNombres();
        lista.insertarNombre("maximo");
        lista.insertarNombre("Agustina");
        lista.insertarNombre("Marcos Aurelio");
        lista.insertarNombre("AlEJANDRO");
        lista.insertarNombre("roberto");
        lista.insertarNombre("marta");
        lista.insertarNombre("alvaro morata");
        lista.insertarNombre("elisa");
        lista.insertarNombre("luis suarez gutierrez");
        lista.insertarNombre("alba castillo");
        lista.insertarNombre("jorge");




        System.out.println(lista);
        System.out.println("El nombre más largo es: " + lista.nombreMasLargo());
        System.out.print("Borrar los nombres que comiencen por (" + borrarLetra + "): ");
        lista.borrarLetra(borrarLetra);

        System.out.println(lista);
        System.out.println("Veces que un nombre comienza por (" + strComienzo + "): " + lista.empiezanPor(strComienzo));
        System.out.println("Nombres que comienza por (" + chrComienzo + "): " + Arrays.toString(lista.empiezanPorLetra(chrComienzo)));
    }
}
