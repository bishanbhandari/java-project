package bubble_shooter;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.MouseInfo;
import java.awt.Point;

/**
 * Realises the moving arrow at the bottom of the screen.
 * /* */
public class Arrow{

    /**
     * current location of the mouse pointer
     */
    private Point p;

    private static final int TIP_LENGTH = 20;
    private static final int LENGTH = 80;

    /**
     * Constructor for the class arrow.
     */
    public Arrow(){
        p = new Point(Constants.FIELD_SIZE_X/2,0);
    }

    /**
     * Paints the arrow on the bottom of the screen depending on
     * the location of the pointer.
     * @param g2d the graphics where the arrow should be drawn
     * @param base the location of the frame on the screen
     */
    public void paintComponent(Graphics2D g2d, Point base) {
        g2d.setColor(Color.red);
        Point mouseLoc = MouseInfo.getPointerInfo().getLocation();
        int x = mouseLoc.x-base.x;//Calculates the x-coordinate of the mouse pointer relative to the base
        int y = mouseLoc.y-base.y;//Calculates the y-coordinate of the mouse pointer relative to the base

        if((0<=x) && (x<Constants.FIELD_SIZE_X) && (0<=y) && (y<Constants.FIELD_SIZE_Y)){   
            p=mouseLoc;// Updates the location of the arrow only if the mouse is within the field size
        }
        x = p.x-base.x;//Recalculates the x-coordinate of the pointer
        y = p.y-base.y;
        // Calculates the angle of the arrow based on the position of the mouse pointer
        double angle = Math.atan((double)(x-Constants.FIELD_SIZE_X/2)/(Constants.FIELD_SIZE_Y-y));
        g2d.rotate(angle,Constants.FIELD_SIZE_X/2,Constants.FIELD_SIZE_Y);// Rotates the graphics context to draw the arrow at the correct angle
        g2d.drawLine(Constants.FIELD_SIZE_X/2, Constants.FIELD_SIZE_Y,//Draws the main shaft of the arrow.
        Constants.FIELD_SIZE_X/2, Constants.FIELD_SIZE_Y-LENGTH);
        g2d.drawLine(Constants.FIELD_SIZE_X/2, Constants.FIELD_SIZE_Y-LENGTH,
        Constants.FIELD_SIZE_X/2-TIP_LENGTH, Constants.FIELD_SIZE_Y-LENGTH+TIP_LENGTH);// Draws one side of the arrow tip.
        g2d.drawLine(Constants.FIELD_SIZE_X/2, Constants.FIELD_SIZE_Y-LENGTH,
        Constants.FIELD_SIZE_X/2+TIP_LENGTH, Constants.FIELD_SIZE_Y-LENGTH+TIP_LENGTH);// Draws the other side of the arrow tip
        g2d.rotate(-angle,Constants.FIELD_SIZE_X/2,Constants.FIELD_SIZE_Y);//Rotates the graphics context back to its original orientation.
    }

}
/*This class creates and draws an arrow at the bottom of the screen.
The arrow points towards the mouse pointer, and its direction updates as the mouse moves. 
The paintComponent method is responsible for drawing the arrow and calculating its angle based on the mouse's position*/