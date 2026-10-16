package com.michicorp.poo;

import com.michicorp.poo.catalogo.Catalogo;
import com.michicorp.poo.modelo.Computadora;
import com.michicorp.poo.modelo.Estudiante;
import com.michicorp.poo.modelo.Gato;
import com.michicorp.poo.modelo.Moto;

import java.util.Comparator;
import java.util.List;

/**
 * Demostración por consola: crea objetos, los opera y los agrupa en catálogos.
 */
public class App {

    public static void main(String[] args) {
        System.out.println("=== POO Fundamentos ===\n");

        Catalogo<Computadora> computadoras = new Catalogo<>("Computadoras");
        Computadora gamer = new Computadora("ASUS", List.of("Ryzen 7", "RTX 4060", "16 GB RAM"), 1450, 512);
        gamer.ampliarAlmacenamiento(1024);
        gamer.aplicarDescuento(10);
        computadoras.agregar(gamer);
        computadoras.agregar(new Computadora("Lenovo", List.of("Core i5", "8 GB RAM"), 680, 256));
        System.out.println(computadoras.reporte());

        Catalogo<Estudiante> estudiantes = new Catalogo<>("Estudiantes");
        estudiantes.agregar(new Estudiante("Ana Torres", "Computación", 9.2));
        estudiantes.agregar(new Estudiante("Luis Pérez", "Computación", 6.4));
        estudiantes.agregar(new Estudiante("María Vega", "Electrónica", 7.8));
        System.out.println(estudiantes.reporte());
        System.out.printf("Aprobados: %d de %d%n%n",
                estudiantes.filtrar(Estudiante::estaAprobado).size(), estudiantes.tamanio());

        Catalogo<Gato> gatos = new Catalogo<>("Gatos");
        gatos.agregar(new Gato("Michi", "Mestizo", 3, 4.5));
        gatos.agregar(new Gato("Luna", "Siamés", 1, 3.2));
        System.out.println(gatos.reporte());

        Catalogo<Moto> motos = new Catalogo<>("Motos");
        motos.agregar(new Moto("IB123A", "Honda", "CB190R", 2022, 2800));
        motos.agregar(new Moto("AA001B", "Yamaha", "RX 100", 1995, 1900));
        boolean duplicada = motos.agregar(new Moto("ib123a", "Honda", "CB190R", 2022, 2800));
        System.out.println(motos.reporte());
        System.out.println("¿Se aceptó la placa repetida? " + (duplicada ? "sí" : "no"));
        motos.ordenadosPor(Comparator.comparingDouble(Moto::getPrecio)).stream()
                .findFirst()
                .ifPresent(m -> System.out.println("Moto más económica: " + m.descripcion()));
    }
}
