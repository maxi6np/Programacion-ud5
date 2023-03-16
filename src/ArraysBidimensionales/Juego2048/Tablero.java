package ArraysBidimensionales.Juego2048;

import java.util.Random;

public class Tablero {

    public static final int FILA = 4;
    public static final int COLUMNA = 4;
    private final int[][] tablero;

    public Tablero() {
        tablero = new int[FILA][COLUMNA];
        for (int f = 0; f < FILA; f++) {
            for (int c = 0; c < COLUMNA; c++) {
                tablero[f][c] = 0;
            }
        }
        ponerDos();
        ponerDos();
    }

    public void mostrar() {
        for (int f = 0; f < FILA; f++) {
            System.out.print("|");
            for (int c = 0; c < COLUMNA; c++) {
                if (tablero[f][c] == 0) {
                    System.out.print(" " + "|");
                } else {
                    System.out.print(tablero[f][c] + "|");
                }
            }
            System.out.print("\n");
        }
    }

    //Recorre las columnas del tablero contando las celdas vacías en una fila pasada como parámetro
    private int vaciasEnFila(int fila) {
        int vaciasFila = 0;
        for (int col = 0; col < COLUMNA; col++) {
            if (tablero[fila][col] == 0) {
                vaciasFila++;
            }
        }
        return vaciasFila;
    }

    //Recorre las filas del tablero contando las celdas vacías en una columna pasada como parámetro
    private int vaciasEnColumna(int columna) {
        int vaciasCol = 0;
        for (int fila = 0; fila < FILA; fila++) {
            if (tablero[fila][columna] == 0) {
                vaciasCol++;
            }
        }
        return vaciasCol;
    }

    //Cuenta las celdas vacías totales en el tablero
    public int vacias() {
        int cont = 0;
        for (int f = 0; f < FILA; f++) {
            for (int c = 0; c < COLUMNA; c++) {
                if (tablero[f][c] == 0) {
                    cont++;
                }
            }
        }
        return cont;
    }

    //Añade un 2 aleatorio en una casilla vacia (=0) del tablero
    private void ponerDos() {
        int f;
        int c;
        Random random = new Random();

        //Genera una fila aleatoria y la recorre hasta que encuentre una casilla vacia
        do {
            f = random.nextInt(FILA);
        } while (vaciasEnFila(f) == 0);

        //Genera una columna aleatoria y la recorre hasta que encuentre una casilla vacia
        do {
            c = random.nextInt(COLUMNA);
        } while (tablero[f][c] != 0);

        //Añade un "2" en las casilla random que haya salido
        tablero[f][c] = 2;
    }

