package ArraysBidimensionales.ArraySinRepetidos;

public class ArraySinRepetidos {
    public int[] elementos;
    public int siguiente;
    public final int MAX = 10;

    public ArraySinRepetidos() {
        elementos = new int[MAX];
        siguiente = 0;
    }

    public void insertar(int nuevoElemento) {
        if (!estaElemento(nuevoElemento) && !estaCompleto()) {
            elementos[siguiente] = nuevoElemento;
            siguiente++;
        }

    }

    public boolean estaCompleto() {
        return siguiente == elementos.length;
    }

    private boolean estaElemento(int elemento) {
        for (int elem : elementos) {
            if (elem == elemento) {
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Arrays sin repetidos: ");

        for (int i = 0; i < elementos.length; i++) {
            sb.append(elementos[i]).append("\t");
        }
        return sb.toString();
    }
}
