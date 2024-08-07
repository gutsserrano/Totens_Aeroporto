package totem.airport;

import data.airport.listener.FlightDataObserver;
import data.airport.model.FlightData;
import data.airport.states.State;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Vector;

public class Totem implements FlightDataObserver {

    private Collection<FlightData> flights;
    private Collection<State> states;
    private JFrame jFrame;
    private JPanel jPanel;

    public Totem(int x, int y, String totemName) {
        jFrame = new JFrame(totemName);
        jPanel = new JPanel();
        flights = new Vector<>();

        jPanel.setLayout(new BorderLayout());
        jFrame.setSize(400, 250);
        jFrame.setLocation(x, y);
        jFrame.setAlwaysOnTop(true);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        jFrame.setVisible(true);
    }

    public void startTotem(State... observedStates){
        states = new ArrayList<State>(Arrays.stream(observedStates).toList());
    }

    @Override
    public void update(FlightData flight) {
        if(!flights.contains(flight) && states.contains(flight.getState())){
            flights.add(flight);
        }
        flights.removeIf(f -> !states.contains(f.getState()));

        JScrollPane jScrollPane = new JScrollPane(new JList<>((Vector<FlightData>) flights));
        jPanel.add(jScrollPane, BorderLayout.CENTER);
        jFrame.add(jPanel);
        jFrame.setVisible(true);
    }

    public void closeFrame(){
        jFrame.dispose();
    }
}
