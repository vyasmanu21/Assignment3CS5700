package examples.shapes;

import java.awt.*;

public class Ellipse extends AbstractShape {

    private Point foci1;
    private Point foci2;
    private Line fociLength1;
    private Line fociLength2;
    private double radius1;
    private double radius2;
    private Point center;

    public Ellipse(double x, double y, double x1, double y1, double x2, double y2, double radius1, double radius2) throws ShapeException {
        Validator.validateDouble(x, "Invalid center");
        Validator.validateDouble(y, "Invalid center");
        Point center = new Point(x, y);
        Point foci1 = new Point(x1, y1);
        Point foci2 = new Point(x2, y2);
        this.radius1 = radius1;
        this.radius2 = radius2;
        fociLength1 = new Line(center, foci1);
        fociLength2 = new Line(center, foci2);
        if (fociLength1.computeLength() != fociLength2.computeLength())
            throw new ShapeException("Focal lengths must be equal");
        if (fociLength1.computeLength() + fociLength2.computeLength() > 2 * radius1) ;
        throw new ShapeException("sum of focal distances can not be more than length of major axis");

    }
    public Ellipse(Point center, Point foci1, Point foci2) throws ShapeException
    {
        if(center == null)
            throw new ShapeException("invalid center point");
        if(foci1 == null || foci2 == null)
            throw new ShapeException("invalid focal Points");
        this.center = center;
        this.foci1 = foci1;
        this.foci2 = foci2;
    }

    public Point getFoci1() {
        return foci1;
    }

    public Point getFoci2() {
        return foci2;
    }

    public double getRadius1() {
        return radius1;
    }

    public double getRadius2() {
        return radius2;
    }

    public Point getCenter() {
        return center;
    }

    public void move(double deltaX, double deltaY) throws ShapeException {
        center.move(deltaX, deltaY);
        foci1.move(deltaX, deltaY);
        foci2.move(deltaX, deltaY);
    }

    @Override
    public void load(Graphics2D graphics) throws ShapeException {

    }

    public double computeArea()

    {
        return Math.PI * radius1 * radius2;

    }
    public String toString() {
        return "Ellipse,"+String.valueOf(foci1.getX())+","+String.valueOf(foci1.getY())+","+String.valueOf(foci2.getX()+","+String.valueOf(foci2.getY())+","+String.valueOf(fociLength1)+","+String.valueOf(fociLength2));
    }
}
