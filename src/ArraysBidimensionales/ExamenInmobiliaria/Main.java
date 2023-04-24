package ArraysBidimensionales.ExamenInmobiliaria;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Inmobiliaria im = new Inmobiliaria();

        Inmueble f1 = new Finca("abc", 12.34, 1200, new Direccion("Siero", "CALLE 1"), EstadoInmueble.SE_ALQUILA, true);
        Inmueble f2 = new Finca("ABC", 14.34, 1500, new Direccion("Llanes", "CALLE 2"), EstadoInmueble.SE_ALQUILA, false);
        Inmueble g1 = new Garaje("fgh", 100, 2000, new Direccion("Áviles", "CALLE 3"), EstadoInmueble.SE_ALQUILA, false);
        Inmueble g2 = new Garaje("ijk", 32.54, 200, new Direccion("Gijón", "CALLE 1"), EstadoInmueble.SE_ALQUILA, true);
        Inmueble v1 = new Vivienda("lmn", 9.96, 99999, new Direccion("Oviedo", "CALLE 5"), EstadoInmueble.SE_VENDE, 3, 2);
        Inmueble v2 = new Vivienda("opq", 5, 120000, new Direccion("Nava", "CALLE 6"), EstadoInmueble.SE_VENDE, 1, 1);
        Inmueble v3 = new Vivienda("rst", 5.5, 4400, new Direccion("Siero", "CALLE 7"), EstadoInmueble.SE_VENDE, 2, 2);

        im.anadirInmueble(f1);
        im.anadirInmueble(f2);
        im.anadirInmueble(g1);
        im.anadirInmueble(g2);
        im.anadirInmueble(v1);
        im.anadirInmueble(v2);
        im.anadirInmueble(v3);

        //System.out.println(Arrays.toString(im.empleadosSegundoApellidoEmpiezaPor("gar")));;
        //System.out.println(im.inmueblesPorMunicipio("siero"));;
        //System.out.println(im.inmueblesPorCodigo());
        //System.out.println(im.inmueblesPorPrecio());
        //System.out.println(im.inmueblesSinFincas());
        //System.out.println(im.precioMedioVentaViviendas());


        im.alquilarInmbueble("ABC","36259536P");
        im.alquilarInmbueble("abc","99625423F");
        im.alquilarInmbueble("fgh","99625423F");
        im.alquilarInmbueble("ijk","36259536P");

        im.venderInmbueble("lmn","36259536P");
        im.venderInmbueble("opq","63265932L");
        im.venderInmbueble("rst","36259536P");


        //im.imprimirMatrizOperaciones(im.getEmpleados().get(0).getOperaciones());
        //im.imprimirMatrizOperaciones(im.getEmpleados().get(1).getOperaciones());
        //im.imprimirMatrizOperaciones(im.totalOperaciones());

        //System.out.println(im.viviendasPorMunicipio());
        //System.out.println(im.estadosInmuebles());
        im.imprimirOperacionesPorDNI();
        //System.out.println(im.estadisticasViviendas());
    }
}
