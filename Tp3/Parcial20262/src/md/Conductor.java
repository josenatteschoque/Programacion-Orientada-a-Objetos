package md;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Conductor implements Contribuyente{
	private String nombre; 
	private String cuit;
	private static double porComisionAplicacion = 30;
	private List<Viaje> viajes;
	
	
	public Conductor(String nombre, String cuit) {
		super();
		this.nombre = nombre;
		this.cuit = cuit;
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

	public static double getPorComisionAplicacion() {
		return porComisionAplicacion;
	}

	public static void setPorComisionAplicacion(double porComisionAplicacion) {
		Conductor.porComisionAplicacion = porComisionAplicacion;
	}

	public List<Viaje> getViajes() {
		return viajes;
	}

	public void setViajes(List<Viaje> viajes) {
		this.viajes = viajes;
	}

	@Override
	public int hashCode() {
		return Objects.hash(cuit, nombre, viajes);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Conductor other = (Conductor) obj;
		return Objects.equals(cuit, other.cuit) && Objects.equals(nombre, other.nombre)
				&& Objects.equals(viajes, other.viajes);
	}

	@Override
	public String toString() {
		return "Conductor [nombre=" + nombre + ", cuit=" + cuit + ", viajes=" + viajes + "]";
	}

	//Cargo ala lista con el nuevo viaje
	public void agregarViaje(Vehiculo v, LocalDateTime t, int i) {
		Viaje nuevo = new Viaje(t, i, v);
		viajes.add(nuevo);
	}
	
	/*El sueldo que se le paga a un conductor es igual a la suma del costo de todos los viajes 
	 * realizados menos un 30%*/
	public double calcularSueldo() {
		double sueldo = 0;
		for(Viaje v: viajes) {
			sueldo += v.calcularCosto();
		}
		return sueldo * (1 - porComisionAplicacion / 100);
	}

	/*Una retención es un descuento impositivo que se descuenta en concepto de impuestos
	 * (en este caso IIBB, que es Ingresos Brutos en Argentina).*/
	@Override
	public double calcularRetencionIIBB() {
		return this.calcularSueldo() * (this.ALICUOTA / 100.0);		
	}
	
	
}
