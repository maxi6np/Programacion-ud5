package ArrayLists.Biblioteca;

import java.util.Objects;
import java.util.StringTokenizer;

/**
 * Describe un libro de la biblioteca
 */

public class Libro implements Comparable<Libro>{
    private String titulo;
    private String autor;
    private Genero genero;
    private int ejemplares;


    /**
     * Constructor de la clase Libro
     * Recibe todos los datos de un libro en una
     * cadena de caracteres de la forma
     * "titulo:autor:genero:ejemplares"
     * Ej. "Harry potter y el legado maldito:J. K.- Rowling:juvenil:6"
     * la Ciudad y los perros:mario- vargas llosa:novela:3
     * <p>
     * A partir de este valor hay que parsear la cadena para extraer
     * los valores que se asignar�n a los atributos. Todos los atributos
     * se guardan en may�sculas y sin espacios a izquiera y derecha
     * <p>
     * autor contiene el nombre y apellidos del autor separados por un gui�n
     * Esto permitir� nombres  compuestos y varios apellidos
     * "nombre - apellidos"
     * <p>
     * Ej.   mario- vargas llosa
     * J. K.- Rowling
     * <p>
     * Hay que usar el metodo privado obtenerAutor()
     * (ver el contenido del fichero libros.txt)
     */
    public Libro(String datosLibro) {
        String[] datos = datosLibro.split(":");
        titulo = datos[0].toUpperCase();
        autor = obtenerAutor(datos[1].toUpperCase());
        genero = tipoGenero(datos[2]);
        ejemplares = Integer.parseInt(datos[3].toUpperCase());

    }

    public Genero tipoGenero (String sexo){
        switch (sexo.strip()){
            case "juvenil" -> genero = Genero.JUVENIL;
            case "novela" -> genero = Genero.NOVELA;
            case "biografia" -> genero = Genero.BIOGRAFIA;
            default -> genero = null;
        }
        return genero;
    }

    /**
     * Recibe el nombre de un autor de la forma "nombre - apellidos" y
     * lo devuelve como la cadena "APELLIDOS, NOMBRE"
     * <p>
     * No se puede utilizar split() ni charAt()
     */
    public String obtenerAutor(String autor) {
        StringTokenizer st = new StringTokenizer(autor.strip(),"-");
        String nombre = st.nextToken().strip();
        String apellidos = st.nextToken().strip();

        return apellidos + ", " + nombre;
    }

    /**
     * @return accesor para el titulo
     */
    public String getTitulo() {
        return titulo;
    }

    /**
     * @return devuelve el autor
     */
    public String getAutor() {
        return autor;
    }

    /**
     * @return devuelve el g�nero
     */
    public Genero getGenero() {
        return genero;
    }

    /**
     * @return devuelve el n� de ejemplares
     */
    public int getEjemplares() {
        return ejemplares;
    }

    /**
     * mutador para el n� de ejemplares
     */
    public void incrementar(int ejemplares) {
        this.ejemplares += ejemplares;
    }


    /**
     * @return representaci�n textual del libro
     */
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Título: ").append(titulo).append("\n");
        sb.append("Autor: ").append(autor).append("\n");
        sb.append("Género: ").append(genero).append("\n");
        sb.append("Número de ejemplares: ").append(ejemplares).append("\n");
        return sb.toString();
    }

    /**
     *
     */
    public void printLibro() {
        System.out.println(this.toString());
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Libro libro = (Libro) o;
        return Objects.equals(titulo, libro.titulo) &&
                Objects.equals(autor, libro.autor) &&
                genero == libro.genero;
    }

    @Override
    public int hashCode() {
        return Objects.hash(titulo, autor, genero, ejemplares);
    }

    @Override
    public int compareTo(Libro o) {
        if (o != null){
            return this.getTitulo().compareToIgnoreCase(o.getTitulo());
        }
        return 0;
    }
}
