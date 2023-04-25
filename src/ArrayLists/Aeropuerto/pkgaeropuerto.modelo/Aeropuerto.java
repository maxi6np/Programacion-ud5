package ArrayLists.Aeropuerto.pkgaeropuerto.modelo;

import java.util.*;

public class Aeropuerto {

    private Map<String, Set<Vuelo>> vuelos;

    public Aeropuerto() {
        vuelos = new TreeMap<>();
    }

    /**
     * A�ade un vuelo a la aerolinea correspondiente solo en el caso de que el vuelo
     * no estuviese ya introducido, si la aerolinea no existiese se a�ade tanto la
     * aerolinea como el vuelo.
     */
    public void addVuelo(String aerolinea, Vuelo vuelo) {
        if (!vuelos.containsKey(aerolinea)) {
            vuelos.put(aerolinea, new TreeSet<>());
        }
        Set<Vuelo> vueloAerolinea = vuelos.get(aerolinea);
        vueloAerolinea.add(vuelo);

        /*if (vuelos.containsKey(aerolinea)){
            vuelos.get(aerolinea).add(vuelo);
        } else{
            Set vueloAerlinea = new TreeSet();
            vueloAerlinea.add(vuelo);
            vuelos.put(aerolinea,vueloAerlinea);
        }*/
    }

    /**
     * Imprime los vuelos por cada aerolinea ordenados por destino, tanto aerolineas
     * como vuelos estaran ordenados alfabeticamente (Ver resultados de ejecucion)
     */
    public void ordenAerolineasAlfabetico() {
        System.out.println(this);
    }

    /**
     * Muestra los vuelos regulares de la aerolinea pasada por parametro, se
     * visualizaran de mayor a menor segun el numero de plazas
     *
     * @param aerolinea Aerolinea de la que se imprimiran los vuelos regulares
     */
    public void regularPorPlazas(String aerolinea) {
        Set<Regular> ordenadosPorPlazas = new TreeSet<>(new ComparatorPlazas());
        for (Vuelo vuelo : vuelos.get(aerolinea)) {
            if (vuelo instanceof Regular) {
                Regular regular = (Regular) vuelo;
                ordenadosPorPlazas.add(regular);
            }
        }
        for (Regular regular : ordenadosPorPlazas) {
            System.out.println(regular);
        }
    }

    /**
     * Devuelve una lista con vuelos regulares con plazas libres
     *
     * @return aerolina Aerolina del avion charter con mas capacidad
     */
    public List<Vuelo> plazasLibres() {
        List<Vuelo> plazasLibres = new ArrayList<>();

        for (Set<Vuelo> vuelos : vuelos.values()) {
            for (Vuelo vuelo : vuelos) {
                if (vuelo instanceof Regular && ((Regular) vuelo).getPlazasLibres() > 0){
                    plazasLibres.add(vuelo);
                }
            }

        }
        return plazasLibres;
    }

    /**
     * Muestra el numero de vuelos de cada aerolinea que llegan al destino pasado
     * por parametro, ver resultados de ejecucion
     *
     * @param destino Destino del que se debe sacar la estadistica
     */
    public void estadisticaDestino(String destino) {
        for (String aerolinea : vuelos.keySet()){
            int contador = 0;
            int totalViajes = 0;
            for (Vuelo vuelo : vuelos.get(aerolinea)) {
                if (vuelo.getDestino().equals(destino)){
                    contador++;
                }
                totalViajes++;

            }
            System.out.println(contador + " de cada " + totalViajes + " de la aerolinea "
                    + aerolinea + " vuelan a " + destino);
        }
    }

    /**
     * Borra los vuelos reservados por una empresa y devuelve el numero de vuelos
     * borrados, utiliza un conjunto de entradas
     *
     * @param nifEmpresa
     * @return numero de vuelos borrados
     */
    public int borrarVuelosEmpresa(String nifEmpresa) {
        List<Charter> borrados = new ArrayList<>();
        for (String aerolinea : vuelos.keySet()) {
            for (Vuelo vuelo:vuelos.get(aerolinea)) {
                if (vuelo instanceof Charter && ((Charter) vuelo).getNif().equals(nifEmpresa)){
                    borrados.add((Charter) vuelo);
                }
            }
        }
        return borrados.size();
    }

    /**
     * Imprime la lista de vuelos pasada por parametro
     *
     * @param listaVuelos
     */
    public void imprimirListaVuelos(List<Vuelo> listaVuelos) {
        for (Vuelo vuelo:listaVuelos) {
            System.out.println(vuelo);
        }
    }

    /**
     * Represetaci�n textual del mapa tal y como se muestra en el enunciado
     */
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (String aerolinea : vuelos.keySet()) {
            sb.append(aerolinea).append("\n");
            sb.append("============").append("\n");
            for (Vuelo vuelo : vuelos.get(aerolinea)) {
                sb.append(vuelo.toString());
            }
        }
        return sb.toString();
    }

    /**
     * Rellena el mapa haciendo uso de un fichero de texto
     */
    public void leerFicheroCursos() {
        Scanner entrada = null;
        try {
            entrada = new Scanner(this.getClass().getResourceAsStream("..\\..\\aviones.txt"));
            while (entrada.hasNextLine()) {
                String linea = entrada.nextLine();
                int pos = linea.indexOf(":");
                String aerolinea = linea.substring(0, pos);
                String[] vuelo = linea.substring(pos + 1).split(":");
                String destino = vuelo[1];
                String avion = vuelo[2];
                int plazas = Integer.parseInt(vuelo[3].trim());
                if (vuelo[0].equals("R")) {
                    int plazasLibres = Integer.parseInt(vuelo[4].trim());
                    this.addVuelo(aerolinea, new Regular(destino, avion, plazas, plazasLibres));
                } else {
                    String nifEmpresa = vuelo[4];
                    this.addVuelo(aerolinea, new Charter(destino, avion, plazas, nifEmpresa));
                }
            }

        } finally {
            try {
                entrada.close();
            } catch (NullPointerException e) {
                System.out.println("Error en IO , no se ha creado el fichero");
            }
        }
    }
}
