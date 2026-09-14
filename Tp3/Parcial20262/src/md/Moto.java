package md;

public class Moto extends Vehiculo{
	private static double precioPorKm = 200;
	
	public Moto(String patente, String modelo) {
		super(patente, modelo);
	}
	
	public static double getPrecioPorKm() {
		return precioPorKm;
	}

	public static void setPrecioPorKm(double precioPorKm) {
		Moto.precioPorKm = precioPorKm;
	}

	@Override
	public String toString() {
		return "Moto [getPatente()=" + getPatente() + ", getModelo()=" + getModelo() + ", hashCode()=" + hashCode()
				+ ", toString()=" + super.toString() + ", getClass()=" + getClass() + "]";
	}
	/*El costo del viaje para una moto está dado por la distancia a recorrer por el precio por km. */
	@Override
	public double calcularCostoViaje(int distancia) {
		return distancia * precioPorKm;
	}
	
}
