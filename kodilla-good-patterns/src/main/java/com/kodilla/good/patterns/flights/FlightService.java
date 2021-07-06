package com.kodilla.good.patterns.flights;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FlightService {

    final List<Flight> airportDatabase = new ArrayList<>();

    public List<Flight> getDatabase() {
        airportDatabase.add(new Flight("Barcelona", "Warsaw"));
        airportDatabase.add(new Flight("Warsaw", "Lisbon"));
        airportDatabase.add(new Flight("Lisbon", "Paris"));
        airportDatabase.add(new Flight("Milan", "Berlin"));
        airportDatabase.add(new Flight("Berlin", "Warsaw"));
        airportDatabase.add(new Flight("Paris", "Berlin"));
        airportDatabase.add(new Flight("Berlin", "Lisbon"));
        return new ArrayList<>(airportDatabase);
    }

    public List<Flight> searchForDepartureAirport(String departureAirport) {
        return airportDatabase.stream()
                .filter(airport -> airport.getDepartureAirport().equals(departureAirport))
                .collect(Collectors.toList());
    }

    public List<Flight> searchForArrivalAirport(String arrivalAirport) {
        return airportDatabase.stream()
                .filter(airport -> airport.getArrivalAirport().equals(arrivalAirport))
                .collect(Collectors.toList());
    }

    public List<Flight> searchForTransferAirport(String departureAirport, String transferAirport, String arrivalAirport) {

        List<Flight> transferDepartureAirport = airportDatabase.stream()
                .filter(airport -> airport.getDepartureAirport().equals(departureAirport))
                .filter(airport -> airport.getArrivalAirport().equals(transferAirport))
                .collect(Collectors.toList());

        List<Flight> transferArrivalAirport = airportDatabase.stream()
                .filter(airport -> airport.getDepartureAirport().equals(transferAirport))
                .filter(airport -> airport.getArrivalAirport().equals(arrivalAirport))
                .collect(Collectors.toList());

        return Stream.concat(transferDepartureAirport.stream(), transferArrivalAirport.stream())
                .collect(Collectors.toList());
    }

}