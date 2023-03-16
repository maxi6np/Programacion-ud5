package ArraysBidimensionales.Tarea4;

import java.util.Scanner;
import java.util.StringTokenizer;

public class SbYSt {
    static final String SEPARADOR = ",";

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Introduce una frase: ");
        String frase = sc.nextLine();

        invertirCadena(frase);
        invertirPorPalabras(frase);
        letrasMayusc(frase);
        imparPar(frase);
        imprimirSinComas(frase);
    }


    //Muestra la frase invertida
    public static void invertirCadena(String frase) {
        StringBuilder sb = new StringBuilder(frase);
        System.out.println(sb.reverse());;

    }


    //Muestra la frase invertida a nivel de palabra
    public static void invertirPorPalabras(String frase) {
        StringBuilder sb = new StringBuilder();

        //El patrón "\s+" es una expresión regular que coincide con uno o más espacios en blanco, donde:
        //"\s" significa cualquier carácter de espacio en blanco, incluyendo espacio, tabulación, retorno de carro, nueva línea, etc.
        //"+" significa que la expresión regular debe coincidir con uno o más caracteres consecutivos.
        String[] palabras = frase.split("\\s+");
        for (String palabra:palabras) {
            sb.append(new StringBuilder(palabra).reverse()).append(" ");
        }
        System.out.println(sb);
    }


    //Muestra la frase con todas las letras en mayúsculas
    public static void letrasMayusc(String frase) {
        System.out.println(frase.toUpperCase());
    }

    //Muestrta la última letra de cada palabra con longitud impar,
    //y la primera de las de longitud par
    public static void imparPar(String frase) {
        StringBuilder sb = new StringBuilder();

        String[] palabras = frase.split("\\s+");
        for (String palabra : palabras) {
            int longitud = palabra.length();
            if (longitud % 2 == 0) {
                sb.append(palabra.charAt(0));
            } else {
                sb.append(palabra.charAt(longitud - 1));
            }
        }
        System.out.println(sb);
    }

    //Imprime cada palabra en una línea elminando comas
    public static void imprimirSinComas(String frase) {
        String[] palabras = frase.split("\\s+");

        for (String palabra: palabras) {
            System.out.print(palabra.replace(",",""));
        }
    }

}
