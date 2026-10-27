package observer.ejercicio2;

import java.util.ArrayList;
import java.util.List;

public class Jugador {
    private static final int PUNTOS_MISION = 100;
    private static final int PUNTOS_ENEMIGO = 50;
    private static final int PUNTOS_OBJETO = 10;

    private final String nombre;
    private int puntuacion;
    private final List<ObservadorPuntuacion> observadores = new ArrayList<>();

    public Jugador(String nombre) {
        this.nombre = nombre;
    }

    public void suscribir(ObservadorPuntuacion observador) {
        observadores.add(observador);
    }

    public void desuscribir(ObservadorPuntuacion observador) {
        observadores.remove(observador);
    }

    public void completarMision() {
        sumarPuntos(PUNTOS_MISION);
    }

    public void derrotarEnemigo() {
        sumarPuntos(PUNTOS_ENEMIGO);
    }

    public void recogerObjeto() {
        sumarPuntos(PUNTOS_OBJETO);
    }

    public String getNombre() {
        return nombre;
    }

    public int getPuntuacion() {
        return puntuacion;
    }

    private void sumarPuntos(int puntos) {
        puntuacion += puntos;
        notificarObservadores();
    }

    private void notificarObservadores() {
        for (ObservadorPuntuacion observador : observadores) {
            observador.actualizar(nombre, puntuacion);
        }
    }
}
