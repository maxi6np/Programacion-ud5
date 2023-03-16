package ArraySinRepetidos;

import java.util.Scanner;

public class InterfazUsuario{
    public ArraySinRepetidos unArray;
    public Scanner teclado;

    public InterfazUsuario() {
        teclado = new Scanner(System.in);
        unArray = new ArraySinRepetidos();
    }

    public void ejecutar() {
        int valor;
        boolean arrayCompleto = false;

        while (!arrayCompleto) {
            System.out.print("Introduzca un valor (0 para salir): ");
            valor = teclado.nextInt();

            if (unArray.estaCompleto()) {
                System.out.println("El array está completo");
                arrayCompleto = true;
            } else if (valor == 0) {
                System.out.println("Has seleccionado 0. Fin del programa");
                arrayCompleto = true;
            } else {
                unArray.insertar(valor);
            }
        }
        System.out.println(unArray);
    }
}
