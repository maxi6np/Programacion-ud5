package ArrayLists.Ejer5x30;

import java.util.Stack;

public class DetectarPalindromos {

    public static void main(String[] args) {
        DetectarPalindromos detector = new DetectarPalindromos("seres");
        System.out.println("¿Es palíndromo? " + detector.esPalindromo());
    }
    public String palabra;
    public DetectarPalindromos(String palabra) {
        this.palabra = palabra;
    }

    public boolean esPalindromo() {
        Stack<Character> caracteres = new Stack<>();

        for (int i = 0; i < palabra.length(); i++) {
            caracteres.push(palabra.charAt(i));
        }
        for (int i = 0; i < palabra.length(); i++) {
            char primero = palabra.charAt(i);
            char ultimo = caracteres.pop();

            if (primero != ultimo) {
                return false;
            }
        }
        return true;
    }

}
