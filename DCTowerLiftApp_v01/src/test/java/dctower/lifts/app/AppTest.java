package dctower.lifts.app;

import static org.junit.Assert.*;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Unit test for simple App.
 @author Lluis Carrasco Martinez
 */
public class AppTest 
{
  private UserInterface ui = new UserInterface();

    /**
     * Testing the addStop() method from the Lift class
    **/
    @Test
    public void addStop(){
        Lift lift1 = new Lift();
        lift1.setCurrentFloor(0);
        lift1.setState(LiftState.GROUNDFLOOR);

        Employee employee1 = new Employee("Alba", 22);

        lift1.addEmployee(employee1);

        System.out.println("Number of employees: " + lift1.getStops().size());
        assertEquals(1, lift1.getStops().size());
    } // END addStop()

    @Test
    public void createLifts() {
        //UserInterface ui = new UserInterface();
        List<Lift> lifts = new ArrayList<>();
        lifts = ui.createLifts();
        for (int i = 0; i < 7; i++) {
            System.out.println("Lift number: " + lifts.get(i).getId());
        }
        assertEquals(7,lifts.size());
    } // END of createLifts()

    @Test
    public void startUI() {
        // this.createLifts();
        ui.start();

    } // END of startUI()

    @Test
    public void createEmployees() {
        ui.createEmployees();
    }

    @Test
    public void createFloors() {
        ui.createFloors();
        assertEquals(50, ui.controller.getInstance().getFloors().size());
    }

    /**
     * Test the addRequest() method and the checkAvailableElevator() method
     * Also tests goingUpElevator() and goingDownElevator() methods
     */
    @Test
    public void availableElevator() {
        System.out.println("\n\n################ Elevators before the addRequest() ##############");
        ui.start();
        ui.addRequest(ui.controller.getInstance().getEmployees().get(0));
        ui.checkAvailableElevator();

        // Print the Elevators State after the addRequest() method
        System.out.println("\n\n################ Elevators after the addRequest ##############");
        for ( int i = 0; i < ui.controller.getInstance().getLifts().size(); i ++) {
            System.out.println("Lift: " + ui.controller.getInstance().getLifts().get(i).getId() +
                    "    Current floor: " + ui.controller.getInstance().getLifts().get(i).getCurrentFloor() +
                    "    State: " + ui.controller.getInstance().getLifts().get(i).getState());
        }

        // Update the Elevators
        ui.controller.getInstance().goingUpElevator();


        ui.addRequest(ui.controller.getInstance().getEmployees().get(2));
        ui.checkAvailableElevator();
        ui.controller.getInstance().goingUpElevator();

        ui.addRequest(ui.controller.getInstance().getEmployees().get(7));
        ui.checkAvailableElevator();
        ui.controller.getInstance().goingUpElevator();

        ui.addRequest(ui.controller.getInstance().getEmployees().get(6));
        ui.checkAvailableElevator();
        ui.controller.getInstance().goingUpElevator();

        ui.addRequest(ui.controller.getInstance().getEmployees().get(5));
        ui.checkAvailableElevator();
        ui.controller.getInstance().goingUpElevator();

        ui.addRequest(ui.controller.getInstance().getEmployees().get(4));
        ui.checkAvailableElevator();
        ui.controller.getInstance().goingUpElevator();

        ui.addRequest(ui.controller.getInstance().getEmployees().get(8));
        ui.checkAvailableElevator();
        ui.controller.getInstance().goingDownElevator();

        // Print the Elevators State
        System.out.println("\n\n################ Elevators State ##############");
        for ( int i = 0; i < ui.controller.getInstance().getLifts().size(); i ++) {
            System.out.println("Lift: " + ui.controller.getInstance().getLifts().get(i).getId() +
                    "    Current floor: " + ui.controller.getInstance().getLifts().get(i).getCurrentFloor() +
                    "    State: " + ui.controller.getInstance().getLifts().get(i).getState());
        }

    } // END of availableElevator()


    // TODO Test not successful, retake it
    @Test
    public void hireEmployee() {
        ui.hireEmployee();

    } // END of hireEmployee()

    /* @Test
    public void ascendingStopsOrder() {
        List<Employee> employeeList = new ArrayList<>();
        String name;
        for (int i = 6; i > 0; i--) {
            name = "employee" + i;
            Employee employee = new Employee(name, i);
            employeeList.add(employee);
        }

        Lift lift = new Lift();
        for (int i = 0; i < employeeList.size(); i++) {
            lift.addEmployee(employeeList.get(i));
        }

        System.out.println("############## NON ORDERED ################");
        for (int i = 0; i < lift.getStops().size(); i++) {
            System.out.println("Floor: " + lift.getStops().get(i));
        }
        lift.ascendentStopsOrder();
        System.out.println("############### ORDERDE ##################");
        for (int i = 0; i < lift.getStops().size(); i++) {
            System.out.println("Floor: " + lift.getStops().get(i));
        }
    } // END of ascendentStopsOrder()*/


}
