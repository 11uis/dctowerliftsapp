package dctower.lifts.app;

public class Employee {

    // Attributes
    public Integer floor;
    public String name;

    // Constructor
    /**
     * @param floor
     * */
    public Employee (String name, Integer floor) {
        this.floor = floor;
        this.name = name;
    }

    // Setter
    public void setFloor(Integer floor) {
        this.floor = floor;
    }
    public void setName(String name) { this.name = name; }

    // Getter
    public Integer getFloor() {
        return this.floor;
    }
    public String getName() { return this.name; }
}
