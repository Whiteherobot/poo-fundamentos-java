package com.michicorp.poo.modelo;

/**
 * Gato con nombre, raza, edad y peso.
 */
public class Gato implements Describible {

    private final String nombre;
    private final String raza;
    private int edad;
    private double pesoKg;

    public Gato(String nombre, String raza, int edad, double pesoKg) {
        this.nombre = Validaciones.texto(nombre, "El nombre");
        this.raza = Validaciones.texto(raza, "La raza");
        this.edad = (int) Validaciones.noNegativo(edad, "La edad");
        this.pesoKg = Validaciones.positivo(pesoKg, "El peso");
    }

    /**
     * Edad equivalente en años humanos según la regla veterinaria habitual:
     * el primer año vale 15, el segundo 9 y cada año siguiente 4.
     */
    public int edadHumana() {
        if (edad == 0) {
            return 0;
        }
        if (edad == 1) {
            return 15;
        }
        return 24 + (edad - 2) * 4;
    }

    public void cumplirAnios() {
        edad++;
    }

    public void registrarPeso(double nuevoPesoKg) {
        pesoKg = Validaciones.positivo(nuevoPesoKg, "El peso");
    }

    public String getNombre() {
        return nombre;
    }

    public String getRaza() {
        return raza;
    }

    public int getEdad() {
        return edad;
    }

    public double getPesoKg() {
        return pesoKg;
    }

    @Override
    public String descripcion() {
        return String.format("%s (%s) · %d %s (≈ %d humanos) · %.1f kg",
                nombre, raza, edad, edad == 1 ? "año" : "años", edadHumana(), pesoKg);
    }

    @Override
    public String toString() {
        return "Gato[" + descripcion() + "]";
    }
}
