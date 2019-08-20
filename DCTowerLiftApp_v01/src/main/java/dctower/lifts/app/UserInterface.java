package dctower.lifts.app;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class UserInterface {
    // Set to public to be able to do the Test in AppTest
    public Controller controller;
    private List<Employee> requestUp;
    private List<Employee> requestDown;

    public UserInterface() {
        this.requestUp = new ArrayList<>();
        this.requestDown = new ArrayList<>();
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
        this.createFloors();
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
        for (int i = 1; i < 10; i++) {
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

    /**
     * Add Elevator Request, the requests will be queued in two Lists
     */
    public void addRequest(Employee employee) {
        if (employee.getCurrentFloor() == 0) {
            this.requestUp.add(employee);
        } else {
            this.requestDown.add(employee);
        }
    } // END of addRequest(...)

    /**
     * Check available Elevator
     */
    public Lift checkAvailableElevator() {
        Integer temp;
        Employee employee;
        Lift availableLift = new Lift();
        // for the Employes on the Ground Floor
        if (this.requestUp.size() != 0) {
            for (int i = 0; i < this.controller.getInstance().getLifts().size(); i ++) {
                // This method will take always first an idle elevator in the ground Floor.
                // Need to implement a method that takes the closest elevator
                if ( this.controller.getInstance().getLifts().get(i).getCurrentFloor() == 0 && this.requestUp.size() != 0) {
                    // Add all the employess in the ground floor in the lift
                    for (int j = 0; j < this.requestUp.size(); j++){
                        employee = this.requestUp.get(j);
                        this.controller.getInstance().getLifts().get(i).addEmployee(employee);
                    }
                    // Set the new LiftState to UP
                    this.controller.getInstance().getLifts().get(i).setState(LiftState.UP);
                    availableLift = this.controller.getInstance().getLifts().get(i);
                    break;
                }
            }
            // Remove the employees that took the elevator from the requestUp
            for (int k = this.requestUp.size() - 1; k >= 0; k--) {
                this.requestUp.remove(k);
            }
        }  else if (this.requestDown.size() != 0){
            // TODO write method to pick the nearest Elevator
            for (int i = 0; i < this.controller.getInstance().getLifts().size(); i++) {
                if (this.controller.getInstance().getLifts().get(i).getState() == LiftState.STOP || this.controller.getInstance().getLifts().get(i).getState() == LiftState.DOWN) {
                    for (int j = 0; j < this.requestDown.size(); j++) {
                        temp = this.controller.getInstance().getLifts().get(i).getCurrentFloor() - this.requestDown.get(j).getCurrentFloor();
                        if (temp >= 0) {
                            employee = this.requestDown.get(j);
                            this.controller.getInstance().getLifts().get(i).addEmployee(employee);
                            this.controller.getInstance().getLifts().get(i).setState(LiftState.DOWN);
                            availableLift = this.controller.getInstance().getLifts().get(i);
                            break;
                        }
                    }
                }
            }
            // Remove the employees that took the elevator from the requestDown
            for(int k = this.requestDown.size() - 1; k >= 0; k--) {
                this.requestDown.remove(k);
            }
        }

        return availableLift;
    } // END of checkAvailableElevator()



    // TODO: Not working, check why it is not reading the keyboard
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

