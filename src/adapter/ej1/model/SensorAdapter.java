package adapter.ej1.model;

// Envuelve el sensor heredado y traduce sus lecturas en Fahrenheit a la interfaz en Celsius.
public class SensorAdapter implements TemperatureProvider {
    private final FahrenheitSensor sensor;

    public SensorAdapter(FahrenheitSensor sensor) {
        this.sensor = sensor;
    }

    @Override
    public double getTemperatureCelsius() {
        return (sensor.readFahrenheit() - 32) * 5 / 9;
    }
}
