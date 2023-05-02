package ArrayLists.Aeropuerto.modelo;

import java.util.Comparator;
import java.util.IllegalFormatCodePointException;
import java.util.Objects;

public abstract class Vuelo implements Comparable<Vuelo> {
    protected String destino;
    protected String modelo;
    protected int plazas;
    protected int precio;

    public Vuelo(String destino, String modelo, int plazas, int precio){
        this.destino = destino;
        this.modelo = modelo;
        this.plazas = plazas;
        this.precio = precio;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public int getPlazas() {
        return plazas;
    }

    public void setPlazas(int plazas) {
        this.plazas = plazas;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vuelo vuelo = (Vuelo) o;
        return plazas == vuelo.plazas && Objects.equals(destino, vuelo.destino) && Objects.equals(modelo, vuelo.modelo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(destino, modelo, plazas);
    }

    @Override
    public int compareTo(Vuelo v) {
        int comparar = this.destino.compareTo(v.destino);
        if (comparar != 0){
            return comparar;
        }
        comparar = this.modelo.compareTo(v.modelo);
        if (comparar != 0){
            return comparar;
        }
        return Integer.compare(this.plazas, v.plazas);
    }

    public abstract double precioBillete();

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("Destino: ").append(destino).append('\n');
        sb.append("Modelo: ").append(modelo).append('\n');
        sb.append("Plazas: ").append(plazas).append('\n');
        sb.append("Precio billete: ").append(precioBillete()).append("€").append("\n");
        return sb.toString();
    }
}
