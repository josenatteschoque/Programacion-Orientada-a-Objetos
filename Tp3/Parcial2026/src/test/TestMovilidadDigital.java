package test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDateTime;
import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import md.Auto;
import md.Conductor;
import md.Moto;

class TestMovilidadDigital {

    private Auto auto1;
    private Auto auto2;
    private Moto moto1;
    
    private Conductor conductor1;
    private Conductor conductor2;
    private Conductor conductor3;

    @BeforeEach
    void setUp() {
        auto1 = new Auto("AAA111", "Cronos");
        auto2 = new Auto("BBB222", "Corolla");
        moto1 = new Moto("CCC333", "Honda Wave");

        conductor1 = new Conductor("Carlos", "20-11111111-2");
        conductor2 = new Conductor("Ana", "27-22222222-7");
        conductor3 = new Conductor("Juan", "23-33333333-9");

        LocalDateTime ahora = LocalDateTime.now();

        conductor1.agregarViaje(auto1, ahora, 10);
        conductor1.agregarViaje(auto1, ahora, 20);
        conductor1.agregarViaje(auto1, ahora, 30);

        conductor2.agregarViaje(auto2, ahora, 5);
        conductor2.agregarViaje(auto2, ahora, 15);
        conductor2.agregarViaje(auto2, ahora, 25);

        conductor3.agregarViaje(moto1, ahora, 8);
        conductor3.agregarViaje(moto1, ahora, 12);
        conductor3.agregarViaje(moto1, ahora, 15);
    }

    @Test
    void testCalcularCostoViaje() {
        assertEquals(7000.0, auto1.calcularCostoViaje(10), "El costo del auto para 10km es incorrecto.");

        assertEquals(14500.0, auto2.calcularCostoViaje(25), "El costo del auto para 25km es incorrecto.");

        assertEquals(3000.0, moto1.calcularCostoViaje(15), "El costo de la moto para 15km es incorrecto.");
    }

    @Test
    void testCalcularSueldo() {
        assertEquals(25200.0, conductor1.calcularSueldo(), "El sueldo del conductor 1 es incorrecto.");

        assertEquals(19950.0, conductor2.calcularSueldo(), "El sueldo de la conductora Ana es incorrecto.");

        assertEquals(4900.0, conductor3.calcularSueldo(), "El sueldo del conductor 3 es incorrecto.");
    }
}