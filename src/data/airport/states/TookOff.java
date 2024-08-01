package data.airport.states;

import data.airport.model.FlightData;

public class TookOff implements State {
    private static TookOff instance = null;
    public static TookOff getInstance(){
        if (instance == null){
            instance = new TookOff();
        }
        return instance;
    }

    private TookOff(){ }

    @Override
    public void change(FlightData fligth) {

    }
}

