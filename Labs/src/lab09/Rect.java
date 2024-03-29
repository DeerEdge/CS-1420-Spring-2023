package lab09;
import java.awt.Graphics;
import java.awt.Color;

/**
 * Circle objects represent a circle shape
 * drawn to the screen at a particular position
 * with some size and color.
 *
 * @author Peter Jensen
 * @version Spring 2023
 */
public class Rect extends Shape
{
    // Instance variables.

    private int width;
    private int height;

    /**
     * Constructor - initializes the position, diameter, and
     * color of this circle object.
     *
     * @param x
     *         the x coordinate of this object's position
     *
     * @param y
     *         the x coordinate of this object's position
     *
     * @param width
     *              the diameter of this circle
     *
     * @param color
     *             the color of this circle
     */
    public Rect (int x, int y, int width, int height, Color color)
    {
        super(x, y, color);
        this.width = width;
        this.height = height;
    }

    /**
     * Draws the circle at it's current position and color
     * to the specified graphics object.
     *
     * @param g
     *         the graphics object (where to draw to)
     */
    public void draw (Graphics g)
    {
        g.setColor (color);
        g.fillRect (x, y, width, height);
    }

    /**
     * Returns true if the coordinates are within the circle.
     *
     * @param targetX
     *               an x coordinate
     *
     * @param targetY
     *               a y coordinate
     *
     * @return
     *        true if the coordinates are within the shape
     */
    public boolean isInside (int targetX, int targetY)
    {
        int cx = x + width;  // Calculate the center point
        int cy = y + width;

        int deltaX = cx - targetX;  // Calculate the deltas to the click
        int deltaY = cy - targetY;

        // Make sure the distance from the click to the center is less
        //   than the radius.  (Notice how I avoid a square root.)

        return targetX >= x &&
                targetX < x + width &&
                targetY >= y &&
                targetY < y + height;
    }
}