package factory.ej1.model;


public class Email implements Notificacion {
    @Override
    public void enviar() {
        System.out.println("Enviando email");
    }
}
