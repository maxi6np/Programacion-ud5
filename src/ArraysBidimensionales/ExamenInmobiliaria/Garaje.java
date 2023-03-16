package ArraysBidimensionales.ExamenInmobiliaria;

import java.util.Objects;

public class Garaje extends Inmueble{
    public boolean esIndividual;

    public Garaje(String codigo, double precio, int superficie, Direccion direccion, EstadoInmueble estado,boolean esIndividual) {
        super(codigo, precio, superficie, direccion, estado);
        this.esIndividual = esIndividual;
    }

    public boolean isEsIndividual() {
        return esIndividual;
    }

    public void setEsIndividual(boolean esIndividual) {
        this.esIndividual = esIndividual;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Garaje garaje = (Garaje) o;
        return esIndividual == garaje.esIndividual;
    }


    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Garaje{");
        sb.append(super.toString());
        sb.append("esIndividual=").append(esIndividual);
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
