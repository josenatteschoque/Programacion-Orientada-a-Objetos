package inmobiliaria;

public class Vivienda extends Inmueble{
	
	private int nroDormitorio;
	
	public Vivienda(String domicilio, int nroDormitorio, Propietario propietario) {
		super(domicilio, propietario);
		this.nroDormitorio = nroDormitorio;		
	}

	@Override
	public double valorAlquiler() {
		// TODO Auto-generated method stub
		return getAlquiler().getPrecio();
	}
	
	
	
}
