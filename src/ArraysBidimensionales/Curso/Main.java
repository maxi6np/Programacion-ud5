package Curso;

public class Main {
    public static void main(String[] args) {
        Curso curso = new Curso();
        imprimeMatriz(curso.getNotas());
        System.out.println("Medias: ");
        imprimeArray(curso.calcularMedia());

    }

    public static void imprimeMatriz(int[][] matriz){
        for (int i = 0; i < matriz[0].length; i++) {
            for (int j = 0; j < matriz.length; j++) {
                System.out.print(matriz[j][i] + "\t");
            }
            System.out.println();
        }
    }
    public static void imprimeArray(double[] array){
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + "\t");
        }
    }
}
