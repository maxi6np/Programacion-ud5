package ArraysBidimensionales.EquipoMedico;

public class Nutricionista extends Empleado{
    public char categoria;

    public Nutricionista(String codigo, String nombre, String apellido, int edad,String rol,char categoria) {
        super(codigo, nombre, apellido, edad,rol);
        this.categoria = categoria;
    }

    public char getCategoria() {
        return categoria;
    }

    public void setCategoria(char categoria) {
        this.categoria = categoria;
    }

    @Override
    public String getRol() {
        return "Nutricionista";
    }


    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        sb.append("\tCategoria: ").append(categoria);
        return sb.toString();
    }
}
