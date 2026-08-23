package pruebas;

import junit.framework.TestCase;
import inmobiliarias.*;

public class PruebaInmobiliariasJUnit extends TestCase {

	private Inmueble membrillar, boyaca, artigas, neuquen, campo;
	private Inmobiliaria sucasa, flores;
	
	protected void setUp( ) throws Exception {
		// creaci�n de objetos de prueba
		campo = new Campo("Los hermanos",500.0, 5, 100000, "Puerto madryn", 100);
		
		membrillar = new Terreno ("Membrillar 255", 85.3, 4, 82000, true);
		boyaca = new Casa ("Boyac� 1244", 144.3, 5, 124300, true, true, false, 253);
		artigas = new Departamento ("Artigas 1366", 95.2, 3, 93700, false, true);
		neuquen = new Departamento ("Neuqu�n 3455", 129.4, 5, 128400, true, true);
		sucasa = new Inmobiliaria ("Su casa", 3, 3);
		flores = new Inmobiliaria ("Flores", 3, 1.5);
		// carga de inmobiliarias
		sucasa.agregarInmueble(campo);
		
		sucasa.agregarInmueble(membrillar);
		sucasa.agregarInmueble(neuquen);
		flores.agregarInmueble(boyaca);
		flores.agregarInmueble(artigas);
}

	public void testComisionVendedor( ) {
		// en terrenos la comisi�n es del 1%
		assertEquals (82000*0.01, membrillar.comisionVendedor( ), 1E-4);
		// en casas con jard�n y sin pileta la comisi�n es del 1%
		assertEquals (124300*0.01, boyaca.comisionVendedor( ), 1E-4);
		// en departamentos sin cochera la comisi�n es del 1,1%
		assertEquals (93700*0.011, artigas.comisionVendedor( ), 1E-4);
		// en departamentos con cochera la comisi�n es del 0,9%
		assertEquals (128400*0.009, neuquen.comisionVendedor( ), 1E-4);
		
		assertEquals(5000, campo.comisionVendedor(), 1E-4);
	}
	
	public void testBeneficioCartera( ) {
		final double beneficiosMembrillar = 82000 * (0.06-0.01);
		final double beneficiosNeuquen = 128400 * (0.06-0.009);
		final double beneficiosCampo = 100000 *0.06 - 5000;
		assertEquals (beneficiosMembrillar + beneficiosNeuquen + beneficiosCampo,
 					sucasa.beneficioEsperadoCartera( ), 1E-4);
		final double beneficiosBoyaca = 124300 * (0.045-0.01);
		final double beneficiosArtigas = 93700 * (0.045-0.011);
		assertEquals (beneficiosBoyaca + beneficiosArtigas,
 					flores.beneficioEsperadoCartera( ), 1E-4);
		// no hae inmuebles reservados:
		assertEquals (0, sucasa.beneficioEsperadoReservados( ), 1E-4);
		assertEquals (0, flores.beneficioEsperadoReservados( ), 1E-4);
		// reservamos dos inmuebles y vemos qu� pasa:
		membrillar.reservar( );
		artigas.reservar( );
		assertEquals (beneficiosMembrillar, sucasa.beneficioEsperadoReservados( ), 1E-4);
		assertEquals (beneficiosArtigas, flores.beneficioEsperadoReservados( ), 1E-4);
	}
}
