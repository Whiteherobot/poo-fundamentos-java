package com.michicorp.poo.catalogo;

import com.michicorp.poo.modelo.Describible;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.function.Predicate;

/**
 * Colección en memoria para cualquier tipo del modelo.
 *
 * @param <T> tipo de elemento, que debe saber describirse
 */
public class Catalogo<T extends Describible> {

    private final String nombre;
    private final List<T> elementos = new ArrayList<>();

    public Catalogo(String nombre) {
        this.nombre = Objects.requireNonNull(nombre, "El nombre no puede ser nulo");
    }

    /** Agrega el elemento si no existe uno igual; devuelve si se agregó. */
    public boolean agregar(T elemento) {
        Objects.requireNonNull(elemento, "El elemento no puede ser nulo");
        if (elementos.contains(elemento)) {
            return false;
        }
        return elementos.add(elemento);
    }

    public boolean eliminar(T elemento) {
        return elementos.remove(elemento);
    }

    public List<T> filtrar(Predicate<? super T> condicion) {
        return elementos.stream().filter(condicion).toList();
    }

    public Optional<T> buscarPrimero(Predicate<? super T> condicion) {
        return elementos.stream().filter(condicion).findFirst();
    }

    public List<T> ordenadosPor(Comparator<? super T> criterio) {
        return elementos.stream().sorted(criterio).toList();
    }

    public List<T> todos() {
        return Collections.unmodifiableList(elementos);
    }

    public int tamanio() {
        return elementos.size();
    }

    public boolean estaVacio() {
        return elementos.isEmpty();
    }

    public String getNombre() {
        return nombre;
    }

    /** Listado numerado, listo para imprimir. */
    public String reporte() {
        StringBuilder sb = new StringBuilder(nombre).append(" (").append(tamanio()).append(")\n");
        for (int i = 0; i < elementos.size(); i++) {
            sb.append(String.format("  %d. %s%n", i + 1, elementos.get(i).descripcion()));
        }
        return sb.toString();
    }
}
