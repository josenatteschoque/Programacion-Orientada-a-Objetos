package md;

import java.time.LocalDateTime;
import java.util.Objects;

public class Viaje {
	private LocalDateTime fechaHora;
	private int distancia;
	private Vehiculo vehiculo;
	
	public Viaje(LocalDateTime fechaHora, int distancia, Vehiculo vehiculo) {
		super();
		this.fechaHora = fechaHora;
		this.distancia = distancia;
		this.vehiculo = vehiculo;
	}
	
	public LocalDateTime getFechaHora() {
		return fechaHora;
	}
	
	public void setFechaHora(LocalDateTime fechaHora) {
		this.fechaHora = fechaHora;
	}
	
	public int getDistancia() {
		return distancia;
	}
	
	public void setDistancia(int distancia) {
		this.distancia = distancia;
	}
	
	public Vehiculo getVehiculo() {
		return vehiculo;
	}
	
	public void setVehiculo(Vehiculo vehiculo) {
		this.vehiculo = vehiculo;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(distancia, fechaHora, vehiculo);
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Viaje other = (Viaje) obj;
		return distancia == other.distancia && Objects.equals(fechaHora, other.fechaHora)
				&& Objects.equals(vehiculo, other.vehiculo);
	}
	
	@Override
	public String toString() {
		return "Viaje [fechaHora=" + fechaHora + ", distancia=" + distancia + ", vehiculo=" + vehiculo + "]";
	}
	
	public double calcularCosto() {
		return this.vehiculo.calcularCostoViaje(distancia);
	}
	
	public double calcularPrecio() {
		return this.vehiculo.calcularPrecioViaje(distancia);
	}
	
}
