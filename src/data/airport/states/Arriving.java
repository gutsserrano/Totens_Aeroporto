package data.airport.states;

import data.airport.model.FlightData;

public class Arriving implements State{
    private static Arriving instance = null;
    public static Arriving getInstance(){
        if (instance == null){
            instance = new Arriving();
        }
        return instance;
    }

    private Arriving(){ }

    @Override
    public void change(FlightData fligth) {
        fligth.setState(Boarding.getInstance());
    }
}
