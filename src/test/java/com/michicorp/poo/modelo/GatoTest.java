package com.michicorp.poo.modelo;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class GatoTest {

    @ParameterizedTest
    @CsvSource({"0, 0", "1, 15", "2, 24", "3, 28", "10, 56"})
    void calculaEdadHumana(int edad, int esperada) {
        assertEquals(esperada, new Gato("Michi", "Mestizo", edad, 4).edadHumana());
    }

    @Test
    void cumpleAnios() {
        Gato g = new Gato("Luna", "Siamés", 1, 3.2);
        g.cumplirAnios();
        assertEquals(2, g.getEdad());
    }

    @Test
    void validaEdadYPeso() {
        assertThrows(IllegalArgumentException.class, () -> new Gato("Luna", "Siamés", -1, 3));
        Gato g = new Gato("Luna", "Siamés", 1, 3);
        assertThrows(IllegalArgumentException.class, () -> g.registrarPeso(0));
    }
}
