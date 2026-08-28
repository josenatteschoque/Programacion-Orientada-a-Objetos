package cuentas;

public class CuentaCorriente extends CuentaBancaria {

	private double descubierto;
	//Atributo nuevo
	private static double comisionCC;
	
	//geter y setert de el atributo comisionCC
	public static double getComisionCC() {
		return comisionCC;
	}

	public static void setComisionCC(double comisionCC) {
		CuentaCorriente.comisionCC = comisionCC;
	}

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

	@Override
	public double saldoDisponible() {
		// TODO Auto-generated method stub
		return this.getSaldo() + this.getDescubierto();
	}

	@Override
	public double obtenerSaldoDisponible() {
		return this.saldoDisponible();
	}

	@Override
	public double obtenerComision() {
		return this.getComisionCC();
	}
}
