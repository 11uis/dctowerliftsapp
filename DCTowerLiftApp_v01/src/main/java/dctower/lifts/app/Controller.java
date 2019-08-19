package dctower.lifts.app;

import java.util.ArrayList;
import java.util.List;

public class Controller {
    private List<Lift> lifts;
    private List<Employee> employees;
    private List<Integer> floors;
    private static Controller ref;

    /**
     * Private Constructor. -> Singleton-Pattern
     */
    private Controller()
    {
        // I need to initialize the lists
        this.lifts = new ArrayList<>();
        this.employees = new ArrayList<>();
        this.floors = new ArrayList<>();
    }

    /**
     * Setters
     */
    public void setLifts (List<Lift> lifts) { this.lifts = lifts; }
    public void setEmployees (List<Employee> employees) { this.employees = employees; }
    public void setFloors (List<Integer> floors) { this.floors = floors; }

    /**
     * Getters
     */
    public List<Lift> getLifts() { return this.lifts; }
    public List<Employee> getEmployees() { return this.employees; }
    public List<Integer> getFloors() { return this.floors; }

    /**
     * Singleton-Pattern: the Controller class will be instantiated only once
     @return Controller
     */
    public static synchronized Controller getInstance()
    {
        if (ref == null) {
            ref = new Controller();
        }
        return ref;
    }

    /**
     * The main logic of the app
     */



}
