package ArrayLists.Aplicacion;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        String palabra = "coche";

        Aplicacion app = new Aplicacion();

        app.anadirSinonimo("casa", "hogar");
        app.anadirSinonimo("casa", "domicilio");
        app.anadirSinonimo("coche", "automóvil");
        app.anadirSinonimo("coche", "carro");
        app.anadirSinonimo("coche", "vehículo");
        app.imprimirDiccionario();
        System.out.println("Eliminando sinonimos...");

        app.borrarSinonimo("casa", "chalet");
        app.borrarSinonimo("coche", "carro");

        app.imprimirDiccionario();
        System.out.println("Obtener sinónimos de " + palabra + ": " + app.obtenerSinonimo(palabra));


    }


}
