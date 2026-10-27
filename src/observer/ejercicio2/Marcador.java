package observer.ejercicio2;

public class Marcador implements ObservadorPuntuacion {
    @Override
    public void actualizar(String jugador, int puntuacion) {
        System.out.println("[Marcador] " + jugador + ": " + puntuacion + " puntos");
    }
}
