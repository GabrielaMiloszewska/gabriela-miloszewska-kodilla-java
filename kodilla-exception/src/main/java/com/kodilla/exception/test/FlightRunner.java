package com.kodilla.exception.test;

import java.util.ArrayList;
import java.util.List;

public class FlightRunner {
    public static void main(String[] args) {

        FlightScanner flightScanner = new FlightScanner();

        List<Flight> searchingFlights = new ArrayList<>();
        searchingFlights.add(new Flight("Chopin Airport, Warsaw", "El Prat Airport, Barcelona"));
        searchingFlights.add(new Flight("Chopin Airport, Warsaw", "Porto Santo Airport, Porto Santo"));
        searchingFlights.add(new Flight("Narita International Airport, Tokyo", "Beijing Daxing International Airport, Beijing"));
        for (Flight theSearchingFlights : searchingFlights) {
            try {
                flightScanner.findFlight(theSearchingFlights);
            } catch (RouteNotFoundException e) {
                System.out.println("Route not found.");
            }

        }
    }
}
