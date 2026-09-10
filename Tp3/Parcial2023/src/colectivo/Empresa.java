package colectivo;

import java.util.ArrayList;

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
	
	
	
	
}
