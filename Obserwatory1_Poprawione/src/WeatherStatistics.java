import java.util.ArrayList;

public class WeatherStatistics implements DisplayElement, Observer {
    private Subject weatherData;
    ArrayList<Double> temperatureData;

    public WeatherStatistics(Subject weatherData) {
        this.temperatureData = new ArrayList<Double>();
        this.weatherData = weatherData;
        weatherData.registerObserver(this);
    }

    public void unregister() {
        weatherData.removeObserver(this);
        weatherData = null;
    }

    public void register(Subject weatherData) {
        this.weatherData = weatherData;
        weatherData.removeObserver(this);
    }

    private double getMaxTempValue() {
        double max = this.temperatureData.get(0);

        for (int i = 1; i < this.temperatureData.size(); i++) {
            if(this.temperatureData.get(i) > max) {
                max = this.temperatureData.get(i);
            }
        }

        return max;
    }

    private double getMinTempValue() {
        double min = this.temperatureData.get(0);

        for (int i = 1; i < this.temperatureData.size(); i++) {
            if(this.temperatureData.get(i) < min) {
                min = this.temperatureData.get(i);
            }
        }

        return min;
    }

    private double getMeanTempValue() {
        double tempSum = 0;

        for (Double data : this.temperatureData) {
            tempSum += data;
        }

        return Math.round((tempSum / this.temperatureData.size()) * 10.0) / 10.0;
    }

    @Override
    public void display() {
        System.out.println("Temperatura max: " + this.getMaxTempValue() + " C");
        System.out.println("Temperatura min: " + this.getMinTempValue() + " C");
        System.out.println("Srednia: " + this.getMeanTempValue() + " C");
    }

    @Override
    public void update(double temperature, double humidity, double pressure) {
        temperatureData.add(temperature);
        display();
    }
}