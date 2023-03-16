package ArraysBidimensionales.EquipoMedico;

import java.util.Arrays;

public abstract class Empleado {
    protected String codigo;
    protected String nombre;
    protected String apellido;
    protected int edad;
    protected String rol;
    protected String[][] horarioLaboral;

    public Empleado(String codigo, String nombre, String apellido, int edad, String rol) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.rol = rol;
        horarioLaboral = new String[3][7];
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public String[][] getHorarioLaboral() {
        return horarioLaboral;
    }

    public void setHorarioLaboral(int x, int y, String horarioLaboral) {
        this.horarioLaboral[x][y] = horarioLaboral;
    }

    public void trabajar(DiasSemana dia, Turnos turno) {
        horarioLaboral[dia.getNumDia()][turno.getIndex()] = "x";
    }

    public int horasSemana() {
        int contador = 0;

        for (int i = 0; i < Turnos.values().length; i++) {
            for (int j = 0; j < DiasSemana.values().length; j++) {
                if (horarioLaboral[i][j].equals("x")) {
                    if (i == 0) {
                        contador += Turnos.M.getHorasTrabajo();
                    } else if (i == 1) {
                        contador += Turnos.T.getHorasTrabajo();
                    } else if (i == 2) {
                        contador += Turnos.N.getHorasTrabajo();
                    }
                }
            }
        }
        return contador;
    }


    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("\n");
        sb.append("\tCódigo: ").append(codigo).append("\n");
        sb.append("\tNombre: ").append(nombre).append("\n");
        sb.append("\tApellido: ").append(apellido).append("\n");
        sb.append("\tEdad: ").append(edad).append("\n");
        sb.append("\tRol: ").append(rol).append("\n");
        return sb.toString();
    }
}
