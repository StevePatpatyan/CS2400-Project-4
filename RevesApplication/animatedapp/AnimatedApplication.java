package animatedapp;

import java.awt.*;
import javax.swing.*;

/**
 * This is an animated application.  Your main class should  supply the thread
 * that defines what it does.
 *  
 * @author Charles Hoot 
 * @version 5.0
 */
    
public class AnimatedApplication 
{    
        
    public static void startWith (ActionThread myThread) 
    {
        JPanel myPanel;
        Stepper myStepper;
        Object dispatcher;
        
        myPanel =  myThread.getAnimationPanel();
 
        dispatcher = new Object();
        AnimatedApplicationFrame myFrame = 
            new AnimatedApplicationFrame(myThread.getApplicationTitle(),
                                        dispatcher, myPanel, 
                                        myThread);
        myStepper = myFrame.getStepper();
        
        // must set the stepper before we start the thread
        myThread.setStepper(myStepper);
        myThread.start();
    }
    
    
 
}
