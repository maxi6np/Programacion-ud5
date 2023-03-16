package ArraysBidimensionales.Ejer5x11;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Objects;

public class ListaNombres {
    private String[] lista;
    //Cantidad total de nombres actuales
    private int pos;
    private final int MAX = 10;

    public ListaNombres() {
        lista = new String[MAX];
        pos = 0;
    }

    public String[] getLista() {
        return lista;
    }

    public void setLista(String[] lista) {
        this.lista = lista;
    }

    public int getPos() {
        return pos;
    }

    public void setPos(int pos) {
        this.pos = pos;
    }

    //Dado un nombre lo inserta en la lista únicamente si no está.
    //Si la lista está llena tampoco se podrá insertar. La inserción se hace de tal manera
    //que el nombre queda colocado en el lugar que le corresponde manteniendo el orden
    //alfabético de la lista (no se utiliza ningún algoritmo de ordenación).
    //Importan mayúsculas y minúsculas.
    //El método devuelve true si se ha podido realizar la inserción y false en otro caso
    public boolean insertarNombre(String nombre) {
        if (estaNombre(nombre)) {
            return false;
        }
        if (nombre != null && !(listaLlena())) {
            lista[pos] = nombre;
            Arrays.sort(lista, new Comparator<>() {
                @Override
                public int compare(String o1, String o2) {
                    if (o1 != null && o2 != null) {
                        return o1.compareTo(o2);
                    }
                    return 0;
                }
            });
            pos++;
            return true;
        }


        return false;
    }

    private boolean estaNombre(String nombre) {
        int inicio = 0;
        int fin = lista.length - 1;

        while (inicio <= fin) {
            int mitad = (inicio + fin) / 2;
            if (lista[mitad] == null) {
                fin = mitad - 1;
            } else if (lista[mitad].equals(nombre)) {
                return true;
            } else if (lista[mitad].compareTo(nombre) > 0) {
                fin = mitad - 1;
            } else {
                inicio = mitad + 1;
            }
        }
        return false;
    }

    public boolean listaVacia() {
        return pos == 0;
    }

    public boolean listaLlena() {
        return pos == MAX;
    }


    public String nombreMasLargo() {
        String maslargo = "";

        if (listaVacia()) {
            return null;
        }

        for (int i = 0; i < pos; i++) {
            if (lista[i].length() > maslargo.length()) {
                maslargo = lista[i];
            }
        }
        return maslargo;
    }

    public void borrarLetra(char letra) {
        for (int i = 0; i < pos; i++) {
            if (lista[i] != null && lista[i].charAt(0) == letra) {
                System.out.println(lista[i] + "\t");
                borrarDePosicion(i);
            }
        }
    }

    private void borrarDePosicion(int posicion) {
        for (int i = posicion; i < pos - 1; i++) {
            lista[i] = lista[i + 1];
        }
        pos--;
        lista[lista.length - 1] = null;
    }

    public int empiezanPor(String inicio) {
        int contador = 0;
        String inicioLowerCase = inicio.toLowerCase();

        for (String elemento : lista) {
            if (elemento != null && elemento.toLowerCase().startsWith(inicioLowerCase)) {
                contador++;
            }
        }
        return contador;
    }

    public String[] empiezanPorLetra(char letra) {
        String[] comienzanPor = new String[pos];
        int contador = 0;

        for (int i = 0; i < lista.length; i++) {
            if (lista[i] != null && lista[i].toLowerCase().charAt(0) == Character.toLowerCase(letra)) {
                comienzanPor[contador] = lista[i];
                contador++;
            }
        }
        return comienzanPor;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("\n---------------- Lista de nombres ----------------------");
        for (int i = 0; i < lista.length; i++) {
            sb.append("\n").append(i + 1).append("- ").append(lista[i]);
        }
        sb.append("\n----------------------------------");
        return sb.toString();
    }
}
