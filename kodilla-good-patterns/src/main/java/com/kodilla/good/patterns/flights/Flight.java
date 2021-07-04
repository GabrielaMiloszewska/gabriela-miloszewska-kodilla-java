package com.kodilla.good.patterns.flights;

public class Flights {

    private final String departureAirport;
    private final String transferAirport;
    private final String arrivalAirport;

    public Flights(final String departureAirport, final String transferAirport, final String arrivalAirport) {
        this.departureAirport = departureAirport;
        this.transferAirport = transferAirport;
        this.arrivalAirport = arrivalAirport;
    }

    public String getDepartureAirport() {
        return departureAirport;
    }

    public String getTransferAirport() {
        return transferAirport;
    }

    public String getArrivalAirport() {
        return arrivalAirport;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Flights)) return false;

        Flights flights = (Flights) o;

        if (getDepartureAirport() != null ? !getDepartureAirport().equals(flights.getDepartureAirport()) : flights.getDepartureAirport() != null)
            return false;
        if (getTransferAirport() != null ? !getTransferAirport().equals(flights.getTransferAirport()) : flights.getTransferAirport() != null)
            return false;
        return getArrivalAirport() != null ? getArrivalAirport().equals(flights.getArrivalAirport()) : flights.getArrivalAirport() == null;
    }

    @Override
    public int hashCode() {
        int result = getDepartureAirport() != null ? getDepartureAirport().hashCode() : 0;
        result = 31 * result + (getTransferAirport() != null ? getTransferAirport().hashCode() : 0);
        result = 31 * result + (getArrivalAirport() != null ? getArrivalAirport().hashCode() : 0);
        return result;
    }
}
