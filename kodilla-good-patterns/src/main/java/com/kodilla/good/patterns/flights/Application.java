package com.kodilla.good.patterns.flights;

public class Application {
    public static void main(String[] args) {

        FlightService flightService = new FlightService();
        flightService.getDatabase();

        System.out.println("You are searching for flights from Barcelona..." + flightService.searchForDepartureAirport("Barcelona"));
        System.out.println("You are searching for flights to Lisbon..." + flightService.searchForArrivalAirport("Lisbon"));
        System.out.println("You are searching for flights from Barcelona to Lisbon via Warsaw..." + flightService.searchForTransferAirport("Barcelona", "Warsaw", "Lisbon"));

    }
}