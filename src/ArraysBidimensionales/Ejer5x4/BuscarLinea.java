package Ejer5x4;

public class BuscarLinea {
    public static void main(String[] args) {
        System.out.println();
    }

    public int buscarLineal(int[] numeros, int valorBuscado) {
        int i = 0;
        while (i < numeros.length) {
            if (numeros[i] == valorBuscado) {
                return i;
            } else {
                i++;
            }
        }
        return -1;
    }

    public static void prueba(int[] array) {
        int[] nuevo = new int[]{7, 5, 2, 8};
        System.arraycopy(nuevo, 0, array, 0, nuevo.length);
    }
}
