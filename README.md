# Pattern Designs

Java exercises for practising software design patterns. Each pattern has its own package under `src/`, with one sub-package per exercise. Class and method names are in Spanish to match the exercise statements.

| Pattern | Exercises | Status |
| --- | --- | --- |
| [Observer](#observer--observer) | 2 | Done |
| [Factory](#factory--factory) | 2 | Done |

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

### Factory — `factory`

A factory class centralises object creation. The client asks for an object by type name and gets back an interface, without knowing which concrete class was created. Supporting a new type only means adding a class and one branch in the factory.

Each Factory exercise is split into a `model` package (interface, concrete classes and factory) and a `main` package (the client).

#### Exercise 1 — Notifications (`factory.ej1`)

An application sends notifications through different channels.

| Class | Role |
| --- | --- |
| `Notificacion` | Product interface: `enviar()` |
| `Email` | Prints `Enviando email` |
| `Sms` | Prints `Enviando SMS` |
| `NotificacionFactory` | `crear(String tipo)` returns an `Email` for `"email"`, an `Sms` for `"sms"`, and `null` for anything else |
| `Main` | Sends an email and an SMS, then shows that `"whatsapp"` is not supported |

#### Exercise 2 — Payment methods (`factory.ej2`)

An online shop processes payments with different methods.

| Class | Role |
| --- | --- |
| `MetodoPago` | Product interface: `realizarPago()` |
| `Tarjeta` | Prints `Pagando con tarjeta` |
| `PayPal` | Prints `Pagando con PayPal` |
| `MetodoPagoFactory` | `crear(String tipo)` returns a `Tarjeta` for `"tarjeta"` and a `PayPal` for `"paypal"`; unknown types throw `IllegalArgumentException` |
| `Main` | Pays by card and by PayPal, then catches the error for `"bizum"` |

Unlike exercise 1, the factory throws an exception instead of returning `null`, so the client cannot forget to handle an unsupported type.

## Project structure

```text
src/
├── observer/
│   ├── ejercicio1/          Temperature alerts
│   └── ejercicio2/          Video game scores
└── factory/
    ├── ej1/                 Notifications
    │   ├── main/
    │   └── model/
    └── ej2/                 Payment methods
        ├── main/
        └── model/
```

Compiled classes go to `bin/`. Both `bin/` and the exercise statements (`*.docx`) are git-ignored.

## Running the exercises

You need a JDK (developed with JDK 25).

**VS Code:** with the Extension Pack for Java installed, open the exercise's `Main.java` and click **Run**. The workspace settings in `.vscode/settings.json` use `src` as the source root and `bin` as the output folder.

**Command line**, from the project root:

```bash
# Observer
javac -encoding UTF-8 -d bin src/observer/ejercicio1/*.java src/observer/ejercicio2/*.java
java -cp bin observer.ejercicio1.Main
java -cp bin observer.ejercicio2.Main

# Factory
javac -encoding UTF-8 -d bin src/factory/ej1/main/*.java src/factory/ej1/model/*.java src/factory/ej2/main/*.java src/factory/ej2/model/*.java
java -cp bin factory.ej1.main.Main
java -cp bin factory.ej2.main.Main
```

Observer exercise 2 writes `estadisticas.txt` to the current working directory, appending to it on every run.

## Adding exercises

- **New exercise for an existing pattern:** add a sub-package that follows that pattern's layout, e.g. `src/observer/ejercicio3/` or `src/factory/ej3/{main,model}/`.
- **New pattern:** add a package named after it, e.g. `src/singleton/`.

Each exercise is self-contained and has its own `Main` class. Declare packages that match the folder path from `src/` (e.g. `package factory.ej2.model;`) so the exercise works both in VS Code and from the command line.
