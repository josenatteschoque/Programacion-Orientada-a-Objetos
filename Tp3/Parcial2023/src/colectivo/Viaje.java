package colectivo;

import java.time.LocalDate;
import java.util.ArrayList;

public class Viaje {
	private LocalDate fecha;
	private Colectivo colectivo;
	private ArrayList<Pasaje> pasajes;
	private Recorrido recorrido;

	public Viaje(LocalDate fecha, Colectivo cole, Recorrido recorrido) {
		super();
		this.fecha = fecha;
		this.colectivo = cole;
		this.recorrido = recorrido;
		pasajes = new ArrayList<>();
	}
	
	
	
	
}
