package ArraysBidimensionales.ExamenInmobiliaria;

import java.util.Comparator;
import java.util.Objects;

//Clase abstracta ya que de aquí van a heredar los distintos tipos de inmuebles
public abstract class Inmueble implements Comparable<Inmueble>{
    protected String codigo;
    protected double precio;
    protected int superficie;
    protected Direccion direccion;
    protected EstadoInmueble estado;

    public Inmueble(String codigo, double precio, int superficie, Direccion direccion, EstadoInmueble estado) {
        this.codigo = codigo;
        this.precio = precio;
        this.superficie = superficie;
        this.direccion = direccion;
        this.estado = estado;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getSuperficie() {
        return superficie;
    }

    public void setSuperficie(int superficie) {
        this.superficie = superficie;
    }

    public Direccion getDireccion() {
        return direccion;
    }

    public void setDireccion(Direccion direccion) {
        this.direccion = direccion;
    }

    public EstadoInmueble getEstadoInmueble() {
        return estado;
    }

    public void setEstado(EstadoInmueble estado) {
        this.estado = estado;
    }

    //Se consideraran dos inmuebles iguales si tienen misma superficie,
    //mismos atributos propios y están en el mismo municipio
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Inmueble inmueble = (Inmueble) o;
        return superficie == inmueble.superficie &&
                this.equals(inmueble);
    }



    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Inmueble{");
        sb.append("codigo='").append(codigo).append('\'');
        sb.append(", precio=").append(precio);
        sb.append(", superficie=").append(superficie);
        sb.append(", direccion=").append(direccion);
        sb.append(", estado=").append(estado);
        sb.append('}');
        return sb.toString();
    }
}
