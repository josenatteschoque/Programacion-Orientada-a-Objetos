package inmobiliaria;

import java.util.Date;

public abstract class Inmueble {

	private String domicilio;
	private Propietario propietario;
	private ContratoAlquiler alquiler;

	public Inmueble(String domicilio, Propietario propietario) {
		super();
		this.domicilio = domicilio;
		this.propietario = propietario;
	}

	abstract public double valorAlquiler();

	public void alquilar(double precio, Date fechaInicio, Date fechaFin, String nombre, String dni) throws Exception {
		if (alquiler != null)
			throw new InmuebleNoDisponibleException();
		alquiler = new ContratoAlquiler(precio, fechaInicio, fechaFin, nombre, dni);
	}

	public Propietario getPropietario() {
		return propietario;
	}

	public void setPropietario(Propietario propietario) {
		this.propietario = propietario;
	}

	public String getDomicilio() {
		return domicilio;
	}

	public void setDomicilio(String domicilio) {
		this.domicilio = domicilio;
	}

	public ContratoAlquiler getAlquiler() {
		return alquiler;
	}

	public void setAlquiler(ContratoAlquiler alquiler) {
		this.alquiler = alquiler;
	}

}
