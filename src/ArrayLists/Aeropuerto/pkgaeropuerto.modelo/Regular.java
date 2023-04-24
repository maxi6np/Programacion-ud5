package ArrayLists.Aeropuerto.pkgaeropuerto.modelo;

public class Regular extends Vuelo{
    public int plazasLibres;

    public Regular(String destino, String modelo, int plazas,int plazasLibres) {
        super(destino, modelo, plazas);
        this.plazasLibres = plazasLibres;
    }

    public int getPlazasLibres() {
        return plazasLibres;
    }

    public void setPlazasLibres(int plazasLibres) {
        this.plazasLibres = plazasLibres;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("Vuelo ").append(this.getClass().getSimpleName()).append("\n");
        sb.append("-------------------------\n");
        sb.append(super.toString());
        sb.append("Plazas libres:").append(plazasLibres).append("\n");
        sb.append("\n");
        return sb.toString();
    }
}
