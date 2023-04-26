package ArrayLists.Aeropuerto.modelo;

public class Regular extends Vuelo{
    public int plazasLibres;

    public Regular(String destino, String modelo, int plazas, int precio,int plazasLibres) {
        super(destino, modelo, plazas, precio);
        this.plazasLibres = plazasLibres;
    }

    public int getPlazasLibres() {
        return plazasLibres;
    }

    public void setPlazasLibres(int plazasLibres) {
        this.plazasLibres = plazasLibres;
    }

    @Override
    public double precioBillete() {
        return (precio * 1.1) + (5 * getPlazasLibres());
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("Vuelo ").append(this.getClass().getSimpleName()).append("\n");
        sb.append("-------------------------\n");
        sb.append(super.toString());
        sb.append("Precio billete: ").append(precioBillete()).append("€").append("\n");
        sb.append("Plazas libres: ").append(plazasLibres).append("\n");
        sb.append("\n");
        return sb.toString();
    }
}
