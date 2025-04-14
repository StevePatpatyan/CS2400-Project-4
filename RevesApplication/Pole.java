import java.util.*;
import java.awt.*;

/**
 * A class that will be used to implement the Reves puzzle.
 * Since this class will be accessed by both painting and application threads and it is 
 * mutable, make all methods synchronized.
 * 
 * @author Charles Hoot
 * @version 5.0
 */

        
public class Pole
    {
    private java.util.List<Disk> myDisks;
    private String myName;
    private int maxDisks;
    
    public Pole(String name,int max)
    {
        myDisks = new ArrayList<Disk>();
        myName = name;
        maxDisks = max;
    }
    
    
    /**
     * Get the name of the pole.
     *
     * @return     The name.
     */
    synchronized public String getName()
    {
       return myName;
    }
    
    
    
    /**
     * Add a disk on the pole.
     *
     * @param  d   The disk to add.
     */
    synchronized public void addDisk(Disk d)
    {
        myDisks.add(d);
    }
    
    /**
     * Remove a disk from the pole
     *
     * @return     The disk on the top or null if the pole is empty.
     */
    synchronized public Disk removeDisk()
    {
        Disk result = null;
        int count = myDisks.size();
        
        if(count > 0)
            result = (Disk) myDisks.remove(count-1);
            
        return result;
    }
    
    /**
     * Get the number of disks on the pole.
     *
     * @return     The number of disks on the pole.
     */
    synchronized public int getCount()
    {
        return myDisks.size();
    }
        
        
    public static final int POLEWIDTH = 3; 
    
    /**
     * Draw a representation of the pole and its disks at the given location.
     * 
     * @param   g  The graphics context to draw on.  
     * @param   baseCenterX  The x position of the center of the base of the pole.
     * @param   baseY  The y position of the base of the pole.
     * @param   scale   The amount to scale the Pole by.
     * 
     */

    synchronized public void drawOn(Graphics g, int baseCenterX, int baseY, int scale)
    {
        int poleHeight = Disk.BASEHEIGHT*(maxDisks+1);
        
        int width = POLEWIDTH*scale;
        int height = poleHeight*scale;
        
        int upperLeftX = baseCenterX - width/2;
        int upperLeftY = baseY - height;
        
        // Draw Pole
        g.setColor(Color.black);
        g.fillRect(upperLeftX, upperLeftY, width, height);
        
        // Draw each Disk
        Iterator<Disk> iter = myDisks.iterator();
        int drawDiskY = baseY-Disk.BASEHEIGHT*scale/2;
        for(int i = 0; i<myDisks.size(); i++)
        {
            Disk toDraw = iter.next();
            toDraw.drawOn(g, baseCenterX, drawDiskY, scale);
            drawDiskY -= Disk.BASEHEIGHT*scale;
        }
        
    }      
        
}
