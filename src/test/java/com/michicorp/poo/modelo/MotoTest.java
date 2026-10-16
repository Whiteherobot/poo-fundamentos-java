package com.michicorp.poo.modelo;

import org.junit.jupiter.api.Test;

import java.time.Year;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

class MotoTest {

    @Test
    void calculaAntiguedadRespectoAUnAnio() {
        Moto m = new Moto("IB123A", "Honda", "CB190R", 2020, 2800);
        assertEquals(6, m.antiguedad(Year.of(2026)));
        assertEquals(0, m.antiguedad(Year.of(2019)));
    }

    @Test
    void detectaMotosClasicas() {
        assertTrue(new Moto("AA001B", "Yamaha", "RX 100", 1990, 1900).esClasica());
        assertFalse(new Moto("IB123A", "Honda", "CB190R", Year.now().getValue(), 2800).esClasica());
    }

    @Test
    void laPlacaDefineLaIdentidad() {
        Moto a = new Moto("ib123a", "Honda", "CB190R", 2022, 2800);
        Moto b = new Moto("IB123A", "Suzuki", "GN125", 2018, 1500);
        Moto c = new Moto("XY999Z", "Honda", "CB190R", 2022, 2800);
        assertEquals(a, b);
        assertEquals(a.hashCode(), b.hashCode());
        assertNotEquals(a, c);
    }

    @Test
    void rechazaAnioImposible() {
        assertThrows(IllegalArgumentException.class, () -> new Moto("IB123A", "Honda", "CB", 1800, 100));
        int futuro = Year.now().getValue() + 5;
        assertThrows(IllegalArgumentException.class, () -> new Moto("IB123A", "Honda", "CB", futuro, 100));
    }
}
