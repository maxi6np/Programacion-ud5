package ArrayLists.GestionVentas;

import java.util.Objects;

public class Producto implements Comparable<Producto> {
    public String codigo;
    public String nombre;
    public String categoria;
    public double precio;
    public int existencias;

    public Producto(String codigo, String nombre, String categoria, double precio, int existencias) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.categoria = categoria;
        this.precio = precio;
        this.existencias = existencias;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getExistencias() {
        return existencias;
    }

    public void setExistencias(int existencias) {
        this.existencias = existencias;
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Producto producto = (Producto) o;
        return Objects.equals(codigo, producto.codigo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(codigo);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Producto{");
        sb.append("codigo='").append(codigo).append('\'');
        sb.append(", nombre='").append(nombre).append('\'');
        sb.append(", categoria='").append(categoria).append('\'');
        sb.append(", precio=").append(precio);
        sb.append(", existencias=").append(existencias);
        sb.append('}');
        return sb.toString();
    }


    @Override
    public int compareTo(Producto o) {
        if (o != null){
            return getCategoria().compareTo(o.getCategoria());
        }
        return 0;
    }
}
