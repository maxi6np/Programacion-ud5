package ArrayLists.Aeropuerto.modelo;

public class Charter extends Vuelo{
    public String nif;

    public Charter(String destino, String modelo, int plazas, String nif) {
        super(destino, modelo, plazas);
        this.nif = nif;
    }

    public String getNif() {
        return nif;
    }

    public void setNif(String nif) {
        this.nif = nif;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("Vuelo ").append(this.getClass().getSimpleName()).append("\n");
        sb.append("-------------------------\n");
        sb.append(super.toString());
        sb.append("NIF: ").append(nif).append('\n');
        sb.append("\n");
        return sb.toString();
    }
}