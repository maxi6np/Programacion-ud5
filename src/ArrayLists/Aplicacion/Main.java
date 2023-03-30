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


        System.out.println("Introduciendo nuevo diccionario...");
        HashMap<String, HashSet<String>> diccionario2 = new HashMap<>();
        HashSet<String> sinonimos1 = new HashSet<>();
        sinonimos1.add("fuerte");
        sinonimos1.add("potente");
        diccionario2.put("poderoso", sinonimos1);

        HashSet<String> sinonimos2 = new HashSet<>();
        sinonimos2.add("veloz");
        sinonimos2.add("rápido");
        diccionario2.put("ágil", sinonimos2);

        app.anadirDiccionario(diccionario2);
        app.imprimirDiccionario();


    }


}
