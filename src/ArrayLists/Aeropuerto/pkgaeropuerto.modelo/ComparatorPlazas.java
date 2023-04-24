package ArrayLists.Aeropuerto.pkgaeropuerto.modelo;

import java.util.Comparator;

public class ComparatorPlazas implements Comparator<Vuelo> {
    @Override
    public int compare(Vuelo o1, Vuelo o2) {
        if (o1!= null && o2!=null){
            return Integer.compare(o1.getPlazas(),o2.getPlazas());
        }
        return 0;
    }
}
