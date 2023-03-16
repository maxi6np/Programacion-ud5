package Busqueda;

public class Lineal {
    public static void main(String[] args) {
        int[] numeros = new int[]{1,2,34,4354,99,3};
        System.out.println(buscarLineal(numeros,99));

    }


    public static boolean buscarLineal(int[] numeros, int valorBuscado) {
        boolean encontrado = false;
        int i = 0;
        while (i < numeros.length && !encontrado) {
            if (numeros[i] == valorBuscado) {
                encontrado = true;
            } else {
                i++;
            }
        }
        return encontrado;
    }

}
