package banco;

import java.time.LocalDate;
import java.util.List;

public class TarjetaCredito extends Tarjeta{
	private double limite;
	private List<Movimiento> movimientos;
	
	@Override
	public void realizarPago(LocalDate fecha, String detalle, double importe) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public double obtenerSaldo() {
		// TODO Auto-generated method stub
		return 0;
	}
	
	
}
