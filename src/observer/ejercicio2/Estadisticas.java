package observer.ejercicio2;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.ZoneId;

public class Estadisticas implements ObservadorPuntuacion {
    private final String rutaFichero;

    public Estadisticas() {
        this("estadisticas.txt");
    }

    public Estadisticas(String rutaFichero) {
        this.rutaFichero = rutaFichero;
    }

    @Override
    public void actualizar(String jugador, int puntuacion) {
        try (PrintWriter salida = new PrintWriter(new FileWriter(rutaFichero, true))) {
            salida.println(LocalDateTime.now(ZoneId.systemDefault()) +";" + jugador + ";" + puntuacion);
        } catch (IOException e) {
            System.err.println("[Estadisticas] No se pudo escribir en " + rutaFichero + ": " + e.getMessage());
        }
    }
}
