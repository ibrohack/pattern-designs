package factory.ej2.model;

public class Tarjeta implements MetodoPago {
    @Override
    public void realizarPago() {
        System.out.println("Pagando con tarjeta");
    }
}
