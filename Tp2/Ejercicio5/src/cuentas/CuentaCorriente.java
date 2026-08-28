package cuentas;

public class CuentaCorriente extends CuentaBancaria {

	private double descubierto;
	
	public CuentaCorriente (int numero, Cliente titular, double descubierto) {
		super (numero, titular);
		this.descubierto = descubierto;
	}

	public CuentaCorriente (int numero, Cliente titular) {
		super (numero, titular);
		this.descubierto = 0;
	}

	public void extraer (double monto) throws SaldoInsuficienteException{
		if (monto > getSaldo() + descubierto)
			throw new SaldoInsuficienteException("Saldo: "+getSaldo());
		else {
			setSaldo ( getSaldo() - monto );
		}
	}

	public double getDescubierto ( ) {
			return descubierto;
	}
	
	public void setDescubierto (double valor) {
			descubierto = valor;
	}
}
