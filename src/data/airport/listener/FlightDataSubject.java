package data.airport.listener;

public interface FlightDataSubject {
    void register(FlightDataObserver flightDataObserver);

    void unregister(FlightDataObserver flightDataObserver);

    void notifyObservers();
}
