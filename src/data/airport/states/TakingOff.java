package data.airport.states;

import data.airport.model.FlightData;

public class TakingOff implements State{
    private static TakingOff instance = null;
    public static TakingOff getInstance(){
        if (instance == null){
            instance = new TakingOff();
        }
        return instance;
    }

    private TakingOff(){ }

    @Override
    public void change(FlightData fligth) {
        fligth.setState(TookOff.getInstance());
    }
}
