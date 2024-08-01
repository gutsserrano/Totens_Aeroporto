package data.airport.listener;

import data.airport.model.FlightData;

public interface FlightDataObserver {

    void update(FlightData flight);

}
