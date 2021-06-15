package com.kodilla.exception.test;

import java.util.HashMap;
import java.util.Map;

public class FlightScanner {

        public void findFlight(Flight flight) throws RouteNotFoundException {
        Map<String, Boolean> airportMap = new HashMap<>();
        airportMap.put("El Prat Airport, Barcelona", true);
        airportMap.put("Berlin Brandenburg Airport, Berlin", true);
        airportMap.put("Sydney Airport, Sydney", false);
        airportMap.put("Adolfo Suarez Madrid–Barajas Airport, Madrid", true);
        airportMap.put("Porto Santo Airport, Porto Santo", false);
        airportMap.put("Funchal Cristiano Ronaldo Airport, Madeira", true);
        airportMap.put("Chopin Airport, Warsaw", true);
        airportMap.put("Billy Bishop Toronto City Airport, Toronto", false);

        if (airportMap.containsKey(flight.getArrivalAirport())) {
            if (airportMap.get(flight.getArrivalAirport())) {
                System.out.println("You can book your flight.");
            } else {
                System.out.println("This flight is not available.");
            }
        } else {
            throw new RouteNotFoundException("Route not found.");
        }
    }
}
