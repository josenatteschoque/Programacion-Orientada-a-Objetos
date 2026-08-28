package cuentas;

public class CajaAhorro extends CuentaBancaria {
	
	private double interesesGanados;
	//Atributo nuevo
	private static double comisionCA;
	
	//Getert y setert de comisionCA
	public static double getComisionCA() {
		return comisionCA;
	}

	public static void setComisionCA(double comisionCA) {
		CajaAhorro.comisionCA = comisionCA;
	}

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
			throw new SaldoInsuficienteException("Saldo: "+getSaldo());
		}else {
			double plata = getSaldo() - monto;
			setSaldo(plata);
		}
	}

	@Override
	public double saldoDisponible() {
		return this.getSaldo();
	}

	@Override
	public double obtenerSaldoDisponible() {
		return this.saldoDisponible();
	}

	@Override
	public double obtenerComision() {
		return this.getComisionCA();
	}
}
