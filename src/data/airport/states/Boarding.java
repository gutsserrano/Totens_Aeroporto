package data.airport.states;

import data.airport.model.FlightData;

public class Boarding implements State{
    private static Boarding instance = null;
    public static Boarding getInstance(){
        if (instance == null){
            instance = new Boarding();
        }
        return instance;
    }

    private Boarding(){}

    @Override
    public void change(FlightData fligth) {
        fligth.setState(TakingOff.getInstance());
    }
}
