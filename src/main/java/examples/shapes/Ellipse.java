package examples.shapes;

import java.awt.*;

public class Ellipse extends AbstractShape {
    private Point foci1;
    private Point foci2;
    private double radius1;
    private double radius2;
    private Point center;

    /**
     * @param x       of the center
     * @param y       of the center
     * @param radius1 of the ellipse
     * @param radius2 of the ellipse
     * @throws ShapeException
     */
    public Ellipse(double x, double y, double radius1, double radius2) throws ShapeException {
        Validator.validateDouble(x, "Invalid center");
        Validator.validateDouble(y, "Invalid center");
        if (radius1 < 0 || radius2 < 0) {
            throw new ShapeException("Radius 1 and Radius 2 but be positive");
        }
        center = new Point(x, y);
        this.radius1 = radius1;
        this.radius2 = radius2;


    }

    /**
     * @param center of the ellipse
     * @param foci1
     * @param foci2
     * @throws ShapeException
     */
    public Ellipse(Point center, Point foci1, Point foci2) throws ShapeException {
        if (center == null)
            throw new ShapeException("invalid center point");
        if (foci1 == null || foci2 == null)
            throw new ShapeException("invalid focal Points");
        this.center = center;
        this.foci1 = foci1;
        this.foci2 = foci2;
    }

    /**
     * @return
     */
    public Point getFoci1() {
        return foci1;
    }

    /**
     * @return
     */
    public Point getFoci2() {
        return foci2;
    }

    /**
     * @return
     */
    public Point getCenter() {
        return center;
    }

    /**
     * Get the radius 1 of the ellipse
     *
     * @return
     */
    public double getRadius1() {
        return radius1;
    }

    /**
     * Get the radius 2 of the ellipse
     *
     * @return
     */
    public double getRadius2() {
        return radius2;
    }

    /**
     * @param deltaX
     * @param deltaY
     * @throws ShapeException
     */
    public void move(double deltaX, double deltaY) throws ShapeException {
        center.moveX(deltaX);
        center.moveY(deltaY);
    }

    @Override
    public void load(Graphics2D g2D) {
        int xAxis = (int) Math.round(center.getX() - radius1);
        int yAxis = (int) Math.round(center.getY() - radius1);
        int diameter1 = (int) Math.round(radius1 * 2);
        int diameter2 = (int) Math.round(radius1 * 2);
        if (saveDetails == null) {
            createAndFill(g2D, xAxis, yAxis, diameter1, diameter2, Color.BLUE);
            return;

        }
        createAndFill(g2D, saveDetails.getxAxis(), saveDetails.getyAxis(), diameter1, diameter2,
                saveDetails.getFillColor() != null ? saveDetails.getFillColor() : saveDetails.getLineColour());
    }

    private void createAndFill(Graphics2D g2D, int xAxis, int yAxis, int diameter1, int diameter2, Color c) {
        g2D.translate(xAxis, yAxis);
        g2D.setColor(c);
        g2D.drawOval(xAxis, yAxis, diameter1, diameter2);
        g2D.fillOval(0, 0, diameter1, diameter2);
        g2D.translate(-xAxis, -yAxis);
    }

    /**
     * The area of the ellipse
     *
     * @return
     */
    public double computeArea() {
        return Math.PI * radius1 * radius2;

    }

    /**
     * The string interpretation of the ellipse in the form "Ellipse,<center x-axis></center>,<center y-axis></center>,<radius1></radius1>,<radius2
     * "
     *
     * @return
     */
    public String toString() {
        return "Ellipse," + String.valueOf(center.getX()) + "," + String.valueOf(center.getY()) + "," + radius1 + "," + radius2;
    }
}
