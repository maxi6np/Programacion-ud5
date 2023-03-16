package ArraysBidimensionales.Tarea3;

import java.util.Arrays;

public enum Semana {
    L(1, "Lunes"),
    M(2, "Martes"),
    X(3, "Miércoles"),
    J(4, "Jueves"),
    V(5, "Viernes"),
    S(6, "Sábado"),
    D(7, "Domingo");

    private int dia;
    private String nombre;

    private Semana(int dia, String nombre) {
        this.dia = dia;
        this.nombre = nombre;
    }

    public int getDia() {
        return dia;
    }

    public void setDia(int dia) {
        this.dia = dia;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public static void imprimirDias(){
        for (Semana dia: Semana.values()) {
            System.out.println(dia);
        }
    }

    public static String nombreDiaSemana(int d) {
        for (Semana dia : Semana.values()) {
            if (dia.getDia() == d){
                return dia.getNombre();
            }
        }
        return null;
    }

    public static int numeroDiaSemana (String n){
        for (Semana dia : Semana.values()) {
            if (dia.getNombre().equals(n)){
                return dia.getDia();
            }
        }
        return 0;
    }

    public boolean laborable (){
        return (this != S && this != D);
    }

    public static String[] diasLaborables(){
        String[] dias = new String[Semana.values().length];
        int pos = 0;

        for (Semana dia : Semana.values()) {
            if (dia.laborable()){
                dias[pos] = String.valueOf(dia);
                pos++;
            }
        }
        return dias;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append(dia).append(": ").append(nombre);
        return sb.toString();
    }
}
