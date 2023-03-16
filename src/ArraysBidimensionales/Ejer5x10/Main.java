package Ejer5x10;


public class Main {
    public static void main(String[] args) {
        Palabra palabra = new Palabra("prueba");

        System.out.println(palabra.guionizar());
        System.out.println(palabra.contarVocables());
        System.out.println(palabra.mayorQue("manzana"));
        System.out.println(palabra.borrarApariciones("ru"));

        Palabra palabra2 = new Palabra("peine");
        imprimirArray2D(palabra2.toArray2D());
        System.out.println(palabra2.toArray());
    }

    private static void imprimirArray2D(char[][] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length; j++) {
                System.out.print(array[i][j] + "\t");
            }
            System.out.println();
        }
    }
}
