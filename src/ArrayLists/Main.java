package ArrayLists;

import javax.swing.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        /* Declaramos la varible ya que sino no podemos usarla
         * en el while por el tema de ámbito
         */
        int codigo;
        do {
            String texto = JOptionPane.showInputDialog("Introduce un numero mayor que 0");
            codigo = Integer.parseInt(texto);
        } while (codigo <= 0);

        System.out.println(codigo);
    }
}
