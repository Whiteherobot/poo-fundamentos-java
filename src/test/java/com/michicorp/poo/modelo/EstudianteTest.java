package com.michicorp.poo.modelo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

class EstudianteTest {

    @Test
    void apruebaDesdeLaNotaMinima() {
        assertTrue(new Estudiante("Ana", "Computación", 7.0).estaAprobado());
        assertFalse(new Estudiante("Luis", "Computación", 6.99).estaAprobado());
    }

    @Test
    void actualizaCalificacion() {
        Estudiante e = new Estudiante("Ana", "Computación", 5);
        e.actualizarCalificacion(8.5);
        assertEquals(8.5, e.getCalificacion());
        assertTrue(e.estaAprobado());
    }

    @Test
    void rechazaCalificacionFueraDeEscala() {
        assertThrows(IllegalArgumentException.class, () -> new Estudiante("Ana", "Computación", 11));
        Estudiante e = new Estudiante("Ana", "Computación", 8);
        assertThrows(IllegalArgumentException.class, () -> e.actualizarCalificacion(-0.5));
    }

    @Test
    void recortaEspaciosDelNombre() {
        assertEquals("Ana", new Estudiante("  Ana ", "Computación", 8).getNombre());
    }
}
