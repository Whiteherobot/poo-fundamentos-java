package com.michicorp.poo.modelo;

import java.time.Year;
import java.util.Locale;
import java.util.Objects;

/**
 * Moto identificada por su placa. Dos motos con la misma placa son la misma moto.
 */
public class Moto implements Describible {

    /** Antigüedad a partir de la cual una moto se considera clásica. */
    public static final int ANIOS_CLASICA = 25;

    private final String placa;
    private final String marca;
    private final String modelo;
    private final int anio;
    private double precio;

    public Moto(String placa, String marca, String modelo, int anio, double precio) {
        this.placa = Validaciones.texto(placa, "La placa").toUpperCase(Locale.ROOT);
        this.marca = Validaciones.texto(marca, "La marca");
        this.modelo = Validaciones.texto(modelo, "El modelo");
        this.anio = (int) Validaciones.rango(anio, 1885, Year.now().getValue() + 1, "El año");
        this.precio = Validaciones.positivo(precio, "El precio");
    }

    public int antiguedad(Year referencia) {
        return Math.max(0, referencia.getValue() - anio);
    }

    public int antiguedad() {
        return antiguedad(Year.now());
    }

    public boolean esClasica() {
        return antiguedad() >= ANIOS_CLASICA;
    }

    public void actualizarPrecio(double nuevoPrecio) {
        precio = Validaciones.positivo(nuevoPrecio, "El precio");
    }

    public String getPlaca() {
        return placa;
    }

    public String getMarca() {
        return marca;
    }

    public String getModelo() {
        return modelo;
    }

    public int getAnio() {
        return anio;
    }

    public double getPrecio() {
        return precio;
    }

    @Override
    public String descripcion() {
        return String.format("%s %s %d · placa %s · $%,.2f%s", marca, modelo, anio, placa, precio,
                esClasica() ? " · clásica" : "");
    }

    @Override
    public boolean equals(Object o) {
        return this == o || (o instanceof Moto otra && placa.equals(otra.placa));
    }

    @Override
    public int hashCode() {
        return Objects.hash(placa);
    }

    @Override
    public String toString() {
        return "Moto[" + descripcion() + "]";
    }
}
