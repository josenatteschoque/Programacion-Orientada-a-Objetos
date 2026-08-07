package modelo;

public class ArticuloRepetidoException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public ArticuloRepetidoException(String mensaje) {
		super(mensaje);
	}
}
