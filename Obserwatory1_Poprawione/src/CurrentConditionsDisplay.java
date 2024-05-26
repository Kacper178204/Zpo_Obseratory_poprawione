
public class CurrentConditionsDisplay implements DisplayElement, Observer{
    private double temperature;
    private double humidity;
    private double pressure;
    private Subject weatherData;

    public CurrentConditionsDisplay(Subject weatherData) {
        this.weatherData = weatherData;
        weatherData.registerObserver(this);
    }

    public void unregister() {
        weatherData.removeObserver(this);
        weatherData = null;
    }

    public void register(Subject weatherData) {
        this.weatherData = weatherData;
        weatherData.registerObserver(this);
    }

    @Override
    public void display() {
        System.out.println("======================");
        System.out.println("Stacja pogodowa:");
        System.out.println("Temperatura : " + temperature);
        System.out.println("Wilgotnosc : " + humidity);
    }

    @Override
    public void update(double temperature, double humidity, double pressure) {
        this.temperature = temperature;
        this.humidity = humidity;
        this.pressure = pressure;
        display();
    }
}