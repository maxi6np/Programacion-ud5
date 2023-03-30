package ArrayLists.GestionVentas;

import java.sql.SQLOutput;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) {

        Aplicacion app = new Aplicacion();

        app.anadirProducto(new Producto("1","Peluche","A",12.50,5));
        app.anadirProducto(new Producto("2","Balón","B",5.50,0));
        app.anadirProducto(new Producto("3","Playmobil","C",3.7,1));
        app.anadirProducto(new Producto("3","Playmobil","C",3.7,1));
        app.anadirProducto(new Producto("4","Scaletrix","A",7,2));
        app.anadirProducto(new Producto("5","Cluedo","B",8.99,4));
        app.anadirProducto(new Producto("6","FIFA","C",8.98,3));
        app.anadirProducto(new Producto("7","Barbie","A",1.1,3));
        app.anadirProducto(new Producto("8","LEGO","B",0.99,0));

        //app.borrarProducto("2");
        //app.borrarProducto("3");

        //app.modificarExistencias("8",7);
        //app.modificarExistencias("7",-5);

        //app.borrarProductosCategoria("A");
        //app.mostrarProductos();

        //System.out.println(app.existenciasProductos());;
        //app.mostrarProductos();

        //System.out.println(app.productosPorCategoria());;
        //app.mostrarProductos();

        HashMap<String,Integer> producto = new HashMap<>();
        producto.put("1",3);
        System.out.println(app.generarVenta("8989",producto));



    }
}
