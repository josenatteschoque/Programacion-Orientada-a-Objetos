package subte.aplicacion;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import net.datastructures.TreeMap;
import subte.datos.CargaParametros;
import subte.datos.dao.DAOFactory;
import subte.datos.dao.DAOLoader;
import subte.datos.dto.EstacionDTO;
import subte.datos.dto.LineaDTO;
import subte.datos.dto.TramoDTO;
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
			System.err.print("Error al cargar par�metros");
			System.exit(-1);
		}

		//Cargar datos
		TreeMap<String, Linea> lineas = new TreeMap<>();
		TreeMap<String, Estacion> estaciones = new TreeMap<>();
		List<Tramo> tramos = new ArrayList<>();

		try {
		    // 1. OBTENER LA FÁBRICA POLIMÓRFICA ACTIVA
		    DAOFactory fabrica = DAOLoader.getFactory();

		    // 2. Obtener los datos puros delegando de forma abstracta
		    List<LineaDTO> lineasDto = fabrica.getLineaDAO().obtenerTodas();
		    List<EstacionDTO> estacionesDto = fabrica.getEstacionDAO().obtenerTodas();
		    List<TramoDTO> tramosDto = fabrica.getTramoDAO().obtenerTodos();

		    // 2. MAPEO: De LineaDTO a Linea (Modelo)
		    for (LineaDTO dto : lineasDto) {
		        lineas.put(dto.getCodigo(), new Linea(dto.getCodigo(), dto.getNombre()));
		    }

		    // 3. MAPEO: De EstacionDTO a Estacion (Modelo) vinculando el objeto Linea real
		    for (EstacionDTO dto : estacionesDto) {
		        Linea lineaModelo = lineas.get(dto.getCodigoLinea());
		        estaciones.put(dto.getCodigo(), new Estacion(dto.getCodigo(), dto.getNombre(), lineaModelo));
		    }

		    // 4. MAPEO: De TramoDTO a Tramo (Modelo) vinculando las Estaciones reales
		    for (TramoDTO dto : tramosDto) {
		        Estacion v1 = estaciones.get(dto.getCodigoEstacion1());
		        Estacion v2 = estaciones.get(dto.getCodigoEstacion2());
		        if (v1 != null && v2 != null) {
		            tramos.add(0, new Tramo(v1, v2, dto.getTiempo(), dto.getTipo()));
		        }
		    }

		} catch (Exception e) {
		    System.err.print("Error en el flujo de persistencia/mapeo: " + e.getMessage());
		    System.exit(-1);
		}


		// Ingreso datos usuario
		int opcion = Interfaz.opcion();
		Estacion origen = Interfaz.ingresarEstacionOrigen(estaciones);
		Estacion destino = Interfaz.ingresarEstacionDestino(estaciones);

		// Realizar c�lculo
		Calculo c = new Calculo(estaciones, tramos);

		List<Tramo> recorrido = null;
		if (opcion == Constante.MAS_RAPIDO)
			recorrido = c.rapido(origen, destino);

		// Mostrar resultado
		Interfaz.resultado(recorrido);

	}

}
