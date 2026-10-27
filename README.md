# Pattern Designs

Java exercises for practising software design patterns. Each pattern has its own package under `src/`, with one sub-package per exercise. Class and method names are in Spanish to match the exercise statements.

## Patterns

### Observer — `observer`

A subject keeps a list of observers and notifies them automatically when its state changes. The subject only knows the observer interface, so new observers can be added without modifying it.

#### Exercise 1 — Temperature alerts (`observer.ejercicio1`)

A thermometer notifies every interested device whenever the room temperature changes.

| Class | Role |
| --- | --- |
| `Observador` | Observer interface: `actualizar(double temperatura)` |
| `Termometro` | Subject: `suscribir()`, `desuscribir()`, `setTemperatura()` notifies all observers |
| `Pantalla` | Prints the current temperature |
| `Alarma` | Prints an alert when the temperature goes above 30 ºC |
| `Main` | Subscribes a `Pantalla` and an `Alarma`, then sets 25 ºC and 35 ºC |

#### Exercise 2 — Video game scores (`observer.ejercicio2`)

A player earns points during a match, and game components receive each new score automatically.

| Class | Role |
| --- | --- |
| `ObservadorPuntuacion` | Observer interface: `actualizar(String jugador, int puntuacion)` |
| `Jugador` | Subject: earns 100 points per mission (`completarMision()`), 50 per enemy (`derrotarEnemigo()`) and 10 per object (`recogerObjeto()`) |
| `Marcador` | Scoreboard: prints the player's current score |
| `Estadisticas` | Appends `timestamp;jugador;puntuacion` to `estadisticas.txt` |
| `Main` | Two players share one `Marcador` and one `Estadisticas` |

## Project structure

```text
src/
├── App.java                 Default VS Code entry point (Hello World)
└── observer/
    ├── ejercicio1/          Temperature alerts
    └── ejercicio2/          Video game scores
```

Compiled classes go to `bin/`, which is git-ignored.

## Running the exercises

You need a JDK (developed with JDK 25).

**VS Code:** with the Extension Pack for Java installed, open the exercise's `Main.java` and click **Run**.

**Command line**, from the project root:

```bash
javac -encoding UTF-8 -d bin src/observer/ejercicio1/*.java src/observer/ejercicio2/*.java
java -cp bin observer.ejercicio1.Main
java -cp bin observer.ejercicio2.Main
```

Exercise 2 writes `estadisticas.txt` to the current working directory, appending to it on every run.

## Adding exercises

- **New exercise for an existing pattern:** add a sub-package, e.g. `src/observer/ejercicio3/`.
- **New pattern:** add a package named after it, e.g. `src/singleton/ejercicio1/`.

Each exercise is self-contained and has its own `Main` class.
