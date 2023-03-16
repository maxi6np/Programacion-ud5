package Ejer5x2;

import java.util.Random;

public class HorasTrabajadas {
    public static void main(String[] args) {

        double[][] horasTrabajadas = new double[7][15];
        final String[] NOMBRE_DIAS = {"Lunes", "Martes", "Miércoles", "Jueves", "Viernes", "Sábado", "Domingo"};



        Random random = new Random();
        for (int i = 0; i < horasTrabajadas.length; i++) {
            for (int j = 0; j < horasTrabajadas[i].length; j++) {
                int horas = random.nextInt(12) + 8;
                horasTrabajadas[i][j] = horas;
            }
        }

        double[] horasTotalesPorDia= new double[7];
        for (int i = 0; i < horasTrabajadas.length; i++) {
            for (int j = 0; j < horasTrabajadas[i].length; j++) {
                horasTotalesPorDia[i] += horasTrabajadas[i][j];
            }
        }

        for (int i = 0; i < horasTotalesPorDia.length; i++) {
            System.out.println(NOMBRE_DIAS[i] + ": " + horasTotalesPorDia[i]);
        }
    }
}
