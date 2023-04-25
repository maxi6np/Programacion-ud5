package ArrayLists.Aeropuerto.modelo;

import java.util.Comparator;

public class ComparatorPlazas implements Comparator<Regular> {
    @Override
    public int compare(Regular o1, Regular o2) {
        if (o1!= null && o2!=null){
            return Integer.compare(o2.getPlazasLibres(),o1.getPlazasLibres());
        }
        return 0;
    }
}
