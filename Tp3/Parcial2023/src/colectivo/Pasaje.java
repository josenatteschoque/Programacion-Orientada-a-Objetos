package colectivo;

public class Pasaje {
	private String nombre;
	private String dni;
	private int asiento;
	private Tramo tramo; 
	
	public Pasaje(String nombre, String dni, int asiento, Tramo tramo) {
		super();
		this.nombre = nombre;
		this.dni = dni;
		this.asiento = asiento;
		this.tramo = tramo;
	}
	
	
}
