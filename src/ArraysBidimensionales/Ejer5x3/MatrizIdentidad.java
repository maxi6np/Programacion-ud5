package Ejer5x3;


public class MatrizIdentidad {
    public static void main(String[] args) {
        imprimirMatriz(generarMatrizIdentidad(5));

    }
    public static int[][] generarMatrizIdentidad(int n) {
        int[][] matrizIdentidad = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j) {
                    matrizIdentidad[i][j] = 1;
                } else {
                    matrizIdentidad[i][j] = 0;
                }
            }
        }
        return matrizIdentidad;
    }

    public static void imprimirMatriz(int[][] array){
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                System.out.print(array [i][j] + "\t");
            }
            System.out.println("");
        }
    }
}
