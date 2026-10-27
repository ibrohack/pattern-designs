package factory.ej2.model;

// Encapsula la creación de los métodos de pago y decide qué clase concreta crear.
public class MetodoPagoFactory {

    public static MetodoPago crear(String tipo) {
        if ("tarjeta".equals(tipo)) {
            return new Tarjeta();
        }
        if ("paypal".equals(tipo)) {
            return new PayPal();
        }
        throw new IllegalArgumentException("Método de pago desconocido: " + tipo);
    }
}
