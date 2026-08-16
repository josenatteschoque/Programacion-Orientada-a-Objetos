package ferreteria;

import java.util.Objects;

public class ItemFactura {
	private double cantidad;
	private double precio;
	
	public ItemFactura(double cantidad, double precio) {
		super();
		this.cantidad = cantidad;
		this.precio = precio;
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

	@Override
	public int hashCode() {
		return Objects.hash(cantidad, precio);
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
		return Double.doubleToLongBits(cantidad) == Double.doubleToLongBits(other.cantidad)
				&& Double.doubleToLongBits(precio) == Double.doubleToLongBits(other.precio);
	}

	@Override
	public String toString() {
		return "ItemFactura [cantidad=" + cantidad + ", precio=" + precio + "]";
	}
	
	
}
