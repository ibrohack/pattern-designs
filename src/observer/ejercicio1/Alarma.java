package observer.ejercicio1;

public class Alarma implements Observador {
    private static final double UMBRAL = 30.0;

    @Override
    public void actualizar(double temperatura) {
        if (temperatura > UMBRAL) {
            System.out.println("[Alarma] ¡ALERTA! La temperatura (" + temperatura
                    + " ºC) supera los " + UMBRAL + " ºC");
        }
    }
}
