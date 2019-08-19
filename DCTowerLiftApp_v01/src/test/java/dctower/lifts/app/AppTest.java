package dctower.lifts.app;

import static org.junit.Assert.*;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Unit test for simple App.
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

    // TODO Test not successful, retake
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
