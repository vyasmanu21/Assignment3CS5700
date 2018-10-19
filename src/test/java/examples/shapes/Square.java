package examples.shapes;

public class Square {
    private Point vertice1;
    private Point vertice2;
    private Point vertice3;
    private Point vertice4;
    private Line line1;
    private Line line2;
    private Line line3;
    private Line line4;

    public Square(double x1, double y1, double x2, double y2, double x3, double y3, double x4, double y4) throws ShapeException {

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

        if (line1.computeLength() != line2.computeLength() || line3.computeLength() != line4.computeLength() || line3.computeLength() != line2.computeLength())
            throw new ShapeException("All side must be equal");
    }

    public Square(Point vertice1, Point vertice2, Point vertice3, Point vertice4) throws ShapeException {
        if (vertice1 == null || vertice2 == null || vertice3 == null || vertice4 == null)
            throw new ShapeException("Invalid Point");

        this.vertice1 = vertice1;
        this.vertice2 = vertice2;
        this.vertice3 = vertice3;
        this.vertice4 = vertice4;

        if (line1.computeLength() < 0.00000001 || line2.computeLength() < 0.00000001 || line3.computeLength() < 0.00000001 || line4.computeLength() < 0.00000001)
            throw new ShapeException("All edge must have a length > 0");

        if (line1.computeSlope() * line2.computeSlope() == -1 || line2.computeSlope() * line3.computeSlope() == -1 || line3.computeSlope() * line4.computeSlope() == -1 || line4.computeSlope() * line1.computeSlope() == -1)
            throw new ShapeException("Two adjacent edge must form right angle");

        if (line1.computeLength() != line2.computeLength() || line3.computeLength() != line4.computeLength() || line3.computeLength() != line2.computeLength())
            throw new ShapeException("All side must be equal");
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
     * @return The Second vertice
     */

    public Point getvertice2() {
        return vertice2;
    }


    /**
     * @return The Third vertice
     */

    public Point getvertice3() {
        return vertice3;
    }


    /**
     * @return The Fourth vertice
     */

    public Point getvertice4() {
        return vertice4;
    }


    /**
     * @return The area of the Square.
     */

    public double computeArea() {
        return line1.computeLength() * line1.computeLength();

    }
}
