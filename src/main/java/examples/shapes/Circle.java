package examples.shapes;

import java.awt.*;

/**
 * Circle
 * <p>
 * This class represents circle objects that can be moved and scales.  Users of a circle can also get its area.
 */
@SuppressWarnings("WeakerAccess")
public class Circle extends AbstractShape {
    private Point center;
    private double radius;

    /**
     * Constructor with x-y Location for center
     *
     * @param x      The x-location of the center of the circle -- must be a valid double
     * @param y      The y-location of the center of the circle
     * @param radius The radius of the circle -- must be greater or equal to zero.
     * @throws ShapeException The exception thrown if the x, y, or z are not valid
     */
    public Circle(double x, double y, double radius) throws ShapeException {
        Validator.validatePositiveDouble(radius, "Invalid radius");
        center = new Point(x, y);
        this.radius = radius;
    }

    /**
     * Constructor with a Point for center
     *
     * @param center The x-location of the center of the circle -- must be a valid point
     * @param radius The radius of the circle -- must be greater or equal to zero.
     * @throws ShapeException The exception thrown if the x, y, or z are not valid
     */
    public Circle(Point center, double radius) throws ShapeException {
        Validator.validatePositiveDouble(radius, "Invalid radius");
        if (center == null)
            throw new ShapeException("Invalid center point");

        this.center = center;
        this.radius = radius;
    }

    /**
     * @return The center of the circle
     */
    public Point getCenter() {
        return center;
    }

    /**
     * @return The radius of the circle
     */
    public double getRadius() {
        return radius;
    }

    /**
     * Move the circle
     *
     * @param deltaX a delta change for the x-location of center of the circle
     * @param deltaY a delta change for the y-location of center of the circle
     * @throws ShapeException Exception thrown if either the delta x or y are not valid doubles
     */
    public void move(double deltaX, double deltaY) throws ShapeException {
        center.move(deltaX, deltaY);
    }

    /**
     * Scale the circle
     *
     * @param scaleFactor a non-negative double that represents the percentage to scale the circle.
     *                    0>= and <1 to shrink.
     *                    >1 to grow.
     * @throws ShapeException Exception thrown if the scale factor is not valid
     */
    public void scale(double scaleFactor) throws ShapeException {
        Validator.validatePositiveDouble(scaleFactor, "Invalid scale factor");
        radius *= scaleFactor;
    }

    @Override
    public void load(Graphics2D g2D) {
        int xAxis = (int) Math.round(center.getX());
        int yAxis = (int) Math.round(center.getY());
        int diameter = (int) Math.round(radius * 2);

        if (saveDetails == null) {
            createAndFill(g2D, xAxis, yAxis, diameter, Color.BLUE);
            return;
        }
        createAndFill(g2D, saveDetails.getxAxis(), saveDetails.getyAxis(), diameter,
                saveDetails.getFillColor() != null ? saveDetails.getFillColor() : saveDetails.getLineColour());
    }

    private void createAndFill(Graphics2D g2D, int xAxis, int yAxis, int diameter, Color c) {
        g2D.translate(xAxis, yAxis);
        g2D.setColor(c);
        g2D.drawOval(xAxis, yAxis, diameter, diameter);
        g2D.fillOval(0, 0, diameter, diameter);
        g2D.translate(-xAxis, -yAxis);
    }


    /**
     * @return The area of the circle.
     */
    public double computeArea() {
        return Math.PI * Math.pow(radius, 2);
    }

    public String toString() {
        return "Circle," + String.valueOf(center.getX()) + "," + String.valueOf(center.getY()) + "," + String.valueOf(getRadius());
    }

}
