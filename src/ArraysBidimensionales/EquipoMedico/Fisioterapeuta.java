package ArraysBidimensionales.EquipoMedico;

public class Fisioterapeuta extends Empleado{
    public boolean internacional;

    public Fisioterapeuta(String codigo, String nombre, String apellido, int edad,String rol,boolean internacional) {
        super(codigo, nombre, apellido, edad,rol);
        this.internacional = internacional;
    }

    public boolean isInternacional() {
        return internacional;
    }

    public void setInternacional(boolean internacional) {
        this.internacional = internacional;
    }

    @Override
    public String getRol() {
        return "Fisioterapeuta";
    }



    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        sb.append("\tInternacional: ").append(internacional);
        return sb.toString();
    }
}
