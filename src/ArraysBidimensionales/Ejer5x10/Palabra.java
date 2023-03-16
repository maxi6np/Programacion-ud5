package Ejer5x10;

public class Palabra {
    private String palabra;

    public Palabra(String palabra) {
        this.palabra = palabra;
    }

    //obtiene la palabra con guiones insertados entre sus caracteres.
    //Si palabra = “prueba” devuelve “p-r-u-e-b-a”
    public String guionizar() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < palabra.length(); i++) {
            sb.append(palabra.charAt(i));
            if (i < palabra.length() - 1) {
                sb.append("-");
            }
        }
        return sb.toString();
    }

    //devuelve el nº de vocales de la palabra. Usa el método privado
    //private boolean esVocal(char car)
    public int contarVocables() {
        int numVocales = 0;
        for (int i = 0; i < palabra.length(); i++) {
            if (esVocal(palabra.charAt(i))) {
                numVocales++;
            }
        }
        return numVocales;
    }

    private boolean esVocal(char car) {
        return switch (Character.toLowerCase(car)) {
            case 'a', 'e', 'i', 'o', 'u' -> true;
            default -> false;
        };
    }

    //devuelve true si la palabra es mayor que la
    //recibida como parámetro, false en otro caso
    public boolean mayorQue(String otraPalabra) {
        return palabra.length() > otraPalabra.length();
    }

    // borra de palabra todas las apariciones de str.
    //Si palabra = “dependiente”, borrarAparicionesDe(“en”) devuelve “depdite”. Usar
    //exclusivamente indexOf() y substring()
    public String borrarApariciones(String str) {
        /*int pos = palabra.indexOf(str);
        while (pos != -1) {
            palabra = palabra.substring(0, pos) + palabra.substring(pos + str.length());
            pos = palabra.indexOf(str);
        }
        return palabra;*/

        StringBuilder sb = new StringBuilder();
        int pos = palabra.indexOf(str);

        String parteInicial = palabra.substring(0,pos);
        String parteFinal = palabra.substring(pos + str.length());

        sb.append(parteInicial).append(parteFinal);
        return sb.toString();
    }


    //devuelve un array bidimensional de caracteres de la forma
    //indicada: si palabra = “patito” el array devuelto es:
    //p a t i t o
    //* a t i t o
    //* * t i t o
    //* * * i t o
    //* * * * t o
    //* * * * * o
    public char[][] toArray2D() {
        int longitud = palabra.length();
        char[][] array = new char[longitud][longitud];

        for (int i = 0; i < longitud; i++) {
            for (int j = 0; j < longitud; j++) {
                if (i <= j) {
                    array[i][j] = palabra.charAt(j);
                } else{
                    array[i][j] = '*';
                }
            }
        }
        return array;
    }


    //devuelve la cadena como un array de caracteres (sin utilizar toCharArray() de String)
    public char[] toArray() {
        int longitud = palabra.length();
        char[] letras = new char[longitud];

        for (int i = 0; i < longitud; i++) {
            letras[i] = palabra.charAt(i);
        }

        return letras;
    }

}
