package adapter.ej1.model;

public class FahrenheitSensor {
    private final double fahrenheit;

    public FahrenheitSensor(double fahrenheit) {
        this.fahrenheit = fahrenheit;
    }

    public double readFahrenheit() {
        return fahrenheit;
    }
}
