package ArraysBidimensionales.EquipoMedico;

public class Medico extends Empleado{
    public int aniosExperiencia;

    public Medico(String codigo, String nombre, String apellido, int edad,String rol, int aniosExperiencia) {
        super(codigo, nombre, apellido, edad,rol);
        this.aniosExperiencia = aniosExperiencia;
    }

    public int getAniosExperiencia() {
        return aniosExperiencia;
    }

    public void setAniosExperiencia(int aniosExperiencia) {
        this.aniosExperiencia = aniosExperiencia;
    }

    @Override
    public String getRol() {
        return "Médico";
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        sb.append("\tAños de experiencia: ").append(aniosExperiencia);
        return sb.toString();
    }
}
