package md;

public class Auto extends Vehiculo{
	private static double tarifaBase = 2000;
	private static double precioPorKm = 500;

	public Auto(String patente, String modelo) {
		super(patente, modelo);
	}
	
	public static double getTarifaBase() {
		return tarifaBase;
	}

	public static void setTarifaBase(double tarifaBase) {
		Auto.tarifaBase = tarifaBase;
	}

	public static double getPrecioPorKm() {
		return precioPorKm;
	}

	public static void setPrecioPorKm(double precioPorKm) {
		Auto.precioPorKm = precioPorKm;
	}
	
	@Override
	public String toString() {
		return "Auto [getPatente()=" + getPatente() + ", getModelo()=" + getModelo() + ", hashCode()=" + hashCode()
				+ ", toString()=" + super.toString() + ", getClass()=" + getClass() + "]";
	}
	
	/*El costo del viaje para una moto está dado por la distancia a recorrer por el precio por km. */
	@Override
	public double calcularCostoViaje(int distancia) {
		return (distancia * precioPorKm) + tarifaBase;
	}

}
