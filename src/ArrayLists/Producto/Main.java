package ArrayLists.Producto;

public class Main {
    public static void main(String[] args) {
        GestorStock gs = new GestorStock();

        Producto p1 = new Producto(1, "papel", 3);
        Producto p2 = new Producto(2, "bici", 2);
        Producto p3 = new Producto(3, "balon", 4);
        Producto p4 = new Producto(3, "pelota", 4);

        gs.anadirProducto(p1);
        gs.anadirProducto(p2);
        gs.anadirProducto(p3);
        gs.recibirProducto(2,3);
        System.out.println(gs.cantidadEnStock(2));

    }
}
