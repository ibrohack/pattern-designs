package factory.ej1.model;

public class Sms implements Notificacion {
    @Override
    public void enviar() {
        System.out.println("Enviando SMS");
    }
}
