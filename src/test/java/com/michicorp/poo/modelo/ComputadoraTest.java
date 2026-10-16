package com.michicorp.poo.modelo;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class ComputadoraTest {

    private Computadora nueva() {
        return new Computadora("ASUS", List.of("Ryzen 7"), 1000, 512);
    }

    @Test
    void aplicaDescuentoPorcentual() {
        Computadora pc = nueva();
        assertEquals(850, pc.aplicarDescuento(15), 0.001);
        assertEquals(850, pc.getPrecio(), 0.001);
    }

    @Test
    void rechazaDescuentoFueraDeRango() {
        Computadora pc = nueva();
        assertThrows(IllegalArgumentException.class, () -> pc.aplicarDescuento(120));
        assertThrows(IllegalArgumentException.class, () -> pc.aplicarDescuento(-1));
    }

    @Test
    void ampliaAlmacenamiento() {
        Computadora pc = nueva();
        pc.ampliarAlmacenamiento(1024);
        assertEquals(1536, pc.getAlmacenamientoGb());
    }

    @Test
    void componentesNoSeModificanDesdeAfuera() {
        Computadora pc = nueva();
        assertThrows(UnsupportedOperationException.class, () -> pc.getComponentes().add("Hack"));
        pc.agregarComponente("SSD 1 TB");
        assertEquals(List.of("Ryzen 7", "SSD 1 TB"), pc.getComponentes());
    }

    @Test
    void validaDatosDelConstructor() {
        assertThrows(IllegalArgumentException.class, () -> new Computadora(" ", List.of(), 100, 1));
        assertThrows(IllegalArgumentException.class, () -> new Computadora("HP", List.of(), 0, 1));
        assertThrows(NullPointerException.class, () -> new Computadora("HP", null, 100, 1));
    }
}
