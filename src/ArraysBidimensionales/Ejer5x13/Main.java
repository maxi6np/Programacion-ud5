package ArraysBidimensionales.Ejer5x13;

public class Main {
    public static void main(String[] args) {
        Semaforo sm = new Semaforo();
        sm.cambiarEstado();
        sm.cambiarEstado();
        sm.cambiarEstado();
        System.out.println(sm.getColoresSemaforo());;
        System.out.println(sm);
    }
}
