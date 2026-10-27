package observer.ejercicio2;

public class Main {
    public static void main(String[] args) {
        Marcador marcador = new Marcador();
        Estadisticas estadisticas = new Estadisticas();

        Jugador ana = new Jugador("Ana");
        Jugador luis = new Jugador("Luis");

        ana.suscribir(marcador);
        ana.suscribir(estadisticas);
        luis.suscribir(marcador);
        luis.suscribir(estadisticas);

        ana.completarMision();
        luis.derrotarEnemigo();
        ana.recogerObjeto();
        luis.completarMision();
        ana.derrotarEnemigo();
    }
}
