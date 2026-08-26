package cuentas;

public class ClienteMaxCuentasException extends RuntimeException{
	public ClienteMaxCuentasException(String mensaje) {
		super(mensaje);
	}
}
