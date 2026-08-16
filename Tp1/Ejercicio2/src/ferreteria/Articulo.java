package ferreteria;

import java.util.Objects;

public class Articulo {
	private int codigo;
	private String descripcion;
	private Double precio;
	private Double cantidad;
	
	public Articulo(int codigo, String descripcion, Double precio, Double cantidad) {
		super();
		this.codigo = codigo;
		this.descripcion = descripcion;
		this.precio = precio;
		this.cantidad = cantidad;
	}
	
	public int getCodigo() {
		return codigo;
	}
	
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	
	public String getDescripcion() {
		return descripcion;
	}
	
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	public Double getPrecio() {
		return precio;
	}
	
	public void setPrecio(Double precio) {
		this.precio = precio;
	}
	
	public Double getCantidad() {
		return cantidad;
	}
	
	public void setCantidad(Double cantidad) {
		this.cantidad = cantidad;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(cantidad, codigo, descripcion, precio);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Articulo other = (Articulo) obj;
		return cantidad == other.cantidad && codigo == other.codigo && Objects.equals(descripcion, other.descripcion)
				&& Objects.equals(precio, other.precio);
	}

	@Override
	public String toString() {
		return "Articulo [codigo=" + codigo + ", descripcion=" + descripcion + ", precio=" + precio + ", cantidad="
				+ cantidad + "]";
	}
	
	
}
