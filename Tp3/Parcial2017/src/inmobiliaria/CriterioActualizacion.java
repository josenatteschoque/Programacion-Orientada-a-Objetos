package inmobiliaria;

public class CriterioActualizacion {
	private String nombre;
	private double valorVigente;
	
	public CriterioActualizacion(String nombre, double valorVigente) {
		super();
		this.nombre = nombre;
		this.valorVigente = valorVigente;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public double getValorVigente() {
		return valorVigente;
	}
	
	public void setValorVigente(double valorVigente) {
		this.valorVigente = valorVigente;
	}
	
	
}
