package ArrayLists.Producto;

import ArraysBidimensionales.ExamenInmobiliaria.Inmueble;

import java.util.ArrayList;
import java.util.Iterator;

public class GestorStock {
    ArrayList<Producto> productos;

    public GestorStock() {
        productos = new ArrayList<>();
    }

    public void anadirProducto(Producto producto) {
        for (Producto p : productos) {
            if (p.getId() == producto.getId()) {
                System.out.println("Producto ya añadido");
            }
        }
        productos.add(producto);

    }


    public void escribirDetallesProductos() {
        //Con for each
//        for (Producto producto : productos) {
//            System.out.println(producto.toString());
//        }

        //Con iterator
        Iterator<Producto> it = productos.iterator();

        while (it.hasNext()) {
            System.out.println(it.next().toString());
        }

        //Con for normal
//        for (int i = 0; i < productos.size(); i++) {
//            System.out.println(productos.get(i).toString());
//        }
    }

    public Producto localizarProducto(int id) {
        for (Producto p : productos) {
            if (p.getId() == id) {
                return p;
            }
        }
        return null;
    }

    public int cantidadEnStock(int id) {
        Producto p = localizarProducto(id);
        if (p != null) {
            return p.getStock();
        } else {
            return -1;
        }
    }

    public Producto localizarProducto(String nombre) {
        for (Producto p : productos) {
            if (p.getNombre().equals(nombre)) {
                return p;
            }
        }
        return null;
    }

    public void recibirProducto(int id, int cantidad) {
        Producto p = localizarProducto(id);
        if (p != null) {
            p.incrementarCantidad(cantidad);
        } else {
            System.out.println("El producto con identificador " + id + " no existe.");
        }
    }

    public ArrayList escribirMenorQue(int cantidad) {
        ArrayList<Producto> menoresQue = new ArrayList<>();

        for (Producto p : productos) {
            if (p.getStock() < cantidad) {
                menoresQue.add(p);
            }
        }
        return menoresQue;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("GestorStock");

        for (Producto producto : productos) {
            sb.append(producto.toString());
        }

        return sb.toString();
    }
}
