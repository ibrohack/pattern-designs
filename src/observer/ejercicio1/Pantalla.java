package observer.ejercicio1;

public class Pantalla implements Observador {
    @Override
    public void actualizar(double temperatura) {
        System.out.println("[Pantalla] Temperatura actual: " + temperatura + " ºC");
    }
}
