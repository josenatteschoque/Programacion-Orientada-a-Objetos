package modelo;

public class Articulo {

	private int codigo;
	private String descripcion;
	private double precio;
	private double cantidad; // stock disponible

	public Articulo(int codigo, String descripcion, double precio, double cantidad) {
		this.codigo = codigo;
		this.descripcion = descripcion;
		this.precio = precio;
		this.cantidad = cantidad;
	}

	public int getCodigo() {
		return codigo;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public double getCantidad() {
		return cantidad;
	}

	// Descuenta stock al vender; lanza excepcion si no alcanza
	protected void descontarStock(double cantidadVendida) {
		if (cantidadVendida > this.cantidad) {
			throw new StockInsuficienteException(
					"No hay stock suficiente, quedan " + this.cantidad + " " + this.descripcion);
		}
		this.cantidad -= cantidadVendida;
	}

	@Override
	public String toString() {
		return descripcion;
	}
}
