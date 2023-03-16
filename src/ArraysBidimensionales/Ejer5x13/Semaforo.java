package ArraysBidimensionales.Ejer5x13;

public class Semaforo {
    public ColorSemaforo estado;

    public Semaforo(){
        this.estado = ColorSemaforo.VERDE;
    }

    public ColorSemaforo getEstado() {
        return estado;
    }

    public void cambiarEstado() {
        switch (estado){
            case VERDE -> estado = ColorSemaforo.NARANJA;
            case NARANJA -> estado = ColorSemaforo.ROJO;
            case ROJO -> estado = ColorSemaforo.VERDE;
        }
    }

    public String getColoresSemaforo() {
        StringBuilder sb = new StringBuilder();

        for (ColorSemaforo color : ColorSemaforo.values()) {
            sb.append(color.name()).append(": ").append(color.getSegundos()).append(" sg. ");
        }
        return sb.toString();
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Semaforo{");
        sb.append("estado=").append(estado);
        sb.append('}');
        return sb.toString();
    }

}
