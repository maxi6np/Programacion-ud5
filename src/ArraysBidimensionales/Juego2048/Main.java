package ArraysBidimensionales.Juego2048;

import java.sql.SQLOutput;
import java.util.Scanner;

public class Main {
    private static Tablero tablero;
    public static int opcion;
    public static Scanner sc;
    public static boolean partidaEnJuego;

    public static void main(String[] args) {
        sc = new Scanner(System.in);
        do {
            menu();
        } while (opcion != 3);

    }

    public static void menu() {
        System.out.println("""
                1)Iniciar partida
                2)Continuar partida
                3)Salir del juego
                -->
                """);

        try {
            opcion = Integer.parseInt(sc.nextLine());
        } catch (Exception e) {
            opcion = 0;
        }

        switch (opcion) {
            case 1 -> iniciarPartida();
            case 2 -> {
                if (partidaEnJuego) {
                    continuarPartida();
                } else {
                    System.out.println("No hay partida en juego");
                }
            }
            case 3 -> System.out.println("Fin de la partida \n");
            default -> System.out.println("ERROR! Introduzca una opción válida");
        }
    }

    private static void continuarPartida() {
        juego();
    }

    private static void iniciarPartida() {
        tablero = new Tablero();
        partidaEnJuego = true;
        juego();
    }

    private static void juego() {
        String direccion;
        do {
            tablero.mostrar();
            System.out.println("izquierda(a) / derercha(d) / arriba(w) / abajo(s) / menú(m): ");
            direccion = sc.nextLine();

            switch (direccion) {
                case "w" -> tablero.moverArriba();
                case "a" -> tablero.moverIzquierda();
                case "s" -> tablero.moverAbajo();
                case "d" -> tablero.moverDerecha();
                case "m" -> System.out.println("Volviendo al menú...");
                default -> System.out.println("Opción desconocida");
            }
        } while (!direccion.equals("m") && !tablero.finPartida());

        if (tablero.finPartida()) {
            tablero.mostrar();
            String mensaje = "";

            if (tablero.ganador()) {
                mensaje += "Has ganado";
            } else {
                mensaje += "Has perdido";
            }
            System.out.println(mensaje);
            partidaEnJuego = false;
        }
    }


}
