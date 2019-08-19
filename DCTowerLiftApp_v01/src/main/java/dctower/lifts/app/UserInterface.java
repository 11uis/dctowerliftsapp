package dctower.lifts.app;

import java.util.ArrayList;
import java.util.List;

public class UserInterface {
    private Controller controller;
    private List<Lift> lifts;

    public UserInterface()
    {
        this.lifts = new ArrayList<>();
    }

    /**
     * To provide a basic menu
     */

    /**
     * Create the 7 Lifts
     **/
    public List<Lift> createLifts() {
        for (int i = 0; i < 7; i++) {
            Lift lift = new Lift();
            lift.setState(LiftState.GROUNDFLOOR);
            lift.setId(i+1);
            this.lifts.add(lift);
        }
        return this.lifts;
    } // END of createLifts()

}
