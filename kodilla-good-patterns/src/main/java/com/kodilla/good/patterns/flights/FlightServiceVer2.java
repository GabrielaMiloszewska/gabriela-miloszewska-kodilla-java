package com.kodilla.good.patterns.flights;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FlightServiceVer2 {

    final List<Flight> airportDatabase = new ArrayList<>();

    public List<Flight> getDatabase()  {
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

        List<Flight> transferDepartureAirport = searchForDepartureAirport(departureAirport).stream()
                .filter(airport -> airport.getArrivalAirport().equals(transferAirport))
                .collect(Collectors.toList());

        List<Flight> transferArrivalAirport = searchForArrivalAirport(arrivalAirport).stream()
                .filter(airport -> airport.getDepartureAirport().equals(transferAirport))
                .collect(Collectors.toList());

        List<Flight> transfer = new ArrayList<>();
        transfer.addAll(transferDepartureAirport);
        transfer.addAll(transferArrivalAirport);
        return transfer;
    }

}

