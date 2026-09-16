package md;

import java.util.Objects;

public abstract class Vehiculo {
	private String patente;
	private String modelo;
	private static double porComisionVehiculo = 10;
	
	
	public Vehiculo(String patente, String modelo) {
		super();
		this.patente = patente;
		this.modelo = modelo;
	}

	public String getPatente() {
		return patente;
	}

	public void setPatente(String patente) {
		this.patente = patente;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public static double getPorComisionVehiculo() {
		return porComisionVehiculo;
	}

	public static void setPorComisionVehiculo(double porComisionVehiculo) {
		Vehiculo.porComisionVehiculo = porComisionVehiculo;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(patente);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Vehiculo other = (Vehiculo) obj;
		return Objects.equals(patente, other.patente);
	}

	@Override
	public String toString() {
		return "Vehiculo [patente=" + patente + ", modelo=" + modelo + "]";
	}

	public abstract double calcularCostoViaje(int distancia);
	
	public double calcularPrecioViaje(int distancia) {
		return calcularCostoViaje(distancia) * (1 + getPorComisionVehiculo() / 100.0);
	}
}
