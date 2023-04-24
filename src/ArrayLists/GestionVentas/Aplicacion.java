package ArrayLists.GestionVentas;

import javax.print.DocFlavor;
import java.security.UnrecoverableEntryException;
import java.util.*;

public class Aplicacion {
    public HashMap<Producto, Integer> listaProductos;
    public HashMap<Venta, Integer> listaVentas;

    public Aplicacion() {
        listaProductos = new HashMap<>();
        listaVentas = new HashMap<>();
    }

    //Añade un producto al listado en caso de que no exista ya.
    //Devuelve true si se ha podido añadir y false si no
    public boolean anadirProducto(Producto producto) {
        boolean anadido = false;
        int contadorProductos = 0;

        if (!listaProductos.containsKey(producto)) {
            listaProductos.put(producto, contadorProductos + 1);
            anadido = true;
        }
        return anadido;
    }


    //recibe como parámetros el código del producto (sin tener en
    //cuenta mayúsculas y minúsculas) y el valor en que se va a incrementar o decrementar
    //las existencias del producto. El valor de existencias no podrá ser nunca inferior a 0, por
    //lo que si el valor a decrementar es superior al de existencias, se dejarán en 0 las
    //existencias. Devuelve false si no encuentra el producto
    public boolean modificarExistencias(String codigo, int cantidad) {
        boolean encontrado = false;

        for (Producto p : listaProductos.keySet()) {
            if (p.getCodigo().equalsIgnoreCase(codigo)) {
                encontrado = true;
                int existenciasNuevas = p.getExistencias() + cantidad;
                if (existenciasNuevas < 0) {
                    p.setExistencias(0);
                } else {
                    p.setExistencias(existenciasNuevas);
                }
            }
        }
        return encontrado;
    }


    //recibe como parámetro un código de producto (sin tener en cuenta
    //mayúsculas y minúsculas) y si existe y tiene 0 existencias lo borra y devuelve true.
    //Devuelve false en caso contrario
    public boolean borrarProducto(String codigo) {

        for (Producto p : listaProductos.keySet()) {
            if (p.getCodigo().equalsIgnoreCase(codigo) && p.getExistencias() == 0) {
                listaProductos.remove(p);
                return true;
            }
        }
        return false;
    }

    //recibe como parámetro un nombre de categoría y borra
    //los productos pertenecientes a dicha categoría. Devuelve false si no se ha encontrado
    //ningún producto con esa categoría
    public boolean borrarProductosCategoria(String nombreCategoria) {
        Iterator<Map.Entry<Producto, Integer>> iterator = listaProductos.entrySet().iterator();
        boolean encontrado = false;

        while (iterator.hasNext()) {
            Map.Entry<Producto, Integer> entrada = iterator.next();
            if (entrada.getKey().getCategoria().equalsIgnoreCase(nombreCategoria)) {
                iterator.remove();
                encontrado = true;
            }
        }
        return encontrado;
    }

    //devuelve un mapa en el que las claves son los códigos de los
    //productos y los valores el número de unidades restantes
    public HashMap<String, Integer> existenciasProductos() {
        HashMap<String, Integer> existencias = new HashMap<>();

        for (Producto p : listaProductos.keySet()) {
            String categoria = p.getCodigo();
            int restantes = p.getExistencias();

            existencias.put(categoria, restantes);
        }

        return existencias;

    }

    //devuelve un mapa en el que las claves son las categorías y los
    //valores el listado de productos que pertenecen a cada categoría
    public HashMap<String, HashSet<Producto>> productosPorCategoria() {
        HashMap<String, HashSet<Producto>> productosPorCategoria = new HashMap<>();

        for (Producto p : listaProductos.keySet()) {
            String categoria = p.getCategoria();

            if (p.getCategoria().equals(categoria)) {
                if (productosPorCategoria.containsKey(categoria)) {
                    HashSet<Producto> productos = productosPorCategoria.get(categoria);
                    productos.add(p);
                } else {
                    HashSet<Producto> productos = new HashSet<>();
                    productos.add(p);
                    productosPorCategoria.put(categoria, productos);
                }
            }

        }

        return productosPorCategoria;
    }

    //recibe como parámetro un DNI y un mapa en el que las claves son
    //códigos de productos y los valores el número de unidades que se desea comprar.
    //Comprueba que haya suficientes existencias de todos los productos y si las hay, crea
    //un objeto de tipo venta, lo añade al listado de ventas y lo retorna. Si no se ha podido
    //realizar, se devuelve null
    public Venta generarVenta(String DNI, Map<String, Integer> ventas) {
        HashMap<Producto, Integer> productosVendidos = new HashMap<>();
        int contadorVentas = 0;

        for (String codigo : ventas.keySet()) {
            Producto producto = buscarProducto(codigo);
            if (producto == null) {
                System.out.println("El producto con código " + codigo + " no existe");
                return null;
            }
            int udsDeseadas = ventas.get(codigo);
            if (udsDeseadas > producto.getExistencias()) {
                System.out.println("No hay suficientes existencias del producto con código " + codigo);
                return null;
            }
        }

        for (String codigo : ventas.keySet()) {
            Producto producto = buscarProducto(codigo);
            int udsDeseadas = ventas.get(codigo);

            producto.setExistencias(producto.getExistencias() - udsDeseadas);
            productosVendidos.put(producto, udsDeseadas);
        }
        Venta venta = new Venta(DNI, productosVendidos);
        listaVentas.put(venta, contadorVentas + 1);

        return venta;
    }

    private Producto buscarProducto(String codigo) {
        for (Producto producto : listaProductos.keySet()) {
            if (producto.getCodigo().equalsIgnoreCase(codigo)) {
                return producto;
            }
        }
        return null;
    }

    //muestra por pantalla, ordenados por categoría, los productos
    public void mostrarProductos() {

        ArrayList<Producto> productos = new ArrayList<>(listaProductos.keySet());
        productos.sort(new Comparator<Producto>() {
            @Override
            public int compare(Producto o1, Producto o2) {
                if (o1 != null && o2 != null) {
                    return o1.compareTo(o2);
                }

                return 0;
            }
        });


        for (Producto p : productos) {
            System.out.println("------------ Código " + p.getCodigo() + "-------------");
            System.out.println("Nombre: " + p.getNombre());
            System.out.println("Categoría: " + p.getCategoria());
            System.out.println("Unidades: " + p.getExistencias());
            System.out.println("Precio: " + p.getPrecio() + "€");


        }
    }

}
