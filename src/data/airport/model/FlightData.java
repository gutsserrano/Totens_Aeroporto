package data.airport.model;

import data.airport.states.Arriving;
import data.airport.states.State;

public class FlightData {
    private final Long flightNumber;
    private final String company;
    private final String time;
    private State state;

    public FlightData(Long flightNumber, String company, String time) {
        this.flightNumber = flightNumber;
        this.company = company;
        this.time = time;
        this.state = Arriving.getInstance();
    }

    @Override
    public String toString() {
        return "Flight { number:" +
                flightNumber + ", company: " +
                company + ", time: " +
                time + ", state: " +
                state.getClass().getSimpleName() + "} ";
    }

    public Long getFlightNumber() {
        return flightNumber;
    }

    public String getCompany() {
        return company;
    }

    public String getTime() {
        return time;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }
}
