package data.airport.model;

import data.airport.listener.FlightDataObserver;
import data.airport.listener.FlightDataSubject;
import data.airport.states.TookOff;

import java.util.LinkedList;
import java.util.List;

public class FlightDataCollection implements FlightDataSubject {

    private List<FlightData> flights;
    private List<FlightDataObserver> observers;
    private FlightData _updated;

    public FlightDataCollection() {
        flights = new LinkedList<>();
        observers = new LinkedList<>();
    }

    @Override
    public void register(FlightDataObserver flightDataObserver) {
        observers.add(flightDataObserver);
    }

    @Override
    public void unregister(FlightDataObserver flightDataObserver) {
        observers.add(flightDataObserver);
    }

    @Override
    public void notifyObservers() {
        observers.stream()
                .forEach(flightDataObserver -> flightDataObserver.update(_updated));
    }

    public List<FlightData> allFlights(){
        return new LinkedList<>(flights);
    }

    public void insertFlight(FlightData flight) {
        if (flight != null) {
            _updated = flight;
            flights.add(flight);
            notifyObservers();
        }
    }

    public FlightData findByNumber(Long flightNumber){
        return flights.stream()
                .filter(flightData -> flightData.getFlightNumber() == flightNumber)
                .findFirst()
                .orElse(null);
    }

    public void updateFlight(Long flightNumber){
        var flight = findByNumber(flightNumber);
        if (flight != null) {
            flight.getState().change(flight);
            if (flight.getState() instanceof TookOff) {
                flights.remove(flight);
            }
            _updated = flight;
            notifyObservers();
        }
    }
}
