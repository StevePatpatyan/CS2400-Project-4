import animatedapp.*;
import java.awt.*;
import javax.swing.*;

/**
 * This animated application shows a solution to Reve's problem
 *  
 * @author Charles Hoot 
 * @version 5.0
 */
    
public class RevesApplication 
{

    public static void main (String args[]) 
    {
        
        ActionThread myThread = new RevesActionThread();                 // Change this line for different
                                                                // applications
        AnimatedApplication.startWith(myThread);
    }
    
}
