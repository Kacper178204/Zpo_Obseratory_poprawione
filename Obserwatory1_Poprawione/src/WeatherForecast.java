public class WeatherForecast implements DisplayElement, Observer {
    private double currPressure;
    private double prevPressure;
    private Subject weatherData;
    private boolean isFirstMeasure;

    public WeatherForecast(Subject weatherData) {
        this.currPressure = 0;
        this.prevPressure = 0;
        this.isFirstMeasure = true;
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
        if(this.isFirstMeasure) {
            System.out.println("Cisnienie: " + currPressure + " Pa - Pierwszy pomiar");
        } else if(currPressure < prevPressure) {
            System.out.println("Cisnienie: " + currPressure + " Pa - Pogoda sie pogarsza");
        } else if (currPressure > prevPressure) {
            System.out.println("Cisnienie: " + currPressure + " Pa - Pogoda sie poprawia");
        } else {
            System.out.println("Cisnienie: " + currPressure + " Pa - Brak zmiany pogody");
        }
        this.isFirstMeasure = false;
    }


    @Override
    public void update(double temperature, double humidity, double pressure) {
        this.prevPressure = this.currPressure;
        this.currPressure = pressure;
        display();
    }
}