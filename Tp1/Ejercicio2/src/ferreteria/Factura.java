package ferreteria;

import java.util.Date;

public class Factura {
	private int numero;
	private Date fecha;
	private boolean tipoVenta;
	
	public Factura(int numero, Date fecha, boolean tipoVenta) {
		super();
		this.numero = numero;
		this.fecha = fecha;
		this.tipoVenta = tipoVenta;
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
	
	public boolean isTipoVenta() {
		return tipoVenta;
	}
	
	public void setTipoVenta(boolean tipoVenta) {
		this.tipoVenta = tipoVenta;
	}
	
	@Override
	public String toString() {
		return "Factura [numero=" + numero + ", fecha=" + fecha + ", tipoVenta=" + tipoVenta + "]";
	}
	
	
}
