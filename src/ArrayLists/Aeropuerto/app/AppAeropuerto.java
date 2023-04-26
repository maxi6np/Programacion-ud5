package ArrayLists.Aeropuerto.app;

import ArrayLists.Aeropuerto.modelo.Aeropuerto;

public class AppAeropuerto {

	public static void main(String[] args) {
		Aeropuerto aeropuerto = new Aeropuerto();

		aeropuerto.leerFicheroCursos();
		System.out.println("\nLista de vuelos ordenados alfabeticamente\n");
		aeropuerto.ordenAerolineasAlfabetico();
	/*	System.out.println("\nVuelos ordenados por plaza de la compañia Vueling\n");
		aeropuerto.regularPorPlazas("Vueling");
		System.out.println("\nLista de vuelos con plazas libres\n");
		aeropuerto.imprimirListaVuelos(aeropuerto.plazasLibres());
		aeropuerto.estadisticaDestino("MAD");
		System.out.println("\nSe han borrado " + aeropuerto.borrarVuelosEmpresa("98735424") + " vuelos");
		aeropuerto.imprimirPasajerosPorAerolinea("AA");
		aeropuerto.imprimirVuelosMasPasajerosQueMedia();
		aeropuerto.imprimirVuelosPorAerolineaOrdenadosPorPrecio("Vueling");*/

	}

}
