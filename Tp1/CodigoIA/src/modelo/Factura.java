package modelo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Factura {

	private int numero;
	private LocalDate fecha;
	private boolean tipoVenta; // true = contado, false = cuenta corriente, por ej.
	private List<ItemFactura> items = new ArrayList<>();

	public Factura(int numero, LocalDate fecha) {
		this.numero = numero;
		this.fecha = fecha;
	}

	public int getNumero() {
		return numero;
	}

	public LocalDate getFecha() {
		return fecha;
	}

	public boolean isTipoVenta() {
		return tipoVenta;
	}

	public void setTipoVenta(boolean tipoVenta) {
		this.tipoVenta = tipoVenta;
	}

	public List<ItemFactura> getItems() {
		return items;
	}

	public void agregarItem(Articulo articulo, double cantidad) {
		if (contieneArticulo(articulo)) {
			throw new ArticuloRepetidoException(
					"El articulo " + articulo.getDescripcion() + " ya fue agregado a la factura " + numero);
		}
		// descuenta stock (lanza StockInsuficienteException si no alcanza)
		articulo.descontarStock(cantidad);
		items.add(new ItemFactura(articulo, cantidad, articulo.getPrecio()));
	}

	private boolean contieneArticulo(Articulo articulo) {
		for (ItemFactura item : items) {
			if (item.getArticulo().getCodigo() == articulo.getCodigo()) {
				return true;
			}
		}
		return false;
	}

	public double importeTotal() {
		double total = 0;
		for (ItemFactura item : items) {
			total += item.importe();
		}
		return total;
	}
}
