package Busqueda;

public class Binaria {
    public static void main(String[] args) {
        int[] numeros = new int[]{1,2,34,4354,99,3};
        System.out.println(buscarDicotomica(numeros,2));

    }

    public static boolean buscarDicotomica(int[ ] numeros, int valorBuscado)
    {
        boolean encontrado = false;
        int izquierda = 0;
        int derecha = numeros.length - 1;
        int mitad;
        while (izquierda<= derecha && ! encontrado)
        {
            mitad = (izquierda + derecha) / 2;
            if (numeros[mitad] == valorBuscado) {
                encontrado = true;
            }
            else if (numeros[mitad] > valorBuscado) {
                derecha = mitad - 1;
            }
            else {
                izquierda = mitad + 1;
            }
        }
        return encontrado;
    }

}
