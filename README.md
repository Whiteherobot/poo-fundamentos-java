# POO Fundamentos

[![CI](https://github.com/Whiteherobot/poo-Unidad01-ZLMI/actions/workflows/ci.yml/badge.svg)](https://github.com/Whiteherobot/poo-Unidad01-ZLMI/actions/workflows/ci.yml)
![Java](https://img.shields.io/badge/Java-17%2B-orange)
![Maven](https://img.shields.io/badge/build-Maven-blue)
![Licencia](https://img.shields.io/badge/licencia-MIT-green)

Fundamentos de Programación Orientada a Objetos en Java, con cuatro clases de
dominio (`Computadora`, `Estudiante`, `Gato` y `Moto`), validación de datos, un
catálogo genérico y pruebas unitarias.

## Conceptos que muestra

| Concepto | Dónde |
|---|---|
| Encapsulamiento (atributos privados, getters, listas de solo lectura) | `modelo/*` |
| Validación en el constructor e invariantes | `modelo/Validaciones.java` |
| Interfaces y polimorfismo | `Describible`, que todas las clases implementan |
| Identidad de objetos con `equals` y `hashCode` | `Moto`: la placa identifica la moto |
| Genéricos con límite superior (`<T extends Describible>`) | `catalogo/Catalogo.java` |
| Lambdas, `Predicate`, `Comparator` y `Optional` | `Catalogo.filtrar`, `ordenadosPor` y `buscarPrimero` |
| Pruebas unitarias y parametrizadas (JUnit 5) | `src/test/java` |

## Estructura

```
src/main/java/com/michicorp/poo/
├── App.java              # Demo por consola
├── catalogo/
│   └── Catalogo.java     # Colección genérica: agregar, filtrar, ordenar, reportar
└── modelo/
    ├── Describible.java  # Interfaz común
    ├── Validaciones.java # Reglas de validación compartidas
    ├── Computadora.java  # Descuentos y ampliación de almacenamiento
    ├── Estudiante.java   # Calificación sobre 10 y aprobación
    ├── Gato.java         # Edad equivalente en años humanos
    └── Moto.java         # Antigüedad, motos clásicas e identidad por placa
```

## Cómo usarlo

Requisito: JDK 17 o superior. Maven no hace falta porque el proyecto incluye el wrapper.

```bash
./mvnw verify                                # compila y corre las pruebas
java -jar target/poo-fundamentos-1.0.0.jar   # ejecuta la demo
```

En Windows se usa `mvnw.cmd` en lugar de `./mvnw`.

Salida de la demo (extracto):

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

## Historia

El proyecto empezó en marzo de 2022 como la primera tarea de POO (Unidad 1): un
"Hola mundo" y cuatro clases con atributos públicos. En 2026 se refactorizó con
encapsulamiento, validación, comportamiento propio en cada clase, un catálogo
genérico, pruebas automatizadas e integración continua. El historial de commits
conserva las dos etapas.

## Autor

**Michael Lata** · [GitHub](https://github.com/Whiteherobot)

Distribuido bajo la licencia MIT. Ver [LICENSE](LICENSE).
