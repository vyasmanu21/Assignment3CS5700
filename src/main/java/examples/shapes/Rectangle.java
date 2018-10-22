package examples.shapes;

import java.awt.*;

public class Rectangle extends AbstractShape {

    private Point vertice1;
    private Point vertice2;
    private Point vertice3;
    private Point vertice4;
    private Line line1;
    private Line line2;
    private Line line3;
    private Line line4;

    public Rectangle(double x1, double y1, double x2, double y2, double x3, double y3, double x4, double y4) throws ShapeException {

        vertice1 = new Point(x1, y1);
        vertice2 = new Point(x2, y2);
        vertice3 = new Point(x3, y3);
        vertice4 = new Point(x4, y4);
        line1 = new Line(vertice1, vertice2);
        line2 = new Line(vertice2, vertice3);
        line3 = new Line(vertice3, vertice4);
        line4 = new Line(vertice4, vertice1);

        if (line1.computeLength() < 0.00000001 || line2.computeLength() < 0.00000001 || line3.computeLength() < 0.00000001 || line4.computeLength() < 0.00000001)
            throw new ShapeException("All edge must have a length > 0");
        if (line1.computeSlope() * line2.computeSlope() == -1 || line2.computeSlope() * line3.computeSlope() == -1 || line3.computeSlope() * line4.computeSlope() == -1 || line4.computeSlope() * line1.computeSlope() == -1)
            throw new ShapeException("Two adjacent edge must form right angle");

    }

    public Rectangle(Point vertice1, Point vertice2, Point vertice3, Point vertice4) throws ShapeException {
        if (vertice1 == null || vertice2 == null || vertice3 == null || vertice4 == null)
            throw new ShapeException("Invalid Point");

        this.vertice1 = vertice1;
        this.vertice2 = vertice2;
        this.vertice3 = vertice3;
        this.vertice4 = vertice4;
        line1 = new Line(vertice1, vertice2);
        line2 = new Line(vertice2, vertice3);
        line3 = new Line(vertice3, vertice4);
        line4 = new Line(vertice4, vertice1);
        if (line1.computeLength() < 0.00000001 || line2.computeLength() < 0.00000001 || line3.computeLength() < 0.00000001 || line4.computeLength() < 0.00000001)
            throw new ShapeException("All edge must have a length > 0");

        if (line1.computeSlope() * line2.computeSlope() == -1 || line2.computeSlope() * line3.computeSlope() == -1 || line3.computeSlope() * line4.computeSlope() == -1 || line4.computeSlope() * line1.computeSlope() == -1)
            throw new ShapeException("Two adjacent edge must form right angle");
    }

    public void move(double deltaX, double deltaY) throws ShapeException {
        vertice1.move(deltaX, deltaY);
        vertice2.move(deltaX, deltaY);
        vertice3.move(deltaX, deltaY);
        vertice4.move(deltaX, deltaY);
    }


    /**
     * @return The first vertice
     */

    public Point getvertice1() {
        return vertice1;
    }

    /**
     * @return The second vertice
     */

    public Point getvertice2() {
        return vertice2;
    }

    /**
     * @return The third vertice
     */

    public Point getvertice3() {
        return vertice3;
    }

    /**
     * @return The fourth vertice
     */

    public Point getvertice4() {
        return vertice4;
    }

    /**
     * @return The Lenght
     */

    public double getlength() {
        return line1.computeLength();
    }

    /**
     * @return The Width
     */

    public double getwidth() {
        return line2.computeLength();
    }


    @Override
    public void load(Graphics2D g2D) {
        int xAxis = (int) vertice1.getX();
        int yAxis = (int) vertice1.getY();

        if (saveDetails == null) {
            g2D.translate(xAxis, yAxis);
            g2D.setColor(Color.BLUE);
            g2D.drawRect(xAxis, yAxis, (int) getwidth(), (int) getlength());
            g2D.translate(-xAxis, -yAxis);
            return;
        }
        g2D.translate(saveDetails.getxAxis(), saveDetails.getyAxis());
        g2D.setColor(saveDetails.getLineColour());
        g2D.drawRect((int) vertice1.getX(), (int) vertice1.getY(), (int) getwidth(), (int) getlength());
        if (saveDetails.getFillColor() != null) {
            g2D.setColor(saveDetails.getFillColor());
            g2D.fillRect((int) vertice1.getX(), (int) vertice1.getY(), (int) getwidth(), (int) getlength());
        }
        g2D.translate(-saveDetails.getxAxis(), -saveDetails.getyAxis());
    }

    /**
     * @return The area of the rectangle.
     */

    public double computeArea() {
        return line1.computeLength() * line2.computeLength();
    }

    public String toString() {
        return "Rectangle," + String.valueOf(vertice1.getX()) + "," + String.valueOf(vertice1.getY()) + "," + String.valueOf(vertice2.getX()) + "," + String.valueOf(vertice2.getY()) + "," + String.valueOf(vertice3.getX()) + "," + String.valueOf(vertice3.getY()) + "," + String.valueOf(vertice4.getX()) + "," + String.valueOf(vertice4.getY());
    }

}




