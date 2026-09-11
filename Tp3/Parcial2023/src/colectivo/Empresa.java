package colectivo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Empresa {
	private String nombre;
	private String cuit;
	private ArrayList<Tramo> tramos;
	private ArrayList<Viaje> viajes; 
	
	public Empresa(String nombre, String cuit) {
		super();
		this.nombre = nombre;
		this.cuit = cuit;
		tramos = new ArrayList<>();
		viajes = new ArrayList<>();
	}
	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getCuit() {
		return cuit;
	}

	public void setCuit(String cuit) {
		this.cuit = cuit;
	}

	public ArrayList<Tramo> getTramos() {
		return tramos;
	}

	public void setTramos(ArrayList<Tramo> tramos) {
		this.tramos = tramos;
	}

	public ArrayList<Viaje> getViajes() {
		return viajes;
	}

	public void setViajes(ArrayList<Viaje> viajes) {
		this.viajes = viajes;
	}

	/**
	 * Tramo que contiene el precio del pasaje para las localidades ingresadas
	 * 
	 * @param origen:  localidad donde sube el pasajero
	 * @param destino: localidad donde baja el pasajero
	 * @return tramo que contiene el precio del pasaje o null si la empresa no vende
	 *         pasajes para las localidades ingresadas
	 */
	public Tramo tramoPasaje(Localidad origen, Localidad destino) {
		for(Tramo t: tramos) {
			if(t.getOrigen().equals(origen) && t.getDestino().equals(destino)) {
				return t;
			}
		}
		return null;
	}

	/**
	 * Viajes que salen en la fecha dada y pasan por el tramo indicado
	 * 
	 * @param fecha:   fecha en la que realiza el viaje
	 * @param origen:  localidad donde sube el pasajero
	 * @param destino: localidad donde baja el pasajero
	 * @return Lista de todos los viajes que cumplen con la condición solicitada.
	 *         Retorna null si la empresa no vende pasajes para las localidades
	 *         ingresadas (utilizar el método "tramos" ya implementado para la 
	 *         validación)
	 */
	public List<Viaje> viaje(LocalDate fecha, Localidad origen, Localidad destino){
		Tramo tramo = tramoPasaje(origen, destino);
		
		//Verifico si el tramo existe
		if(tramo == null) {
			return null;
		}
		
		//Recorro la lista de viajes y si coinciden con la fecha lo agrego ala lista
		List<Viaje> resul = new ArrayList<>();
		for(Viaje v: viajes) {
			if(v.getFecha().equals(fecha)) {
				resul.add(v);
			}
		}
		
		return resul;
	}

	
	
}
