package examples.shapes;

import java.awt.*;

public class Square extends AbstractShape {

    private Rectangle r1;

    public Square(double x1, double y1, double x2, double y2, double x3, double y3, double x4, double y4) throws ShapeException {

        r1 = new Rectangle(x1, y1, x2, y2, x3, y3, x4, y4);

        if (!(r1.getlength() == r1.getwidth()))
            throw new ShapeException("All side must be equal");
    }

    public Square(Point vertice1, Point vertice2, Point vertice3, Point vertice4) throws ShapeException {

        r1 = new Rectangle(vertice1, vertice2, vertice3, vertice4);
        if (!(r1.getlength() == r1.getwidth()))
            throw new ShapeException("All side must be equal");
    }

    /**
     * Move a Square
     *
     * @param deltaX The delta x-location by which the Square should be moved -- must be a valid double
     * @param deltaY The delta y-location by which the Square should be moved -- must be a valid double
     * @throws ShapeException Exception throw if any parameter is invalid
     */
    public void move(double deltaX, double deltaY) throws ShapeException {
        r1.getvertice1().move(deltaX, deltaY);
        r1.getvertice2().move(deltaX, deltaY);
        r1.getvertice3().move(deltaX, deltaY);
        r1.getvertice4().move(deltaX, deltaY);
    }


    public Point getvertice1() {
        return r1.getvertice1();
    }

    public Point getvertice2() {
        return r1.getvertice2();
    }

    public Point getvertice3() {
        return r1.getvertice3();
    }

    public Point getvertice4() {
        return r1.getvertice4();
    }


    @Override
    public void load(Graphics2D g2D) {
        int xAxis = (int) r1.getvertice1().getX();
        int yAxis = (int) r1.getvertice1().getY();

        if (saveDetails == null) {
            g2D.translate(xAxis, yAxis);
            g2D.setColor(Color.BLUE);
            g2D.drawRect(xAxis, yAxis, (int) r1.getwidth(), (int) r1.getlength());
            g2D.translate(-xAxis, -yAxis);
            return;
        }
        g2D.translate(saveDetails.getxAxis(), saveDetails.getyAxis());
        g2D.setColor(saveDetails.getLineColour());
        g2D.drawRect((int) r1.getvertice1().getX(), (int) r1.getvertice1().getY(), (int) r1.getwidth(), (int) r1.getlength());
        if (saveDetails.getFillColor() != null) {
            g2D.setColor(saveDetails.getFillColor());
            g2D.fillRect((int) r1.getvertice1().getX(), (int) r1.getvertice1().getY(), (int) r1.getwidth(), (int) r1.getlength());
        }
    }

    /**
     * @return The area of the Square.
     */

    public double computeArea() {
        return r1.getlength() * r1.getwidth();

    }

    public String toString() {
        return "Square," + String.valueOf(r1.getvertice1()) + "," + String.valueOf(r1.getvertice2()) + "," + String.valueOf(r1.getvertice3() + "," + String.valueOf(r1.getvertice4()));
    }
}

