package ArraysBidimensionales.EquipoMedico;

public enum DiasSemana {
    L(0, "Lunes"),
    M(1, "Martes"),
    X(2, "Miércoles"),
    J(3, "Jueves"),
    V(4, "Viernes"),
    S(5, "Sábado"),
    D(6, "Domingo");

    public int numDia;
    public String nombreDia;

    private DiasSemana(int numDia, String nombreDia) {
        this.numDia = numDia;
        this.nombreDia = nombreDia;
    }

    public int getNumDia() {
        return numDia;
    }

    public void setNumDia(int numDia) {
        this.numDia = numDia;
    }

    public String getNombreDia() {
        return nombreDia;
    }

    public void setNombreDia(String nombreDia) {
        this.nombreDia = nombreDia;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append(numDia).append(": ").append(nombreDia);
        return sb.toString();
    }
}
