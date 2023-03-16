package ArraysBidimensionales.EquipoMedico;

public enum Turnos {
    M(0,8, "Mañana"),
    T(1,7, "Tarde"),
    N(2,5, "Noche");

    public int horasTrabajo;
    public String momentoTurno;
    public int index;

    private Turnos(int index,int horasTrabajo, String momentoTurno){
        this.index = index;
        this.horasTrabajo = horasTrabajo;
        this.momentoTurno = momentoTurno;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public int getHorasTrabajo() {
        return horasTrabajo;
    }

    public void setHorasTrabajo(int horasTrabajo) {
        this.horasTrabajo = horasTrabajo;
    }

    public String getMomentoTurno() {
        return momentoTurno;
    }

    public void setMomentoTurno(String momentoTurno) {
        this.momentoTurno = momentoTurno;
    }


    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append(horasTrabajo).append(": ").append(momentoTurno);
        return sb.toString();
    }
}
