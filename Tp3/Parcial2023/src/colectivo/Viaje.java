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

	public LocalDate getFecha() {
		return fecha;
	}

	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}

	public Colectivo getColectivo() {
		return colectivo;
	}

	public void setColectivo(Colectivo colectivo) {
		this.colectivo = colectivo;
	}

	public ArrayList<Pasaje> getPasajes() {
		return pasajes;
	}

	public void setPasajes(ArrayList<Pasaje> pasajes) {
		this.pasajes = pasajes;
	}

	public Recorrido getRecorrido() {
		return recorrido;
	}

	public void setRecorrido(Recorrido recorrido) {
		this.recorrido = recorrido;
	}
	
	
	
	
}
