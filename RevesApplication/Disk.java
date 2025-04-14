import java.awt.*;

/**
 * A class implementing a disk of a given size for the Reeves puzzle.
 * 
 * @author Charles Hoot
 * @version 5.0
 */
    
public class Disk
{
    private int mySize;

    /**
     * Constructor for objects of class Disk
     * 
     * @param size The size of the disk.
     */
    public Disk(int size)
    {
        mySize = size;
    }

    /**
     * Find the size of the disk.
     * 
     * @return     The size of the disk.
     */
    public int getSize()
    {
        return mySize;
    }

    public static final int CORE = 5;
    public static final int BASEWIDTH = 4;
    public static final int BASEHEIGHT = 3;

    /**
     * Draw a representation of the disk at the given location.
     * 
     * @param   g  The graphics context to draw on.   
     * @param   centerX  The x position of the center of the disk.
     * @param   centerY  The y position of the center of the disk.
     * @param   scale   The size of the disk is scaled by this amount
     * 
     */
    public void drawOn(Graphics g, int centerX, int centerY, int scale)
    {
        int width = mySize*scale*BASEWIDTH + CORE;
        int height = BASEHEIGHT*scale;
        
        int upperLeftX = centerX - width/2;
        int upperLeftY = centerY - height/2;
        
        // Fill with green
        g.setColor(Color.green);
        g.fillRect(upperLeftX, upperLeftY, width, height);
        
        // Draw a black edge
        g.setColor(Color.black);
        g.drawRect(upperLeftX, upperLeftY, width, height);
        
    }
}
