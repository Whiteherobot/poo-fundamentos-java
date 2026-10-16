# poo-fundamentos-java

[![CI](https://github.com/Whiteherobot/poo-fundamentos-java/actions/workflows/ci.yml/badge.svg)](https://github.com/Whiteherobot/poo-fundamentos-java/actions/workflows/ci.yml)

Mi primer proyecto de Programación Orientada a Objetos en Java. Empezó en marzo
de 2022 como la tarea de la Unidad 1: un "Hola mundo" y cuatro clases con
atributos públicos. En 2026 lo retomé para dejarlo como un ejemplo ordenado de
los fundamentos.

## Qué hay

Cuatro clases de dominio con datos validados y algo de comportamiento:

- `Computadora`: componentes, descuentos y ampliación de almacenamiento.
- `Estudiante`: calificación sobre 10 y si aprobó (desde 7).
- `Gato`: edad equivalente en años humanos.
- `Moto`: antigüedad, si es clásica, e identidad por placa (`equals`/`hashCode`).

Todas implementan la interfaz `Describible`, y `Catalogo<T>` las agrupa para
filtrar, ordenar y armar un reporte. `App` es una demo por consola que usa todo
lo anterior.

```
src/main/java/com/michicorp/poo/
├── App.java
├── catalogo/Catalogo.java
└── modelo/   Computadora, Estudiante, Gato, Moto, Describible, Validaciones
```

## Cómo correrlo

Necesitas JDK 17 o superior. Maven no hace falta porque el proyecto trae el wrapper.

```bash
./mvnw verify                                # compila y corre las pruebas
java -jar target/poo-fundamentos-1.0.0.jar   # demo
```

En Windows se usa `mvnw.cmd`.

Parte de la salida:

```
Estudiantes (3)
  1. Ana Torres (Computación) · 9.2/10 · aprobado
  2. Luis Pérez (Computación) · 6.4/10 · reprobado
  3. María Vega (Electrónica) · 7.8/10 · aprobado

Motos (2)
  1. Honda CB190R 2022 · placa IB123A · $2,800.00
  2. Yamaha RX 100 1995 · placa AA001B · $1,900.00 · clásica

¿Se aceptó la placa repetida? no
```

Las pruebas están en `src/test/java` (JUnit 5) y corren en GitHub Actions con Java 17 y 21.

## Autor

Michael Lata ([@Whiteherobot](https://github.com/Whiteherobot)). Licencia MIT.
