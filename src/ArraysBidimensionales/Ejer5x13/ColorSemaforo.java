package ArraysBidimensionales.Ejer5x13;

public enum ColorSemaforo {
    ROJO (90),
    NARANJA (10),
    VERDE (50);
    private int segundos;
    private ColorSemaforo(int segundos){
        this.segundos = segundos;
    }

    public int getSegundos() {
        return segundos;
    }
}
