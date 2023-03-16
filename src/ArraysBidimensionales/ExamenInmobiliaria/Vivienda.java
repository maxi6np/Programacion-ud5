package ArraysBidimensionales.ExamenInmobiliaria;

import java.util.Objects;

public class Vivienda extends Inmueble {
    public int numHabitaciones;
    public int numAseos;

    public Vivienda(String codigo, double precio, int superficie, Direccion direccion, EstadoInmueble estado, int numHabitaciones, int numAseos) {
        super(codigo, precio, superficie, direccion, estado);
        this.numHabitaciones = numHabitaciones;
        this.numAseos = numAseos;
    }

    public int getNumHabitaciones() {
        return numHabitaciones;
    }

    public void setNumHabitaciones(int numHabitaciones) {
        this.numHabitaciones = numHabitaciones;
    }

    public int getNumAseos() {
        return numAseos;
    }

    public void setNumAseos(int numAseos) {
        this.numAseos = numAseos;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Vivienda vivienda = (Vivienda) o;
        return numHabitaciones == vivienda.numHabitaciones && numAseos == vivienda.numAseos;
    }


    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Vivienda{");
        sb.append(super.toString());
        sb.append("numHabitaciones=").append(numHabitaciones);
        sb.append(", numAseos=").append(numAseos);
        sb.append('}');
        return sb.toString();
    }

    @Override
    public int compareTo(Inmueble o) {
        if (o != null) {
            return this.codigo.compareTo(o.getCodigo());
        }
        return 0;
    }
}
