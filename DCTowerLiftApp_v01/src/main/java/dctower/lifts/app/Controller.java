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
