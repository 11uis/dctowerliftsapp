package dctower.lifts.app;

import java.sql.Array;
import java.util.ArrayList;
import java.util.List;

public class Lift {

    // Attributes
    private LiftState state;
    private Integer currentFloor;
    private List<Integer> stops;

    // Constructor
    public Lift() {
        this.stops = new ArrayList<>();
    }

    // Setters
    public void setState(LiftState s){
        this.state = s;
    }
    public void setCurrentFloor(Integer c){
        this.currentFloor = c;
    }

    // Getters
    public List<Integer> getStops(){
        return this.stops;
    }
    public LiftState getState(){
        return this.state;
    }
    public Integer getCurrentFloor(){
        return this.currentFloor;
    }

    /**
     * To add a new Stop
     * @param stop
     */
    public void addStop (Integer stop) {
        this.stops.add(stop);
    }
}
