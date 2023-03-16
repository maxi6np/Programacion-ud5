package Ordenacion;



public class InserccionDirecta {
    public static void main(String[] args) {
        int[] numeros = new int[]{24,12,36,5,7,15};
        ordenarInsercionDirecta(numeros);
    }

    /*
    se toma el 1er elemento de entre los que quedan sin ordenar
    y se inserta en el lugar que le corresponda entre los elementos situados
    a su izquierda (que ya están ordenados)
    desplazandolos componentes superiores al tratado un lugar
    hacia la derecha.
     */
    public static void ordenarInsercionDirecta(int[ ] array) {
        for (int i = 1; i < array.length; i++) {
            /*Desde el segundo elemento hasta el final, guardamos el elementos
            y comprobamos con el anterior*/
            int aux = array[i];
            int j = i - 1;

            /*Mientras queden posiciones y el valor de aux sea menor que los de la izquierda,
            * se desplaza a la derecha*/
            while (j >= 0 && array[j] > aux) {
                array[j + 1] = array[j];
                j--;
            }
            //Colocamos aux en su sitio
            array[j + 1] = aux;
        }
    }

}
