package com.michicorp.poo.modelo;

/**
 * Estudiante con una calificación sobre 10.
 */
public class Estudiante implements Describible {

    /** Nota mínima para aprobar en la escala de 0 a 10. */
    public static final double NOTA_MINIMA_APROBACION = 7.0;

    private final String nombre;
    private final String carrera;
    private double calificacion;

    public Estudiante(String nombre, String carrera, double calificacion) {
        this.nombre = Validaciones.texto(nombre, "El nombre");
        this.carrera = Validaciones.texto(carrera, "La carrera");
        this.calificacion = Validaciones.rango(calificacion, 0, 10, "La calificación");
    }

    public boolean estaAprobado() {
        return calificacion >= NOTA_MINIMA_APROBACION;
    }

    public void actualizarCalificacion(double nueva) {
        calificacion = Validaciones.rango(nueva, 0, 10, "La calificación");
    }

    public String getNombre() {
        return nombre;
    }

    public String getCarrera() {
        return carrera;
    }

    public double getCalificacion() {
        return calificacion;
    }

    @Override
    public String descripcion() {
        return String.format("%s (%s) · %.1f/10 · %s", nombre, carrera, calificacion,
                estaAprobado() ? "aprobado" : "reprobado");
    }

    @Override
    public String toString() {
        return "Estudiante[" + descripcion() + "]";
    }
}
