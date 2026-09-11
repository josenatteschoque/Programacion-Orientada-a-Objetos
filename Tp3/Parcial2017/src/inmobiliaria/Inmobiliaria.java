package inmobiliaria;

import java.util.ArrayList;
import java.util.List;

public class Inmobiliaria {

	private String nombre;
	private List<Inmueble> inmuebles;
	private List<Propietario> propietarios;
	private static double COMISION1 = 0.07;
	private static double COMISION2 = 0.05;
	private static int INMUEBLES = 3;

	public Inmobiliaria(String nombre) {
		this.nombre = nombre;
		inmuebles = new ArrayList<Inmueble>();
		propietarios = new ArrayList<Propietario>();
	}

	public Propietario agregarPropietario(String nombre, String dni) {
		Propietario propietario = new Propietario(nombre, dni);
		propietarios.add(propietario);
		return propietario;
	}

	public Inmueble agregarLocal(String domicilio, int superficie,
			Propietario propietario) throws PropietarioNoExisteException {
		if (!existePropietario(propietario))
			throw new PropietarioNoExisteException();
		Inmueble inmueble = new Local(domicilio, superficie, propietario);
		inmuebles.add(inmueble);
		return inmueble;
	}

	public Inmueble agregarVivienda(String domicilio, int dormitorio,
			Propietario propietario) throws PropietarioNoExisteException {
		if (!existePropietario(propietario))
			throw new PropietarioNoExisteException();
		Inmueble inmueble = new Vivienda(domicilio, dormitorio, propietario);
		inmuebles.add(inmueble);
		return inmueble;
	}

	private boolean existePropietario(Propietario propietario) {
		for (Propietario p : propietarios)
			if (p.equals(propietario))
				return true;
		return false;
	}

	public double pagoPropietario(Propietario propietario) {
		double pago = 0;
		int cant = 0;
		for (Inmueble i : inmuebles)
			if (i.getPropietario().equals(propietario)
					&& i.getAlquiler() != null) {
				pago += i.valorAlquiler();
				cant++;
			}
		if (cant > INMUEBLES)
			return pago - pago * COMISION2;

		return pago - pago * COMISION1;
	}
}