    //Comprobar si el jugador ha ganado (casilla = 2048)
    public boolean ganador() {
        for (int f = 0; f < FILA; f++) {
            for (int c = 0; c < COLUMNA; c++) {
                if (tablero[f][c] == 2048) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean finPartida() {
        return (ganador() || vacias() == 0);
    }

    //////////////////////////////////////////////////ARRIBA////////////////////////////////////////////////////////////
    //Proceso total de mover arriba los valores de todas las columnas con sus consecuencias y modificaciones
    public void moverArriba() {
        for (int i = 0; i < COLUMNA; i++) {
            moverArribaColumna(i);
        }
        if (!finPartida())
            ponerDos();
    }

    //En este método se refleja las acciones para colocar correctamente los valores de una columna arriba
    //Cada vez que se llame al método "moverArriba" se tienen que ejecutar estos tres métodos.
    //Entonces, los almacenamos en este método y así simplificamos código
    private void moverArribaColumna(int c) {
        colocarArriba(c);
        sumarArriba(c);
        colocarArriba(c);

    }

    //Mover hacia arriba en una columna los valores de ella misma
    private void colocarArriba(int columna) {
        //Mientras que halla alguna casilla de esa columna, se realiza el bucle
        if (vaciasEnColumna(columna) < COLUMNA) {
            //Colocar el valor de la casilla inferior en la superior
            for (int i = 0; i < COLUMNA - 1; i++) {
                for (int j = 0; j < FILA - 1; j++) {
                    if (tablero[j][columna] == 0) {
                        tablero[j][columna] = tablero[j + 1][columna];
                        tablero[j + 1][columna] = 0;
                    }
                }
            }
        }
    }

    //Si en una columna la casilla inferior es igual a la actual, al colocarlas arriba, se suman
    private void sumarArriba(int columna) {
        if (vaciasEnColumna(columna) < FILA - 1) {
            for (int i = 0; i < FILA - 1; i++) {
                if (tablero[i][columna] == tablero[i + 1][columna]) {
                    tablero[i][columna] *= 2;
                    tablero[i + 1][columna] = 0;
                }
            }
        }
    }

    ////////////////////////////////////////////////////ABAJO///////////////////////////////////////////////////////////
    public void moverAbajo() {
        for (int i = 0; i < COLUMNA; i++) {
            moverAbajoColumna(i);
        }
        if (!finPartida())
            ponerDos();
    }

    private void moverAbajoColumna(int c) {
        colocarAbajo(c);
        sumarAbajo(c);
        colocarAbajo(c);

    }

    private void colocarAbajo(int columna) {
        if (vaciasEnColumna(columna) < COLUMNA) {
            for (int i = 0; i < COLUMNA - 1; i++) {
                for (int j = FILA - 1; j > 0; j--) {
                    if (tablero[j][columna] == 0) {
                        tablero[j][columna] = tablero[j - 1][columna];
                        tablero[j - 1][columna] = 0;
                    }
                }
            }
        }
    }

    private void sumarAbajo(int columna) {
        if (vaciasEnColumna(columna) < FILA - 1) {
            for (int i = FILA - 1; i > 0; i--) {
                if (tablero[i][columna] == tablero[i - 1][columna]) {
                    tablero[i][columna] *= 2;
                    tablero[i - 1][columna] = 0;
                }
            }
        }
    }

    /////////////////////////////////////////////////////DERECHA////////////////////////////////////////////////////////
    public void moverDerecha() {
        for (int i = 0; i < FILA; i++) {
            moverDerechaColumna(i);
        }
        if (!finPartida())
            ponerDos();
    }

    private void moverDerechaColumna(int f) {
        colocarDerecha(f);
        sumarDerecha(f);
        colocarDerecha(f);

    }

    private void colocarDerecha(int fila) {
        if (vaciasEnFila(fila) < FILA) {
            for (int i = 0; i < FILA - 1; i++) {
                for (int j = COLUMNA - 1; j > 0; j--) {
                    if (tablero[fila][j] == 0) {
                        tablero[fila][j] = tablero[fila][j - 1];
                        tablero[fila][j - 1] = 0;
                    }
                }
            }
        }
    }

    private void sumarDerecha(int fila) {
        if (vaciasEnFila(fila) < COLUMNA - 1) {
            for (int i = FILA - 1; i > 0; i--) {
                if (tablero[fila][i] == tablero[fila][i - 1]) {
                    tablero[fila][i] *= 2;
                    tablero[fila][i - 1] = 0;
                }
            }
        }
    }

    /////////////////////////////////////////////////////IZQUIERDA//////////////////////////////////////////////////////
    public void moverIzquierda() {
        for (int i = 0; i < FILA; i++) {
            moverIzquierdaColumna(i);
        }
        if (!finPartida())
            ponerDos();
    }

    private void moverIzquierdaColumna(int f) {
        colocarIzquierda(f);
        sumarIzquierda(f);
        colocarIzquierda(f);

    }

    private void colocarIzquierda(int fila) {
        if (vaciasEnFila(fila) < FILA) {
            for (int i = 0; i < FILA - 1; i++) {
                for (int j = 0; j < COLUMNA - 1; j++) {
                    if (tablero[fila][j] == 0) {
                        tablero[fila][j] = tablero[fila][j + 1];
                        tablero[fila][j + 1] = 0;
                    }
                }
            }
        }
    }

    private void sumarIzquierda(int fila) {
        if (vaciasEnFila(fila) < COLUMNA - 1) {
            for (int i = 0; i < COLUMNA - 1; i++) {
                if (tablero[fila][i] == tablero[fila][i + 1]) {
                    tablero[fila][i] *= 2;
                    tablero[fila][i + 1] = 0;
                }
            }
        }
    }
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////


}
