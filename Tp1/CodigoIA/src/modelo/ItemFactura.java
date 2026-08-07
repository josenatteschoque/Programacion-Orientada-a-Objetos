package modelo;

public class ItemFactura {

	private Articulo articulo;
	private double cantidad;
	private double precio; // precio "congelado" al momento de facturar

	public ItemFactura(Articulo articulo, double cantidad, double precio) {
		this.articulo = articulo;
		this.cantidad = cantidad;
		this.precio = precio;
	}

	public Articulo getArticulo() {
		return articulo;
	}

	public double getCantidad() {
		return cantidad;
	}

	public double getPrecio() {
		return precio;
	}

	public double importe() {
		return cantidad * precio;
	}
}
