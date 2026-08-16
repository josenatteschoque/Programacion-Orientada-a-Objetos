package ferreteria;

import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.ArrayList;

public class Factura {
	private int numero;
	private Date fecha;
	private List<ItemFactura> items;
	
	public Factura(int numero, Date fecha) {
		super();
		this.numero = numero;
		this.fecha = fecha;
		this.items = new ArrayList<>();
	}
	
	public List<ItemFactura> getItems() {
		return items;
	}

	public void setItems(List<ItemFactura> items) {
		this.items = items;
	}

	public int getNumero() {
		return numero;
	}
	
	public void setNumero(int numero) {
		this.numero = numero;
	}
	
	public Date getFecha() {
		return fecha;
	}
	
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	@Override
	public int hashCode() {
		return Objects.hash(fecha, items, numero);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Factura other = (Factura) obj;
		return Objects.equals(fecha, other.fecha) && Objects.equals(items, other.items) && numero == other.numero;
	}

	@Override
	public String toString() {
		return "Factura [numero=" + numero + ", fecha=" + fecha + ", items=" + items + "]";
	}
	
	//Metodo para agragar los items ala lista
	public void agragarItem(ItemFactura item) {
		items.add(item);
	}
}
