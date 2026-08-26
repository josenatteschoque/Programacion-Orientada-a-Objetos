package cuentas;

public class CajaAhorro extends CuentaBancaria {
	
	private double interesesGanados;

	public CajaAhorro (int numero, Cliente titular) {
		super (numero, titular);
		this.interesesGanados = 0;
	}

	public double getInteresesGanados ( ) {
			return interesesGanados;
	}
	
	public void setInteresesGanados (double valor) {
			interesesGanados = valor;
		}

	public void pagarIntereses( ) {
		setSaldo ( getSaldo() + interesesGanados );
		interesesGanados = 0;
	}

	@Override
	public void extraer(double monto) throws SaldoInsuficienteException{
		// TODO Auto-generated method stub
		if(monto > getSaldo()){
			throw new SaldoInsuficienteException("Saldo insuficiente: "+getSaldo());
		}else {
			double plata = getSaldo() - monto;
			setSaldo(plata);
		}
	}
}
