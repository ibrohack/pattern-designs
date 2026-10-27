package factory.ej1.main;

import factory.ej1.model.Notificacion;
import factory.ej1.model.NotificacionFactory;

public class Main {
    public static void main(String[] args) {
        Notificacion notificacion = NotificacionFactory.crear("email");
        notificacion.enviar();

        notificacion = NotificacionFactory.crear("sms");
        notificacion.enviar();

        Notificacion desconocida = NotificacionFactory.crear("whatsapp");
        if (desconocida == null) {
            System.out.println("Tipo de notificación no soportado: whatsapp");
        }
    }
}
