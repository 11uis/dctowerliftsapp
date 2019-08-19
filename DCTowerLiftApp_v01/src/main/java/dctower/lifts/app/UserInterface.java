package dctower.lifts.app;

import java.util.ArrayList;
import java.util.List;

public class UserInterface {
    private Controller controller;

    public UserInterface()
    {
    }

    /**
     * To provide a basic menu
     */

    /**
     * Create the 7 Lifts
     **/
    public List<Lift> createLifts() {
        List<Lift> lifts = new ArrayList<>();
        for (int i = 0; i < 7; i++) {
            Lift lift = new Lift();
            lift.setState(LiftState.GROUNDFLOOR);
            lift.setId(i+1);
            lifts.add(lift);
        }
        // Set the Lifts in the Controller
        this.controller.getInstance().setLifts(lifts);
        return lifts;
    } // END of createLifts()

    /**
     * Main Menu
     */
    public void start() {
        for (int i = 0; i < controller.getInstance().getLifts().size(); i++) {
            System.out.println("Lift: " + controller.getInstance().getLifts().get(i).getId() +
                    "    Current floor: " + controller.getInstance().getLifts().get(i).getCurrentFloor() +
                    "    State: " + controller.getInstance().getLifts().get(i).getState());
        }
    } // END of start()
}

