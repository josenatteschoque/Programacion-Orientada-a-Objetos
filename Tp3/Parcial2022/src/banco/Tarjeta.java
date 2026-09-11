package banco;

import java.time.LocalDate;

public abstract class Tarjeta implements OperacionBanco {
	private int nroTargeta;
	private LocalDate validaDesde;
	private LocalDate validaHasta;
	private boolean bloqueada;
	
	private CajaAhorro cajaAhorro;
	private Titular titular;
	
	public abstract void realizarPago(LocalDate fecha, String detalle, double importe);
		
}
