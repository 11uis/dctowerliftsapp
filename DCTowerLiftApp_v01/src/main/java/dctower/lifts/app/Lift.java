package dctower.lifts.app;

import java.sql.Array;
import java.util.ArrayList;
import java.util.List;

public class Lift {

    // Attributes
    private LiftState state = LiftState.GROUNDFLOOR;
    private Integer currentFloor;
    private List<Integer> stops;
    private List<Employee> employeeList;

    // Constructor
    public Lift() {
        this.stops = new ArrayList<>();
        this.employeeList = new ArrayList<>();
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
    public List<Employee> getEmployeeList() { return this.employeeList; }

    /**
     * To add a new Employee
     * @param employee
     */
    public void addEmployee (Employee employee) {
        this.employeeList.add(employee);
        // Auxiliar Integer to count how many times the floor is in the array
        Integer counter = 0;
        if (this.employeeList.size() > 1){
            // Check if the floor is in the List of stops
            for (int i = 0; i < employeeList.size(); i++ ) {
                if (employee.floor == this.employeeList.get(i).floor) {
                    counter++;
                }
            }
            if (counter == 0) {
                // the Floor appeared for the first time, add it to the List
                this.stops.add(employee.floor);
            }
        }
    }
}
