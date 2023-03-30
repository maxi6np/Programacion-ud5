package ArrayLists.GestionVentas;

import java.util.HashMap;
import java.util.Map;

public class Venta {
    public String dni;
    public HashMap<Producto,Integer> productoHashMap;

    public Venta(String dni, HashMap<Producto,Integer> productoHashMap) {
        this.dni = dni;
        this.productoHashMap = productoHashMap;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public HashMap<Producto, Integer> getProductoHashMap() {
        return productoHashMap;
    }

    public void setProductoHashMap(HashMap<Producto, Integer> productoHashMap) {
        this.productoHashMap = productoHashMap;
    }

    public double getImporteTotal(){
        double precio = 0;
        int unidadesVendidas = 0;

        for (Producto producto: productoHashMap.keySet()) {
            precio = producto.getPrecio();
            unidadesVendidas = productoHashMap.get(producto);
        }
        return precio * unidadesVendidas;

    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Venta{");
        sb.append("dni='").append(dni).append('\'');
        sb.append(", productoHashMap=").append(productoHashMap);
        sb.append('}');
        return sb.toString();
    }
}
