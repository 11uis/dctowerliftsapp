package dctower.lifts.app;

public class Employee {

    // Attributes
    private Integer floor;
    private Integer currentFloor;
    private String name;

    // Constructor
    /**
     * @param floor
     * */
    public Employee (String name, Integer floor) {
        this.floor = floor;
        this.name = name;
        this.currentFloor = 0;
    }

    // Setter
    public void setFloor(Integer floor) {
        this.floor = floor;
    }
    public void setName(String name) { this.name = name; }
    public void setCurrentFloor (Integer currentFloor) { this.currentFloor = currentFloor;}

    // Getter
    public Integer getFloor() {
        return this.floor;
    }
    public String getName() { return this.name; }
    public Integer getCurrentFloor() { return this.currentFloor; }
}
