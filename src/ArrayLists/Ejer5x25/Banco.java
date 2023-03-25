package ArrayLists.Ejer5x25;

import java.util.HashMap;
import java.util.Set;

public class Banco {
    HashMap<String, Cuenta> cuentasBancarias = new HashMap<String, Cuenta>();
    // la clave es el identificador de un cliente, el valor la cuenta asociada


    public Banco() {
        cuentasBancarias = new HashMap<String, Cuenta>();
    }

    public void addCuenta(String nombre, int numCuenta, int balance) {
        cuentasBancarias.put(nombre,new Cuenta(nombre,numCuenta, balance));
    }

    public Cuenta getCuenta(String nombre) {
        return cuentasBancarias.get(nombre);
    }

    public void listarClientes() {
        Set<String> ids = cuentasBancarias.keySet();
        for (String id : ids) {
            System.out.println(id);
        }
    }
}
