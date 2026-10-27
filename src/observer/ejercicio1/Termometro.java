package observer.ejercicio1;

import java.util.ArrayList;
import java.util.List;

public class Termometro {
    private final List<Observador> observadores = new ArrayList<>();
    private double temperatura;

    public void suscribir(Observador observador) {
        observadores.add(observador);
    }

    public void desuscribir(Observador observador) {
        observadores.remove(observador);
    }

    public double getTemperatura() {
        return temperatura;
    }

    public void setTemperatura(double temperatura) {
        this.temperatura = temperatura;
        notificarObservadores();
    }

    private void notificarObservadores() {
        for (Observador observador : observadores) {
            observador.actualizar(temperatura);
        }
    }
}
