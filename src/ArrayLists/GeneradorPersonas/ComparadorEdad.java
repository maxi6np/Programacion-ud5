package ArrayLists.GeneradorPersonas;

import java.util.Comparator;

public class ComparadorEdad implements Comparator<Persona> {
    @Override
    public int compare(Persona o1, Persona o2) {
        if (o1 != null && o2 != null){
            return o1.getEdad() - o2.getEdad();
        }
        return 0;
    }
}
