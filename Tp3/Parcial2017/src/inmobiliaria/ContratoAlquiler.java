package inmobiliaria;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ContratoAlquiler {

	//private double precio;
	
	private Date fechaInicio;
	private Date fechaFin;
	private List<Inquilino> inquilinos;
	private static int MAX_INQUILINOS=3;
	
	//Agregue nuevos atributos
	private double precioInicial;
	private double precioVigente;
	
	public ContratoAlquiler(double precio, double precioInicial, double precioVigente, Date fechaInicio, Date fechaFin, String nombre, String dni) throws Exception {
		super();
		this.precio = precio;
		this.precioInicial = precioInicial;
		this.precioVigente = precioInicial;
		
		this.fechaInicio = fechaInicio;
		this.fechaFin = fechaFin;
		this.inquilinos = new ArrayList<Inquilino>();
		agregarInquilino(nombre, dni);
	}

	public Inquilino agregarInquilino(String nombre, String dni) throws Exception {
		if (inquilinos.size()>= MAX_INQUILINOS)
			throw new Exception();
		Inquilino i = new Inquilino(nombre, dni);
		inquilinos.add(i);
		return i;
	}

	public double getPrecioVigente() {
		return this.getPrecioVigente();
	}

	public void actualizarPrecio() {
	}

	public double getPrecioInicial() {
		return precioInicial;
	}

	public Date getFechaInicio() {
		return fechaInicio;
	}

	public void setFechaInicio(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public Date getFechaFin() {
		return fechaFin;
	}

	public void setFechaFin(Date fechaFin) {
		this.fechaFin = fechaFin;
	}


	private class Inquilino {
		private String nombre;
		private String dni;

		public Inquilino(String nombre, String dni) {
			super();
			this.nombre = nombre;
			this.dni = dni;
		}

	}
}
