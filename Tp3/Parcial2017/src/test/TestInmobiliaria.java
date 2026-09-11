package test;

import static org.junit.Assert.assertEquals;

import java.util.Date;

import org.junit.Before;
import org.junit.Test;

import inmobiliaria.Inmobiliaria;
import inmobiliaria.Inmueble;
import inmobiliaria.InmuebleNoDisponibleException;
import inmobiliaria.Propietario;
import inmobiliaria.PropietarioNoExisteException;

public class TestInmobiliaria {

	private Inmobiliaria inmobiliaria;
	private Propietario p1, p2, p3;
	private Inmueble v1, v2, l1, l2, v3;
	
	@Before
	public void inicio() throws Exception{
		inmobiliaria = new Inmobiliaria("Prueba");
		p1 = inmobiliaria.agregarPropietario("Juan", "11111111");
		p2 = inmobiliaria.agregarPropietario("Ana", "22222222");
		v1 = inmobiliaria.agregarVivienda("Roca 202", 3 , p1);
		l1 = inmobiliaria.agregarLocal("Villarino 303", 1 , p1);
		v2 = inmobiliaria.agregarVivienda("Gales 101", 1 , p2);
		l2 = inmobiliaria.agregarLocal("Rawson 303", 1 , p2);
		l1.alquilar(9000, new Date(), new Date(), "Pedro", "33333333");
		v1.alquilar(5000, new Date(), new Date(), "Julio", "44444444");
	}
	
	@Test
	public void testPagoPropietario() {
		System.out.println(inmobiliaria.pagoPropietario(p1));
		assertEquals(inmobiliaria.pagoPropietario(p1),14777.7,0.001);
	}

	@Test(expected = PropietarioNoExisteException.class)
	public void testPropietarioNoExiste() throws PropietarioNoExisteException {
		//p3 = inmobiliaria.agregarPropietario("Omar", "6666666");
		p3 = new Propietario("Omar", "6666666");
		v3 = inmobiliaria.agregarVivienda("Gales 101", 1 , p3);
	}

	@Test(expected = InmuebleNoDisponibleException.class)
	public void testInmuebleNoDisponible() throws Exception {
		v1.alquilar(5000, new Date(), new Date(), "Julio", "44444444");
	}

}
