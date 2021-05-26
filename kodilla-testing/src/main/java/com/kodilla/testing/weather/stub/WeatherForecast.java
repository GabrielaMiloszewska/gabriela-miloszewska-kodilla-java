package com.kodilla.testing.weather.stub;

import java.util.*;

public class WeatherForecast {
    private Temperatures temperatures;

    public WeatherForecast(Temperatures temperatures) {
        this.temperatures = temperatures;
    }

    public Map<String, Double> calculateForecast() {
        Map<String, Double> resultMap = new HashMap<>();

        for (Map.Entry<String, Double> temperature : temperatures.getTemperatures().entrySet()) {

            // adding 1 celsius degree to current value
            // as a temporary weather forecast
            resultMap.put(temperature.getKey(), temperature.getValue() + 1.0); // [1]
        }
        return resultMap;
    }

    public double calculateAverageTemperature () {
        double averageTemperature = 0;
        double mapSize = temperatures.getTemperatures().size();
        for (Map.Entry<String, Double> temperature : temperatures.getTemperatures().entrySet()) {
            averageTemperature += temperature.getValue();
        }
        return averageTemperature / mapSize;
    }

    public double calculateMedian() {
        List<Double> series = new ArrayList<>();
        for (Map.Entry<String, Double> temperature : temperatures.getTemperatures().entrySet()) {
            series.add(temperature.getValue());
        }
        double median = 0;
        Collections.sort(series);
        if (series.size() % 2 == 0) {
            median = series.get((series.size() - 1) / 2);
        } else {
            median = (series.get((series.size() - 1) / 2) + series.get(series.size() / 2)) / 2;
        }
        return median;
    }
}
