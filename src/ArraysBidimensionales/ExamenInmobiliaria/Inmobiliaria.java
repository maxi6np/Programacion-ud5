package ArraysBidimensionales.ExamenInmobiliaria;

import javax.print.DocFlavor;
import java.util.*;

public class Inmobiliaria {
    private final static String[] DATOS_EMPLEADOS = {
            "39817263H;Manuel;Gómez García",
            "99625423F;Nuria;Ruiz Pérez",
            "63265932L;Juan Daniel;Sastre Palomo",
            "36259536P;Laura;Vázquez Pardo"};

    private ArrayList<Inmueble> inmuebles;
    private ArrayList<Empleado> empleados;

    public Inmobiliaria() {
        inmuebles = new ArrayList<>();
        empleados = new ArrayList<>();
        registrarEmpleados();
    }

    //Crea los empleados y los añade al listado, a partir de DATOS_EMPLEADOS
    public void registrarEmpleados() {
        for (String empleado : DATOS_EMPLEADOS) {
            String[] datos = empleado.split(";");
            String DNI = datos[0];
            String nombre = datos[1];
            String apellido = datos[2];

            empleados.add(new Empleado(DNI, nombre, apellido));
        }
    }

    //recibe como parametro dos inmuebles y devuelve true si son iguales
    public boolean compararInmuebles(Inmueble i1, Inmueble i2) {
        if (i1 != null && i2 != null) {
            return i1.equals(i2);
        }
        return false;
    }

    //añade el inmueble pasado como parametro al listado de inmuebles,
    //en caso de que no haya un inmueble con el mismo codigo.
    //devuelve true si se ha podido añadir, false en caso contrario
    public boolean anadirInmueble(Inmueble inmueble) {
        if (inmueble != null) {
            for (Inmueble inm : inmuebles) {
                if (inm.getCodigo().equals(inmueble.getCodigo())) {
                    return false;
                }
            }
            inmuebles.add(inmueble);
            return true;

        }
        return false;
    }

    private Inmueble buscarInmueble(String codigo) {
        for (Inmueble i : inmuebles) {
            if (i.getCodigo().equals(codigo)) {
                return i;
            }
        }
        return null;
    }

    private Empleado buscarEmpleado(String dni) {
        for (Empleado e : empleados) {
            if (e.getDNI().equals(dni)) {
                return e;
            }
        }
        return null;
    }

    //devuelve un arraylist de inmuebles que se encuentran en el municipio pasado como parametro
    public ArrayList<Inmueble> inmueblesPorMunicipio(String municipio) {
        ArrayList<Inmueble> inmueblesEnMunicipio = new ArrayList<>();

        for (Inmueble inmueble : inmuebles) {
            if (inmueble.getDireccion().getMunicipio().equalsIgnoreCase(municipio)) {
                inmueblesEnMunicipio.add(inmueble);
            }
        }

        return inmueblesEnMunicipio;
    }

    //recibe el codigo del inmueble y el dni del empleado.
    //solo se podra alquilar si su estado es "SE_ALQUILA".
    //esto se reflejara en la matriz operaciones del empleado y se modificara el estado del inmueble a "ALQUILADO"
    //true si se ha realizado, false si no
    //debe existir tanto el inmueble como el empleado
    public boolean alquilarInmbueble(String codigoInmueble, String DNIEmpleado) {
        Inmueble inm = buscarInmueble(codigoInmueble);
        Empleado emp = buscarEmpleado(DNIEmpleado);

        if (emp != null && inm != null && inm.getEstadoInmueble() == EstadoInmueble.SE_ALQUILA) {
            int tipo = getTipo(inm);
            emp.modificarOperaciones(inm.getPrecio(), 0, tipo);
            inm.setEstado(EstadoInmueble.ALQUILADO);
            return true;
        }
        return false;
    }

    private static int getTipo(Inmueble inm) {
        int tipo;
        if (Vivienda.class.equals(inm.getClass())) {
            tipo = 0;
        } else if (Garaje.class.equals(inm.getClass())) {
            tipo = 1;
        } else {
            tipo = 2;
        }
        return tipo;
    }


    //recibe el codigo del inmueble y el dni del empleado.
    //solo se podra alquilar si su estado es "SE_VENDE".
    //esto se reflejara en la matriz operaciones del empleado y se modificara el estado del inmueble a "VENDIDO"
    //true si se ha realizado, false si no
    //debe existir tanto el inmueble como el empleado
    public boolean venderInmbueble(String codigoInmueble, String DNIEmpleado) {
        Inmueble inm = buscarInmueble(codigoInmueble);
        Empleado emp = buscarEmpleado(DNIEmpleado);

        if (emp != null && inm != null && inm.getEstadoInmueble() == EstadoInmueble.SE_VENDE) {
            int tipo = getTipo(inm);
            emp.modificarOperaciones(inm.getPrecio(), 1, tipo);
            inm.setEstado(EstadoInmueble.VENDIDO);
            return true;
        }
        return false;
    }


    // Este método no se puede modificar.
    //devuelve un listado de inmuebles ordenados alfabeticamente por codigo en un arraylist
    //sin modificar el listado de inmuebles original
    public ArrayList<Inmueble> inmueblesPorCodigo() {
        ArrayList<Inmueble> inmueblesCodigo = new ArrayList<Inmueble>(inmuebles);
        Collections.sort(inmueblesCodigo);
        return inmueblesCodigo;
    }


