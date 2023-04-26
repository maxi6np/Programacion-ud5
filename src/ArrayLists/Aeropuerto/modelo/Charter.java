package ArrayLists.Aeropuerto.modelo;

public class Charter extends Vuelo{
    public String nif;

    public Charter(String destino, String modelo, int plazas, int precio, String nif) {
        super(destino, modelo, plazas, precio);
        this.nif = nif;
    }

    public String getNif() {
        return nif;
    }

    public void setNif(String nif) {
        this.nif = nif;
    }

    @Override
    public double precioBillete() {
        double precio2 = precio * 1.25;
        if (plazas < 200){
            precio2 += 50;
        }
        return precio2;

    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("Vuelo ").append(this.getClass().getSimpleName()).append("\n");
        sb.append("-------------------------\n");
        sb.append(super.toString());
        sb.append("Precio billete: ").append(precioBillete()).append("€").append("\n");
        sb.append("NIF: ").append(nif).append('\n');
        sb.append("\n");
        return sb.toString();
    }
}
