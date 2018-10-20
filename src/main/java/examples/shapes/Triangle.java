package examples.shapes;


import java.awt.*;

@SuppressWarnings("WeakerAccess")
public class Triangle extends AbstractShape {

    private Point vertice1;
    private Point vertice2;
    private Point vertice3;
    private Line line1;
    private Line line2;
    private Line line3;



    public Triangle(double x1, double y1, double x2, double y2,double x3,double y3) throws ShapeException {
        vertice1 = new Point(x1, y1);
        vertice2 = new Point(x2, y2);
        vertice3 = new Point(x3, y3);
        line1 = new Line(vertice1,vertice2);
        line2 = new Line(vertice2,vertice3);
        line3 = new Line(vertice3,vertice1);

        if (line1.computeSlope() == line2.computeSlope())
            throw new ShapeException("All vertice cannot be in same line");
        if (line1.computeLength()>line2.computeLength()+line3.computeLength())
            throw new ShapeException("Lenght of edge cannot be greater than other two");
        if (line2.computeLength()>line1.computeLength()+line3.computeLength())
            throw new ShapeException("Lenght of edge cannot be greater than other two");
        if (line3.computeLength()>line2.computeLength()+line1.computeLength())
            throw new ShapeException("Lenght of edge cannot be greater than other two");
    }


    public Triangle(Point vertice1, Point vertice2,Point vertice3) throws ShapeException {
        if (vertice1==null || vertice2==null || vertice3==null)
            throw new ShapeException("Invalid Point");

        this.vertice1 = vertice1;
        this.vertice2 = vertice2;
        this.vertice3 = vertice3;
        line1 = new Line(vertice1,vertice2);
        line2 = new Line(vertice2,vertice3);
        line3 = new Line(vertice3,vertice1);


        if (line1.computeSlope() == line2.computeSlope())
            throw new ShapeException("All vertice cannot be in same line");
        if (line1.computeLength()>line2.computeLength()+line3.computeLength())
            throw new ShapeException("Lenght of edge cannot be greater than other two");
        if (line2.computeLength()>line1.computeLength()+line3.computeLength())
            throw new ShapeException("Lenght of edge cannot be greater than other two");
        if (line3.computeLength()>line2.computeLength()+line1.computeLength())
            throw new ShapeException("Lenght of edge cannot be greater than other two");
    }


    public Point getPoint1() { return vertice1; }

    public Point getPoint2() { return vertice2; }

    public Point getPoint3() { return vertice3; }


    public void move(double deltaX, double deltaY) throws ShapeException {
        vertice1.move(deltaX, deltaY);
        vertice2.move(deltaX, deltaY);
        vertice3.move(deltaX, deltaY);
    }


    @Override
    public void load(Graphics2D graphics) throws ShapeException {

    }

    public double computeArea() {
        double s;
        s = getperimeter()/2;
        return Math.sqrt(s * (s-line1.computeLength()) * (s-line2.computeLength()) * (s-line3.computeLength()));
    }

        public double getperimeter(){
        double perimeter;
            perimeter = line1.computeLength()+line2.computeLength()+line3.computeLength();
            return perimeter;
        }

    public String toString() {
        return "Triangle,"+String.valueOf(vertice1.getX())+","+String.valueOf(vertice1.getY())+","+String.valueOf(vertice2.getX()+","+String.valueOf(vertice2.getY())+","+String.valueOf(vertice3.getX())+","+String.valueOf(vertice3.getY()));
    }
        
 }

