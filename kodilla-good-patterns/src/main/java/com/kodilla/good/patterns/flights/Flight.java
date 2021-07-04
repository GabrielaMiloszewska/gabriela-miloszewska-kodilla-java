package com.kodilla.good.patterns.flights;

public class Flight {

    private final String departureAirport;
    private final String transferAirport;
    private final String arrivalAirport;

    public Flight(final String departureAirport, final String transferAirport, final String arrivalAirport) {
        this.departureAirport = departureAirport;
        this.transferAirport = transferAirport;
        this.arrivalAirport = arrivalAirport;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Flight)) return false;

        Flight flight = (Flight) o;

        if (departureAirport != null ? !departureAirport.equals(flight.departureAirport) : flight.departureAirport != null)
            return false;
        if (transferAirport != null ? !transferAirport.equals(flight.transferAirport) : flight.transferAirport != null)
            return false;
        return arrivalAirport != null ? arrivalAirport.equals(flight.arrivalAirport) : flight.arrivalAirport == null;
    }

    @Override
    public int hashCode() {
        int result = departureAirport != null ? departureAirport.hashCode() : 0;
        result = 31 * result + (transferAirport != null ? transferAirport.hashCode() : 0);
        result = 31 * result + (arrivalAirport != null ? arrivalAirport.hashCode() : 0);
        return result;
    }
}
