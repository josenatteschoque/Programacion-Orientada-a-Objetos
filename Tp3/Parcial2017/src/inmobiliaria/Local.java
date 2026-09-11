package inmobiliaria;

public class Local extends Inmueble {

	private double superficie;
	private static double IVA = 0.21;

	public Local(String domicilio, double superficie, Propietario propietario) {
		super(domicilio, propietario);
		this.superficie = superficie;
	}

	@Override
	public double valorAlquiler() {
		// TODO Auto-generated method stub
		return getAlquiler().getPrecio() + getAlquiler().getPrecio() * IVA;
	}

}
