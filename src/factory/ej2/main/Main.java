package factory.ej2.main;

import factory.ej2.model.MetodoPago;
import factory.ej2.model.MetodoPagoFactory;

public class Main {
    public static void main(String[] args) {
        MetodoPago pago = MetodoPagoFactory.crear("tarjeta");
        pago.realizarPago();

        pago = MetodoPagoFactory.crear("paypal");
        pago.realizarPago();

        try {
            MetodoPagoFactory.crear("bizum");
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
