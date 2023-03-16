package Ejer5x9;

public class Ejer5x9 {
    public static void main(String[] args) {
        String str = "Aprendiendo cadenas en Java";
        String resul, otra = "cadena de ejemPLO";
        char caracter;
        int pos;


        //1- la cadena str convertida a mayúscula
        resul = str.toUpperCase();
        System.out.println(resul);

        //2- el carácter de la posición 6 de str
        caracter = str.charAt(6);
        System.out.println(caracter);

        //3- el último carácter de la cadena str
        caracter = str.charAt(str.length() - 1);
        System.out.println(caracter);

        //4- compara str con la cadena otra sin tener en cuenta mayúsculas ni minúsculas
        System.out.println(str.equalsIgnoreCase(otra));

        //5- pregunta si str empieza por “Ba”
        System.out.println(str.startsWith("Ba"));

        //6- Sustituye en str todas las 'e' por '*'
        System.out.println(str.replace('e','*'));

        //7- devuelve la primera aparición de la 'd' en str
        System.out.println(str.indexOf('d'));

        //8- localiza la última aparición de la 'c' en str. Extrae , a partir de ahí, la subcadena
        //existente hasta el final.
        int ultimaC = str.lastIndexOf('c');
        System.out.println(str.substring(ultimaC));;

        //9- convierte a String el valor 66
        int x = 66;
        String stringX = String.valueOf(x);
        System.out.println(stringX);

        //10- pregunta si la cadena str es vacía (Hazlo de varias formas)
        str.isEmpty();
        str.isBlank();
        boolean str1 = str.length() == 0;
        boolean str2 = str.equals(" ");
    }
}
