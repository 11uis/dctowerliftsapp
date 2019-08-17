package dctower.lifts.app;

public class Employee {

    // Attributes
    private Integer floor;

    // Constructor
    /**
     * @param floor
     * */
    public Employee (Integer floor) {
        this.floor = floor;
    }

    // Setter
    public void setFloor(Integer floor) {
        this.floor = floor;
    }

    // Getter
    public Integer getFloor() {
        return this.floor;
    }
}
