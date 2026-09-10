package colectivo;
import java.util.ArrayList;
import java.util.List;

public class Recorrido {
	private int id;
	private ArrayList<Localidad> localidades;
	
	public Recorrido(int id) {
		super();
		this.id = id;
		localidades = new ArrayList<>();
	}
	
	/**
	 * Listado de todas las localidades por las que pasa el colectivo entre dos
	 * localidades dadas
	 * 
	 * @param origen:  localidad inicial del tramo
	 * @param destino: localidad final del tramo
	 * @return retorna una lista con todas las localidades de un tramo dado. En la
	 *         lista retornada incluye la localidad de origen y no incluye la
	 *         localidad de destino
	 */
	public List<Localidad> tramos(Localidad origen, Localidad destino){
		List<Localidad> listado = new ArrayList<>();
		int pOrigen = localidades.indexOf(origen);
		int pDestino = localidades.indexOf(destino);

		if(pOrigen <= pDestino) {
			listado = localidades.subList(pOrigen, pDestino);
		}
		
		return listado;
	}

}
