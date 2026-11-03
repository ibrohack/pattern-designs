package adapter.ej1.main;

import adapter.ej1.model.FahrenheitSensor;
import adapter.ej1.model.SensorAdapter;
import adapter.ej1.model.TemperatureProvider;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in).useLocale(Locale.US);
        double fahrenheit = scanner.nextDouble();
        scanner.close();

        FahrenheitSensor sensor = new FahrenheitSensor(fahrenheit);
        TemperatureProvider provider = new SensorAdapter(sensor);

        System.out.printf(Locale.US, "Temperature: %.1f C%n", provider.getTemperatureCelsius());
    }
}
