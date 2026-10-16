package com.michicorp.poo.modelo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

/**
 * Computadora con sus componentes, precio y almacenamiento.
 */
public class Computadora implements Describible {

    private final String marca;
    private final List<String> componentes;
    private double precio;
    private int almacenamientoGb;

    public Computadora(String marca, List<String> componentes, double precio, int almacenamientoGb) {
        this.marca = Validaciones.texto(marca, "La marca");
        this.componentes = new ArrayList<>(Objects.requireNonNull(componentes, "Los componentes no pueden ser nulos"));
        this.precio = Validaciones.positivo(precio, "El precio");
        this.almacenamientoGb = (int) Validaciones.positivo(almacenamientoGb, "El almacenamiento");
    }

    /** Agrega un componente, por ejemplo "SSD 1 TB" o "RTX 4060". */
    public void agregarComponente(String componente) {
        componentes.add(Validaciones.texto(componente, "El componente"));
    }

    /** Aplica un descuento porcentual (0–100) y devuelve el precio resultante. */
    public double aplicarDescuento(double porcentaje) {
        Validaciones.rango(porcentaje, 0, 100, "El descuento");
        precio = precio * (1 - porcentaje / 100);
        return precio;
    }

    /** Suma almacenamiento, por ejemplo al instalar un disco adicional. */
    public void ampliarAlmacenamiento(int gb) {
        almacenamientoGb += (int) Validaciones.positivo(gb, "La ampliación");
    }

    public String getMarca() {
        return marca;
    }

    public List<String> getComponentes() {
        return Collections.unmodifiableList(componentes);
    }

    public double getPrecio() {
        return precio;
    }

    public int getAlmacenamientoGb() {
        return almacenamientoGb;
    }

    @Override
    public String descripcion() {
        return String.format("%s · %d GB · $%,.2f · %s", marca, almacenamientoGb, precio,
                componentes.isEmpty() ? "sin componentes" : String.join(", ", componentes));
    }

    @Override
    public String toString() {
        return "Computadora[" + descripcion() + "]";
    }
}
