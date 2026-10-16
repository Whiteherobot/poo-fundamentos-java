package com.michicorp.poo.catalogo;

import com.michicorp.poo.modelo.Estudiante;
import com.michicorp.poo.modelo.Moto;
import org.junit.jupiter.api.Test;

import java.util.Comparator;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

class CatalogoTest {

    private Catalogo<Estudiante> conTresEstudiantes() {
        Catalogo<Estudiante> c = new Catalogo<>("Curso");
        c.agregar(new Estudiante("Ana", "Computación", 9));
        c.agregar(new Estudiante("Luis", "Computación", 5));
        c.agregar(new Estudiante("María", "Electrónica", 7.5));
        return c;
    }

    @Test
    void filtraYOrdena() {
        Catalogo<Estudiante> c = conTresEstudiantes();
        assertEquals(2, c.filtrar(Estudiante::estaAprobado).size());
        List<String> porNota = c.ordenadosPor(Comparator.comparingDouble(Estudiante::getCalificacion))
                .stream().map(Estudiante::getNombre).toList();
        assertEquals(List.of("Luis", "María", "Ana"), porNota);
    }

    @Test
    void buscaElPrimeroQueCumple() {
        Catalogo<Estudiante> c = conTresEstudiantes();
        assertEquals("María", c.buscarPrimero(e -> e.getCarrera().equals("Electrónica")).orElseThrow().getNombre());
        assertTrue(c.buscarPrimero(e -> e.getCalificacion() == 10).isEmpty());
    }

    @Test
    void noAceptaDuplicados() {
        Catalogo<Moto> motos = new Catalogo<>("Motos");
        assertTrue(motos.agregar(new Moto("IB123A", "Honda", "CB190R", 2022, 2800)));
        assertFalse(motos.agregar(new Moto("ib123a", "Honda", "CB190R", 2022, 2800)));
        assertEquals(1, motos.tamanio());
    }

    @Test
    void eliminaYExponeListaDeSoloLectura() {
        Catalogo<Estudiante> c = conTresEstudiantes();
        Estudiante ana = c.todos().get(0);
        assertTrue(c.eliminar(ana));
        assertEquals(2, c.tamanio());
        assertThrows(UnsupportedOperationException.class, () -> c.todos().clear());
    }

    @Test
    void generaReporteNumerado() {
        Catalogo<Estudiante> c = conTresEstudiantes();
        String reporte = c.reporte();
        assertTrue(reporte.startsWith("Curso (3)"));
        assertTrue(reporte.contains("1. Ana"));
    }
}
