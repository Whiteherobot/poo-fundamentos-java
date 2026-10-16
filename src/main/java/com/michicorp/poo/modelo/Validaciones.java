package com.michicorp.poo.modelo;

/**
 * Reglas de validación compartidas por las clases del modelo.
 * Cada método devuelve el valor recibido para poder usarse en una asignación.
 */
final class Validaciones {

    private Validaciones() {
    }

    static String texto(String valor, String campo) {
        if (valor == null || valor.isBlank()) {
            throw new IllegalArgumentException(campo + " no puede estar vacío");
        }
        return valor.strip();
    }

    static double noNegativo(double valor, String campo) {
        if (valor < 0 || Double.isNaN(valor)) {
            throw new IllegalArgumentException(campo + " no puede ser negativo");
        }
        return valor;
    }

    static double positivo(double valor, String campo) {
        if (valor <= 0 || Double.isNaN(valor)) {
            throw new IllegalArgumentException(campo + " debe ser mayor que cero");
        }
        return valor;
    }

    static double rango(double valor, double min, double max, String campo) {
        if (valor < min || valor > max || Double.isNaN(valor)) {
            throw new IllegalArgumentException(campo + " debe estar entre " + min + " y " + max);
        }
        return valor;
    }
}
