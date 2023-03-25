package ArrayLists.Aplicacion;

public class Main {
    public static void main(String[] args) {

        Aplicacion app = new Aplicacion();

        app.anadirSinonimo("casa", "hogar");
        app.anadirSinonimo("casa", "domicilio");
        app.anadirSinonimo("coche", "automóvil");
        app.anadirSinonimo("coche", "carro");
        app.anadirSinonimo("coche", "vehículo");

        app.imprimirDiccionario();
    }


}
