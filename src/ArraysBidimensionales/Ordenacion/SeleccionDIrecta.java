package Ordenacion;


import java.util.Random;

public class SeleccionDIrecta {
    public static void main(String[] args) {
        int[] numeros = new int[]{24, 12, 36, 5, 7, 15};
        ordenarSeleccionDirecta(numeros);
    }


    //El método consiste en seleccionar en cada paso de ordenación el elemento de menor valor de
    //entre los que quedan por ordenar e intercambiarlo con el primero de la secuencia que se está
    //tratando en ese paso. El proceso se repite desde el primero al penúltimo elemento del array.
    public static void ordenarSeleccionDirecta(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            int posmin = i;
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] < array[posmin]) {
                    posmin = j;
                }
            }
            int aux = array[posmin];
            array[posmin] = array[i];
            array[i] = aux;
        }
    }
}
