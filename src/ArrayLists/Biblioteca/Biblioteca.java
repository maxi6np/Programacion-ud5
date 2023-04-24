package ArrayLists.Biblioteca;
/**
 * Modela una biblioteca
 */

import java.util.*;
import java.io.File;
import java.io.IOException;

public class Biblioteca {

    private String nombre;
    private Set<Libro> libros;
    private int pos;
    private int limiteBiblioteca;

    /**
     * Constructor de la clase Biblioteca
     * crea e inicializa adecuadamente los atributos
     */
    public Biblioteca(String nombre, int n) {
        this.nombre = nombre;
        libros = new TreeSet<>();
        pos = 0;
        limiteBiblioteca = n;
    }

    /**
     * Accesor para el nombre de la biblioteca
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * devuelve true si la biblioteca est� llena
     * (ya no se pueden añadir mas titulos distintos)
     */
    public boolean estaLlena() {
        return pos == limiteBiblioteca;
    }

    /**
     * LLega un  libro  a la biblioteca y hay que anadirlo
     * El libro se anade de forma que quede ordenado por título
     * (ojo! no hay que ordenar sino insertar en orden)
     * <p>
     * <p>
     * Si el libro ya esta en la biblioteca
     * significa que llega un nuevo ejemplar de ese titulo
     * por lo tanto se incrementa el n de ejemplares de ese libro
     * <p>
     * Si no esta el titulo se añade como nuevo libro solo si hay sitio
     * <p>
     * Se devuelve true si se ha podido registrar el libro, false en otro caso
     */
    public boolean addLibro(Libro libro) {
        if (libros.contains(libro)) {
            for (Libro l: libros) {
                if (l.equals(libro)){
                    l.incrementar(libro.getEjemplares());
                    return true;
                }
            }
        }
        if (!estaLlena()){
            libros.add(libro);
            pos++;
            return true;
        }
        return false;
    }


    /**
     * Obtener todos los titulos diferentes
     * que contengan en su nombre la cadena str.
     * Es indiferente mayusculas o minusculas
     * Los titulos se devuelven ordenados
     */
    public String[] titulos(String str) {
        List<String> titulos = new ArrayList<>();
        String strMayus = str.toUpperCase();

        for (Libro l : libros) {
            String titulo = l.getTitulo();
            if (titulo.contains(strMayus)) {
                titulos.add(titulo);
            }
        }
        //titulos.sort(String::compareTo);
        return titulos.toArray(new String[0]);
    }

    /**
     * Cantidad de ejemplares de todos los libros
     * del autor indicado
     * Es indiferente mayusculas o minusculas
     */
    public int totalEjemplaresDeAutor(String autor) {
        int ejemplares = 0;
        for (Libro l : libros) {
            if (autor.equalsIgnoreCase(l.getAutor())){
                ejemplares += l.getEjemplares();
            }
        }

        return ejemplares;
    }

    /**
     * borrar los libros del genero indicado
     */
    public void borrarDeGenero(Genero genero) {
        Iterator <Libro> it = libros.iterator();
        while(it.hasNext()){
            Libro siguiente = it.next();
            if (siguiente.getGenero().equals(genero)){
                it.remove();
            }
        }
    }

    /**
     * Representacion textual de la biblioteca
     * Hacerlo de forma eficiente
     */
    public String toString() {
        return libros.toString();
    }

    public void imprimirBiblioteca(){
        for (Libro l: libros) {
            System.out.println(l.toString());
        }
    }


    /**
     * Lee de un fichero de texto los datos de los libros
     * con ayuda de un objeto de la  clase Scanner
     * y los guarda. El metodo devuelve
     * la cantidad de libros que no han podido ser registrados
     */
    public int cargarDeFichero() {
        int noRegistrados = 0;
        try {
            Scanner sc = new Scanner(new File("C:\\Users\\nopem\\OneDrive\\Documentos\\Máximo\\CLASE MAXI\\PROGRAMACION\\TAREAS\\unidad5\\src\\ArrayLists\\Biblioteca\\libros.txt"));
            while (sc.hasNextLine()) {
                Libro libro = new Libro(sc.nextLine());
                boolean exito = addLibro(libro);
                if (!exito) {
                    noRegistrados++;
                }
            }
            sc.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return noRegistrados;
    }

    /**
     * Punto de entrada a la aplicaci�n. Contiene c�digo para probar
     * todos los m�todos de la clase Biblioteca
     */
    public static void main(String[] args) {
        Biblioteca biblioteca = new Biblioteca("Biblioteca del IES Monte Naranco", 10);
        int noRegistrados = biblioteca.cargarDeFichero();
        System.out.println("No se han podido registrar en la biblioteca " +
                noRegistrados + " libros");

        System.out.println("Situación inicial de la biblioteca\n");
        System.out.println(biblioteca.getNombre());
        biblioteca.imprimirBiblioteca();

        /* ---------------------------*/
        String str = "poTTer";
        String[] titulos = biblioteca.titulos(str);
        System.out.println("Títulos ordenados que contienen la cadena \"" + str +
                "\"\n" + Arrays.toString(titulos));

        /* ---------------------------*/
        String autor = "Vargas Llosa, Mario";
        int total = biblioteca.totalEjemplaresDeAutor(autor);
        System.out.println("\nEjemplares en la biblioteca del autor \"" +
                autor + "\": " + total + "\n");

        /* ---------------------------*/
        Genero genero = Genero.BIOGRAFIA;
        biblioteca.borrarDeGenero(genero);
        System.out.println("\nDespués de borrar los títulos del género " + genero.toString());
        biblioteca.imprimirBiblioteca();

    }
}
