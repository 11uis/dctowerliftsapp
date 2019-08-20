package dctower.lifts.app;

/**
 * Create the UserInterface
 @author Lluis Carrasco Martinez
 */
public class App 
{
    public static void main( String[] args )
    {
        UserInterface ui = new UserInterface();
        // Create the 7 Lifts and save them in a List<Lift>
        ui.createLifts();
    }
}