    //devuelve un listado de inmuebles ordenados alfabeticamente por codigo en un arraylist
    //sin modificar el listado de inmuebles original
    public ArrayList<Inmueble> inmueblesPorPrecio() {
        ArrayList<Inmueble> inmueblesPrecio = new ArrayList<Inmueble>(inmuebles);

        Collections.sort(inmueblesPrecio, new Comparator<Inmueble>() {
            @Override
            public int compare(Inmueble i1, Inmueble i2) {
                if (i1 != null && i2 != null) {
                    if (i1.getPrecio() < i2.getPrecio()) {
                        return 1;
                    } else if (i1.getPrecio() > i2.getPrecio()) {
                        return -1;
                    }
                }
                return 0;
            }
        });
        return inmueblesPrecio;
    }


    //devuelve un listado de todos los inmuebles excepto las fincas
    public ArrayList<Inmueble> inmueblesSinFincas() {
        ArrayList<Inmueble> sinFincas = new ArrayList<>();

        for (Inmueble inmueble : inmuebles) {
            if (!(inmueble instanceof Finca)) {
                sinFincas.add(inmueble);
            }
        }

        return sinFincas;
    }


    //devuelve el precio medio de las viviendas que estan en ventas o se han vendido ya.
    //No se tienen en cuenta fincas ni garajes
    public double precioMedioVentaViviendas() {
        int contador = 0;
        double suma = 0;
        for (Inmueble inm : inmuebles) {
            if (inm.getClass().equals(Vivienda.class) && inm.getEstadoInmueble() == EstadoInmueble.VENDIDO ||
                    inm.getEstadoInmueble() == EstadoInmueble.SE_VENDE) {
                suma += inm.getPrecio();
                contador++;
            }
        }
        return suma / contador;
    }

    public String[] empleadosSegundoApellidoEmpiezaPor(String comienzo) {
        String[] nombres = new String[empleados.size()];
        int contador = 0;
        String comienzoMin = comienzo.toLowerCase();

        for (String empleado : DATOS_EMPLEADOS) {
            String[] datos = empleado.split(";");
            String nombre = datos[1];
            String apellidos = datos[2];

            String[] apellido = apellidos.split(" ");
            String apellido2 = apellido[1];

            if (apellido2.toLowerCase().startsWith(comienzoMin)) {
                nombres[contador] = nombre;
                contador++;
            }


        }
        return nombres;
    }

    //devuelve una matriz de dos dimensiones, que constituye la suma de los importes de todas las ventas y alquileres
    //realizados por todos los empleados
    public double[][] totalOperaciones() {
        double[][] total = new double[2][3];
        for (Empleado e : empleados) {
            for (int i = 0; i < e.getOperaciones().length; i++) {
                for (int j = 0; j < e.getOperaciones()[i].length; j++) {
                    total[i][j] += e.getOperaciones()[i][j];
                }
            }
        }
        return total;
    }


    //recibe como parametro una matriz y la muestra
    public void imprimirMatrizOperaciones(double[][] matriz) {
        char[] inm = new char[]{'V', 'G', 'F'};
        String[] op = new String[]{"Alq.", "Ven."};

        for (char c : inm) {
            System.out.print("\t" + "\t" + c);
        }
        System.out.println();


        for (int i = 0; i < matriz.length; i++) {
            System.out.print(op[i] + "\t");
            for (int j = 0; j < matriz[i].length; j++) {
                System.out.print(matriz[i][j] + "\t");
                // para cuadrar las columnas
                if (matriz[i][j] == 0) {
                    System.out.print("\t");
                }
            }
            System.out.println();
        }
    }

    public ArrayList<Empleado> getEmpleados() {
        return empleados;
    }

    public ArrayList<Inmueble> getInmuebles() {
        return inmuebles;
    }

    //Devuelve un mapa en el que las claves son los municipios en
    //los que hay al menos una vivienda, y los valores Sets con las viviendas que hay en ese
    //municipio
    public Map<String, Set<Vivienda>> viviendasPorMunicipio() {
        HashMap<String,Set<Vivienda>> municipios = new HashMap<>();

        for (Inmueble inm:inmuebles) {
            String municipio = inm.getDireccion().getMunicipio();

            if (!(municipios.containsKey(municipio))){
                municipios.put(municipio, new HashSet<>());
            }

            municipios.get(municipio).add((Vivienda) inm);
        }
        return municipios;

    }

    //Devuelve un mapa en el que las claves son los estados posibles de
    //los inmuebles, y los valores el número de inmuebles que hay en ese estado
    public Map<String, Set<EstadoInmueble>> estadosInmuebles() {
        HashMap<String, Set<EstadoInmueble>> estados = new HashMap<>();



        return estados;
    }

    //Devuelve un mapa en el que las claves son los DNI de los
    //empleados y los valores otro mapa en el que la clave es el nombre de la operación
    //(alquiler o venta) y los valores el número de operaciones de ese tipo realizadas
    public void operacionesPorDNI() {

    }


    //muestra por pantalla el mapa obtenido en el método anterior
    public void imprimirOperacionesPorDNI() {
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("-------------------------------- Inmobiliaria -------------------------------------\n");
        sb.append("EMPLEADOS--------------------------------------------");
        for (int i = 0; i < empleados.size(); i++) {
            sb.append("EMPLEADO NÚMERO ").append(i + 1).append("\n").append(empleados.get(i)).append("\n").append("\n");

        }
        sb.append("INMUEBLES-------------------------------------------");
        for (int i = 0; i < inmuebles.size(); i++) {
            sb.append("INMUEBLE NÚMERO ").append(i + 1).append("\n").append(inmuebles.get(i)).append("\n").append("\n");

        }
        sb.append("----------------------------------------------------");
        return sb.toString();
    }

}
