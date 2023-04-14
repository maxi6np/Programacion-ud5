package ArrayLists;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[][] matriz = new int[4][];

        for (int i = 0; i < matriz.length; i++) {
            System.out.println("Índices que va a tener la fila " + (i + 1));
            int nColumnas = sc.nextInt();
            matriz[i] = new int[nColumnas];
        }

        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                matriz[i][j] = 1;
                System.out.print(matriz[i][j] + " ");
            }
            System.out.println();
        }

    }
}
