package cuentas;

public abstract class Cliente implements OperacionBanco{
	
	private Domicilio direccion;
	private String email;
	private static int maximoCuentas = 10;

	private CuentaBancaria[ ] cuentas;
	
	private int cantidadCuentas;

	public Cliente (String calle, int numero, String entre1, String entre2,
							String codigoPostal, String telefono, String email) {
		this.direccion = new Domicilio (calle, numero, entre1, entre2, codigoPostal, telefono);
		this.email = email;
		this.cuentas = new CuentaBancaria [maximoCuentas];
		this.cantidadCuentas = 0;
	}
	
	public static int getMaximoCuentas() {
		return maximoCuentas;
	}

	public static void setMaximoCuentas(int maximoCuentas) {
		Cliente.maximoCuentas = maximoCuentas;
	}
	
	public Domicilio getDireccion ( ) {
			return direccion;
	}
	
	public void	setDireccion (Domicilio valor) {
			direccion = valor;
	}

	public String getEmail ( ) {
			return email;
	}
	
	public void setEmail (String valor) {
			email = valor;
	}
	
	public CuentaBancaria[ ] getCuentas ( ) {
			return cuentas;
	}

	public void agregarCuenta (CuentaBancaria cuenta) throws ClienteMaxCuentasException{
		if (cantidadCuentas < maximoCuentas) {
			cuentas [cantidadCuentas] = cuenta;
			cantidadCuentas++;
		}
		else {
			throw new ClienteMaxCuentasException("Supera el maximo de cuentas!");
		}
	}
	//g)Implementar el método saldoTotal() en la clase Cliente que retorna la suma del saldo de todas las cuentas para un cliente. 
	public double saldoTotal() {
		double saldo = 0;
		for(int i = 0; i < cantidadCuentas; i++) {
			saldo += cuentas[i].getSaldo();
		}
		return saldo;
 	}
	
	public double saldoDisponibleTotal() {
		double saldo = 0;
		for(int i = 0; i < cantidadCuentas; i++) {
			saldo += cuentas[i].saldoDisponible();
		}
		return saldo;
	}
	
	public void pagarTarjetaCredito(double importe) throws SaldoInsuficienteException{
		if(importe > saldoDisponibleTotal()) {
			throw new SaldoInsuficienteException("Saldo Insuficiente!");
		}
		
		double restante = importe;
		for(int i = 0; i < cantidadCuentas && restante > 0; i++) {
			if(cuentas[i] instanceof CajaAhorro) {
				double aDebitar = Math.min(restante, cuentas[i].saldoDisponible());
				
				cuentas[i].setSaldo(cuentas[i].getSaldo() - aDebitar);
				restante -= aDebitar;
			}
		}
		
		for(int j = 0; j < cantidadCuentas && restante > 0; j++) {
			if(cuentas[j] instanceof CuentaCorriente) {
				double aDebitar = Math.min(restante, cuentas[j].saldoDisponible());
				cuentas[j].setSaldo(cuentas[j].getSaldo() - aDebitar);
				restante -= aDebitar;
			}
		}
	}
	
	public double obtenerComision() {
		double comision = 0;
		for(int i = 0; i < cantidadCuentas; i++) {
			comision += cuentas[i].obtenerComision();
		}
		return comision;
	}
	
	@Override
	public double obtenerSaldoDisponible() {
		return this.saldoDisponibleTotal();
	}

	
	public int getCantidadCuentas ( ) {
			return cantidadCuentas;
	}

	private class Domicilio {
		String calle;
		int numero;
		String entre1;
		String entre2;
		String codigoPostal;
		String telefono;
		
		private Domicilio (String calle, int numero, String entre1, String entre2,
 							String codigoPostal, String telefono) {
			this.calle = calle;
			this.numero = numero;
			this.entre1 = entre1;
			this.entre2 = entre2;
			this.codigoPostal = codigoPostal;
			this.telefono = telefono;
		}

		public String getTelefono ( ) {
				return telefono;
		}
		
		public void setTelefono (String valor) {
				telefono = valor;
		}

		public String getCalle ( ) {
				return calle;
		}

		public String getCodigoPostal ( ) {
				return codigoPostal;
		}

		public String [ ] getEntreCalles ( ) {
			String [ ] entre = new String [2];
			entre [0] = entre1;
			entre [1] = entre2;
			return entre;
		}

		public int getNumero ( ) {
				return numero;
		}
	}
}
