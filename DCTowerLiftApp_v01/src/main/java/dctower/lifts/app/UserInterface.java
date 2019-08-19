package dctower.lifts.app;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UserInterface {
    // Set to public to be able to do the Test
    public Controller controller;

    public UserInterface() {
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
            lift.setCurrentFloor(0);
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
        this.createEmployees();
        this.createLifts();
        for (int i = 0; i < controller.getInstance().getLifts().size(); i++) {
            System.out.println("Lift: " + controller.getInstance().getLifts().get(i).getId() +
                    "    Current floor: " + controller.getInstance().getLifts().get(i).getCurrentFloor() +
                    "    State: " + controller.getInstance().getLifts().get(i).getState());
        }
    } // END of start()

    /**
     * Methode to create a List of Employees
     */
    public void createEmployees(){
        String name;
        Integer floor;
        for (int i = 0; i < 10; i++) {
            if (i%2 == 0) {
                name = "employee" + i;
                floor = i;
            } else {
                name = "employee" + i;
                floor = i*3;
            }
            Employee newEmployee = new Employee(name, floor);
            this.controller.getInstance().getEmployees().add(newEmployee);
        }

        for ( int i = 0; i < this.controller.getInstance().getEmployees().size(); i++) {
            System.out.println("Name: " + this.controller.getInstance().getEmployees().get(i).getName()
            + "    Floor: " + this.controller.getInstance().getEmployees().get(i).getFloor());
        }
    } // END of createEmployees()

    /**
     * Methode to create the 50 floors
     */
    public void createFloors() {
        for (int i = 1; i < 51; i++) {
            this.controller.getInstance().getFloors().add(i);
        }
    } // END of createFloors()

    // TODO Not working check why it is not reading the keyboard
    /**
     * Methode to hire a new Employee
     */
    public void hireEmployee() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Name of the new employee: ");
        String name = scanner.nextLine();
        System.out.println("Floor where the employee will work: ");
        Integer floor = scanner.nextInt();
        // Integer floor = readInteger(1, 50);
        controller.getInstance().createEmployee(name, floor);
    } // END of hireEmployee


    /**
     * Methode to read a Line from the Keyboard
     @return java.lang.String
     */
    private String readLine() {
        String value = "\0";
        BufferedReader inReader = new BufferedReader(new InputStreamReader(System.in));
        try {
            value = inReader.readLine();
        } catch (IOException e) {
        }
        return value.trim();
    } // END of readLine()

    /**
     * Methode to give an Integer (lowerlimit is 1, upperlimit is 50)
     @param lowerlimit
     @param upperlimit
     @return int
     */
    private int readInteger(int lowerlimit, int upperlimit)
    {
        Integer number=null;
        while(number==null) {
            String str = this.readLine();
            try {
                number = Integer.parseInt(str);
            }catch(NumberFormatException e) {
                number=null;
                System.out.println("Please enter the floor where you work:");
                e.printStackTrace();
                continue;
            }
            if(number<lowerlimit) {
                System.out.println("The floor is too low, give a higher floor please:");
                number=null;
            }else if(number>upperlimit) {
                System.out.println("This floor does not exist, please give a lower number:");
                number=null;
            }
        }
        return number;
    } // END of readInteger(...)
}

