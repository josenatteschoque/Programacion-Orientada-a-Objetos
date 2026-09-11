package test;
import static org.junit.Assert.assertNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import colectivo.Colectivo;
import colectivo.Empresa;
import colectivo.Localidad;
import colectivo.Pasaje;
import colectivo.Recorrido;
import colectivo.Viaje;
import colectivo.Tramo;

public class TestColectivo {
	private Localidad pmy;
	private Localidad tre;
	private Localidad sao;
	private Localidad bas;
	private Localidad sgr;
	
	private Recorrido r1;
	private Recorrido r2;

	private Empresa e1;
	private Tramo t1;
	private Viaje v1;
	
	private Colectivo c1;
	
	@BeforeEach
	void carga() {
		pmy = new Localidad("123", "pmy");
		tre = new Localidad("321", "tre");
		sao = new Localidad("456","sao");
		bas = new Localidad("654","bas");
		sgr = new Localidad("789","sgr");
		
		r1 = new Recorrido(1);
		r2 = new Recorrido(2);

		e1 = new Empresa("Ceferino","12345");
		t1 = new Tramo(10110.00, sao ,pmy);
		
		//Creo una fecha
		LocalDate fecha1 = LocalDate.of(2023, 9, 21);
		LocalDate fecha2 = LocalDate.of(2023, 9, 22);

		c1 = new Colectivo("jdk1", 30);
		
		v1 = new Viaje(fecha1,c1,r1);
		
		
		r1.agregarLocalidad(sao);
		r1.agregarLocalidad(sgr);
		r1.agregarLocalidad(pmy);
		r1.agregarLocalidad(tre);
		
		r2.agregarLocalidad(bas);
		
		e1.getTramos().add(t1);
		
		e1.getViajes().add(v1);
	}
	
	/**
	 * r1.tramos(pmy, pmy) = {}
	 * 
	 * r1.tramos(tre, pmy) = {}
	 * 
	 * r2.tramos(bas, pmy) = {}
	 * 
	 * r1.tramos(sao, tre) = {sao, sgr, pmy}
	 */
	//List.of() arma una lista con elementos 
	@Test
	void testRecorrido() {
		assertEquals(List.of(), r1.tramos(pmy, pmy));
		assertEquals(List.of(), r1.tramos(tre, pmy));
		assertEquals(List.of(), r2.tramos(bas, pmy));
		assertEquals(List.of(sao, sgr, pmy), r1.tramos(sao, tre));
	}
	
	/**
	 * tramoPasaje(azu, pmy).getPrecio() = 10110.00
	 * 
	 * tramoPasaje(pmy, azu) = null
	 */
	@Test
	void testTramoPasaje() {
		assertEquals(10110.00, e1.tramoPasaje(sao, pmy).getPrecio() );
		assertNull(e1.tramoPasaje(pmy, sao));
	}

	/**
	 * viaje(21/09/2023, pmy, tre) = null
	 * 
	 * viaje(22/09/2023, bas, pmy) = {}
	 * 
	 * viaje(21/09/2023, bas, pmy) = {v1}
	 * 
	 * viaje(21/09/2023, bas, tre) = {v1, v2}
	 */
	@Test
	void testViaje() {
		
	}

}
