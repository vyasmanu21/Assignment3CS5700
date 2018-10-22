package examples.shapes;

import java.awt.*;

/**
 * Line
 * <p>
 * This class represents line objects that can be moved.  Users of a line can also get its length and slope.
 */
@SuppressWarnings("WeakerAccess")
public class Line extends AbstractShape {

    private Point point1;
    private Point point2;

    /**
     * Constructor based on x-y Locations
     *
     * @param x1 The x-location of first point -- must be a valid double.
     * @param y1 The y-location of first point -- must be a valid double.
     * @param x2 The x-location of second point -- must be a valid double.
     * @param y2 The y-location of second point -- must be a valid double.
     * @throws ShapeException Exception throw if any parameter is invalid
     */
    public Line(double x1, double y1, double x2, double y2) throws ShapeException {
        point1 = new Point(x1, y1);
        point2 = new Point(x2, y2);

        if (computeLength() < 0.00000001)
            throw new ShapeException("A line must have a length > 0");
    }

    /**
     * @param point1 The first point -- must not be null
     * @param point2 The second point -- must not b e null
     * @throws ShapeException Exception throw if any parameter is invalid
     */
    public  Line(Point point1, Point point2) throws ShapeException {
        if (point1 == null || point2 == null)
            throw new ShapeException("Invalid Point");

        this.point1 = point1;
        this.point2 = point2;

        if (computeLength() < 0.00000001)
            throw new ShapeException("A line must have a length > 0");
    }

    /**
     * @return The first point
     */
    public Point getPoint1() {
        return point1;
    }

    /**
     * @return The second point
     */
    public Point getPoint2() {
        return point2;
    }

    @Override
    public void load(Graphics2D g2d) {
        int xAxisPoint1 = (int) point1.getX();
        int yAxisPoint1 = (int) point1.getY();
        int xAxisPoint2 = (int) point2.getX();
        int yAxisPoint2 = (int) point2.getY();

        if (saveDetails == null) {
            createAndFill(g2d, xAxisPoint1, yAxisPoint1, xAxisPoint2, yAxisPoint2, Color.BLUE);
            return;
        }
        createAndFill(g2d, saveDetails.getxAxis(), saveDetails.getyAxis(), xAxisPoint2, yAxisPoint2, Color.BLUE);

        g2d.translate(saveDetails.getxAxis(), saveDetails.getyAxis());

        g2d.setColor(saveDetails.getLineColour());
        g2d.drawLine((int) getPoint1().getX(), (int) getPoint1().getY(), (int) getPoint2().getX(), (int) getPoint2().getY());

        g2d.translate(-saveDetails.getxAxis(), -saveDetails.getyAxis());

    }

    private void createAndFill(Graphics2D g2D, int xAxisPoint1, int yAxisPoint1, int xAxisPoint2, int yAxisPoint2, Color c) {
        g2D.translate(xAxisPoint1, yAxisPoint1);
        g2D.setColor(c);
        g2D.drawLine(xAxisPoint1, yAxisPoint1, xAxisPoint2, yAxisPoint2);
        g2D.translate(-xAxisPoint1, -yAxisPoint1);
    }

    @Override
    public double computeArea() {
        return 0;
    }

    /**
     * Move a line
     *
     * @param deltaX The delta x-location by which the line should be moved -- must be a valid double
     * @param deltaY The delta y-location by which the line should be moved -- must be a valid double
     * @throws ShapeException Exception throw if any parameter is invalid
     */
    public void move(double deltaX, double deltaY) throws ShapeException {
        point1.move(deltaX, deltaY);
        point2.move(deltaX, deltaY);
    }


    /**
     * @return The length of the line
     */
    public double computeLength() {
        return Math.sqrt(Math.pow(point2.getX() - point1.getX(), 2) +
                Math.pow(point2.getY() - point1.getY(), 2));
    }

    /**
     * @return The slope of the line
     */
    public double computeSlope() {
        return (point2.getY() - point1.getY()) / (point2.getX() - point1.getX());
    }

    public String toString() {
        return "Line," + String.valueOf(point1.getX()) + "," + String.valueOf(point1.getY()) + "," + String.valueOf(point2.getX() + "," + String.valueOf(point2.getY()));
    }
}
