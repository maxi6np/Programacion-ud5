package ArraysBidimensionales.EquipoMedico;

import java.util.Arrays;

import static ArraysBidimensionales.EquipoMedico.EquipoMedico.imprimirMatriz;

public class Main {
    public static void main(String[] args) {
        EquipoMedico em = new EquipoMedico();
        Empleado n1 = new Medico("mnp","MAXIMO","NOVOA",21,"Médico",10);
        n1.trabajar(DiasSemana.L,Turnos.T);
        imprimirMatriz(n1.getCodigo());

    }
}