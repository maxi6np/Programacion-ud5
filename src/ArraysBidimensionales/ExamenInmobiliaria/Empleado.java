package ArraysBidimensionales.ExamenInmobiliaria;

import java.util.Arrays;

public class Empleado{
    public String DNI;
    public String nombre;
    public String apellidos;
    public double[][] operaciones;
    private final int FILAS = 2;
    private final int COLUMAS = 3;

    public Empleado(String DNI, String nombre, String apellidos) {
        this.DNI = DNI;
        this.nombre = nombre;
        this.apellidos = apellidos;
        operaciones = new double[FILAS][COLUMAS];
    }

    public void modificarOperaciones(double precio, int operacion, int tipo){
        operaciones[operacion][tipo] += precio;
    }



    //Todos los atributos deben tener un get.
    public String getDNI() {
        return DNI;
    }

    public void setDNI(String DNI) {
        this.DNI = DNI;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public double[][] getOperaciones() {
        return operaciones;
    }

    public void setOperaciones(double[][] operaciones) {
        this.operaciones = operaciones;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("DNI= ").append(DNI).append("\n");
        sb.append("Nombre= ").append(nombre).append("\n");
        sb.append("Apellidos= ").append(apellidos).append("\n");
        return sb.toString();
    }
}
