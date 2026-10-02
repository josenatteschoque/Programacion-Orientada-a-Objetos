package subte.aplicacion;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import net.datastructures.TreeMap;
import subte.datos.CargaParametros;
import subte.datos.CargaDatos;
import subte.interfaz.Interfaz;
import subte.modelo.Estacion;
import subte.modelo.Linea;
import subte.modelo.Tramo;
import subte.negocio.Calculo;

public class AplicacionConsultas {

	public static void main(String[] args) {

		// Cargar parametros
		try {
			CargaParametros.parametros();
		} catch (IOException e) {
			System.err.print("Error al cargar parámetros");
			System.exit(-1);
		}

		// Cargar datos
		TreeMap<String, Linea> lineas = null;
		TreeMap<String, Estacion> estaciones = null;
		List<Tramo> tramos = null;
		try {
			lineas = CargaDatos.cargarLineas(CargaParametros.getArchivoLinea());

			estaciones = CargaDatos.cargarEstaciones(
					CargaParametros.getArchivoEstacion(), lineas);

			tramos = CargaDatos.cargarTramos(CargaParametros.getArchivoTramo(),
					estaciones);

		} catch (FileNotFoundException e) {
			System.err.print("Error al cargar archivos de datos");
			System.exit(-1);
		}

		// Ingreso datos usuario
		int opcion = Interfaz.opcion();
		Estacion origen = Interfaz.ingresarEstacionOrigen(estaciones);
		Estacion destino = Interfaz.ingresarEstacionDestino(estaciones);

		// Realizar cálculo
		Calculo c = new Calculo(estaciones, tramos);

		List<Tramo> recorrido = null;
		if (opcion == Constante.MAS_RAPIDO)
			recorrido = c.rapido(origen, destino);

		// Mostrar resultado
		Interfaz.resultado(recorrido);

	}

}
