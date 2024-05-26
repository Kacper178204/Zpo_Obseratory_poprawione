public class Main {

    public static void main(String[] args) {
        WeatherData weatherData = new WeatherData();
        CurrentConditionsDisplay ccd = new CurrentConditionsDisplay(weatherData);
        WeatherForecast wf = new WeatherForecast(weatherData);
        WeatherStatistics ws = new WeatherStatistics(weatherData);

        weatherData.setMeasurements(5,36,1004);
        weatherData.setMeasurements(35,36,997);
        weatherData.setMeasurements(1,36,1001);
    }
}
