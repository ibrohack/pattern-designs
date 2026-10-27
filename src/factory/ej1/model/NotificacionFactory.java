package factory.ej1.model;

public class NotificacionFactory {

    private NotificacionFactory() {
    }

    public static Notificacion crear(String tipo) {
        if ("email".equals(tipo)) {
            return new Email();
        }
        if ("sms".equals(tipo)) {
            return new Sms();
        }
        return null; 
    }
}
