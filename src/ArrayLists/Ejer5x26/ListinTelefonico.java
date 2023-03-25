package ArrayLists.Ejer5x26;

import java.util.HashMap;
import java.util.Set;

public class ListinTelefonico {
    HashMap<String, String> listinTelefonico = new HashMap<String, String>();

    public ListinTelefonico() {
        listinTelefonico = new HashMap<>();
    }

    public void introducirNumero(String nombre, String numero) {
        listinTelefonico.put(nombre, numero);
    }

    public String buscarNumero(String nombre) {
        return listinTelefonico.get(nombre);
    }

    public void escribirListin() {
        Set<String> nombres = listinTelefonico.keySet();

        for (String nombre : nombres) {
            System.out.println(nombre);
        }
    }


}
