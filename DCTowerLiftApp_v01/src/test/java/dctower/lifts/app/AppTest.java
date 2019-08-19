package dctower.lifts.app;

import static org.junit.Assert.*;
import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue()
    {
        assertTrue( true );
    }

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
    }
}
