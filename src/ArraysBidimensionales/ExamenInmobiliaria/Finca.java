package ArraysBidimensionales.ExamenInmobiliaria;

import java.util.Objects;

public class Finca extends Inmueble{
    public boolean esEdificable;

    public Finca(String codigo, double precio, int superficie, Direccion direccion, EstadoInmueble estado,
                 boolean esEdificable) {
        super(codigo, precio, superficie, direccion, estado);
        this.esEdificable = esEdificable;
    }

    public boolean isEsEdificable() {
        return esEdificable;
    }

    public void setEsEdificable(boolean esEdificable) {
        this.esEdificable = esEdificable;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Finca finca = (Finca) o;
        return esEdificable == finca.esEdificable;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Finca{");
        sb.append(super.toString());
        sb.append("esEdificable=").append(esEdificable);
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
