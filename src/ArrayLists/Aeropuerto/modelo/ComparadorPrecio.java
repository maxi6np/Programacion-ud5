package ArrayLists.Aeropuerto.modelo;

import java.util.Comparator;

public class ComparadorPrecio implements Comparator<Vuelo> {

    @Override
    public int compare(Vuelo o1, Vuelo o2) {
        if (o1 != null && o2 != null){
            return (int) (o1.precioBillete() - o2.precioBillete());
        }
        return 0;
    }
}
