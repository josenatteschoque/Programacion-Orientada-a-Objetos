package inmobiliarias;

import java.util.Objects;

public class Campo extends Inmueble{
	private String ciudad;
	private double distancia;
	
	public Campo(String domicilio, double superficie, int cantidadAmbientes, int precio, String ciudad,
			double distancia) {
		super(domicilio, superficie, cantidadAmbientes, precio);
		this.ciudad = ciudad;
		this.distancia = distancia;
	}

	public String getCiudad() {
		return ciudad;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

	public double getDistancia() {
		return distancia;
	}

	public void setDistancia(double distancia) {
		this.distancia = distancia;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(ciudad, distancia);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Campo other = (Campo) obj;
		return Objects.equals(ciudad, other.ciudad)
				&& Double.doubleToLongBits(distancia) == Double.doubleToLongBits(other.distancia);
	}

	@Override
	public String toString() {
		return "Campo [ciudad=" + ciudad + ", distancia=" + distancia + "]";
	}

	@Override
	public double comisionVendedor() {
		if(this.getDistancia() < 100) {
			return 0.10 * this.getPrecio(); 
		}else {
			return 0.05 * this.getPrecio();
		}
	}

}
