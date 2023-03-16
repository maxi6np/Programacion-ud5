package ArraysBidimensionales.Tarea3;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Semana.imprimirDias();
        System.out.println(Semana.nombreDiaSemana(5));
        System.out.println(Semana.numeroDiaSemana("Sábado"));
        System.out.println(Arrays.toString(Semana.diasLaborables()));
    }
}
