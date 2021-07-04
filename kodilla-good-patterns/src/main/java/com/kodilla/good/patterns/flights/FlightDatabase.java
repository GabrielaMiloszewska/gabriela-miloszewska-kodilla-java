package com.kodilla.good.patterns.flights;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public final class FlightDatabase {

    public static Set<Flight> searchDatabase() {
        final Set<Flight> airportDatabase = new HashSet<>();
        airportDatabase.add(new Flight("Barcelona", "Frankfurt", "Warszawa"));
        airportDatabase.add(new Flight("Warszawa", "Frankfurt", "Barcelona"));
        airportDatabase.add(new Flight("Lizbona", "Berlin", "Paryz"));
        airportDatabase.add(new Flight("Mediolan", "Berlin", "Rzym"));
        airportDatabase.add(new Flight("Berlin", "Warszawa", "Moskwa"));
        airportDatabase.add(new Flight("Moskwa", "Berlin", "Paryz"));
        return new HashSet<>(airportDatabase);
    }


}
