package Curso;

import java.util.Random;

public class Curso {

    private static final int MAX_ESTUDIANTES = 20;
    private static final int MAX_ASIGNATURAS = 6;
    private int[][] notas;

    public Curso() {
        notas = new int[MAX_ESTUDIANTES][MAX_ASIGNATURAS];
        inicializar(notas);
    }

    private void inicializar(int[][] notas) {
        Random random = new Random();

        for (int i = 0; i < notas.length; i++) {
            for (int j = 0; j < notas[i].length; j++) {
                int valores = random.nextInt(10) + 1;
                notas[i][j] = valores;
            }
        }
    }

    public double[] calcularMedia() {
        double[] medias = new double[MAX_ASIGNATURAS];
        for (int i = 0; i < MAX_ASIGNATURAS; i++) {
            double acumulador = 0;
            for (int j = 0; j < MAX_ESTUDIANTES; j++) {
                acumulador += notas[j][i];
            }
            medias[i] = acumulador / MAX_ESTUDIANTES;
        }
        return medias;
    }

    public int[][] getNotas() {
        return notas;
    }


}
