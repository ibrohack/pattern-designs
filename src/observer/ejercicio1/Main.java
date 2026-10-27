package observer.ejercicio1;

public class Main {
    public static void main(String[] args) {
        Termometro termometro = new Termometro();
        termometro.suscribir(new Pantalla());
        termometro.suscribir(new Alarma());

        System.out.println("--- Cambio a 25 ºC ---");
        termometro.setTemperatura(25);

        System.out.println("--- Cambio a 35 ºC ---");
        termometro.setTemperatura(35);
    }
}
