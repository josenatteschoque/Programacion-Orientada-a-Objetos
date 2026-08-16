package ferreteria;

import java.util.Objects;

public class ItemFactura {
	private double cantidad;
	private double precio;
	private Articulo articulo;
	
	public ItemFactura(double cantidad, double precio, Articulo articulo) {
		super();
		this.cantidad = cantidad;
		this.precio = precio;
		this.articulo = articulo;
	}
	
	public double getCantidad() {
		return cantidad;
	}
	
	public void setCantidad(double cantidad) {
		this.cantidad = cantidad;
	}
	
	public double getPrecio() {
		return precio;
	}
	
	public void setPrecio(double precio) {
		this.precio = precio;
	}
	
	public Articulo getArticulo() {
		return articulo;
	}
	
	public void setArticulo(Articulo articulo) {
		this.articulo = articulo;
	}

	@Override
	public int hashCode() {
		return Objects.hash(articulo, cantidad, precio);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ItemFactura other = (ItemFactura) obj;
		return Objects.equals(articulo, other.articulo)
				&& Double.doubleToLongBits(cantidad) == Double.doubleToLongBits(other.cantidad)
				&& Double.doubleToLongBits(precio) == Double.doubleToLongBits(other.precio);
	}

	@Override
	public String toString() {
		return "ItemFactura [cantidad=" + cantidad + ", precio=" + precio + ", articulo=" + articulo + "]";
	}
	

	
}
