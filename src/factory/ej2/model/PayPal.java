package factory.ej2.model;

public class PayPal implements MetodoPago {
    @Override
    public void realizarPago() {
        System.out.println("Pagando con PayPal");
    }
}
