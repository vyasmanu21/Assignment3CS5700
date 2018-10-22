package examples.shapes;

import org.junit.Test;

import static org.junit.Assert.*;

public class EllipseTest {
    @Test
    public void testValidConstruction() throws ShapeException {
        Ellipse myEllipse = new Ellipse(4, 3.5, 5.0, 3.0);
        assertEquals(5.0, myEllipse.getRadius1(), 0);
        assertEquals(3.0, myEllipse.getRadius2(), 0);
        assertEquals(4, myEllipse.getCenter().getX(), 0);
        assertEquals(3.5, myEllipse.getCenter().getY(), 0);
        assertEquals("Ellipse,4.0,3.5,5.0,3.0", myEllipse.toString());
    }

    @Test
    public void testInvalidConstruction() throws ShapeException {
        try {
            new Ellipse(Double.POSITIVE_INFINITY, 3.5, 5, 3);
            fail("Expected exception not thrown for when the last parameter is null");
        } catch (ShapeException e) {
            assertEquals("Invalid center", e.getMessage());
        }
        try {
            new Ellipse(4, Double.POSITIVE_INFINITY, 5, 3);
            fail("Expected exception not thrown for when the last parameter is null");
        } catch (ShapeException e) {
            assertEquals("Invalid center", e.getMessage());
        }
        try {
            new Ellipse(4, 3.5, Double.NEGATIVE_INFINITY, 3);
            fail("Radius 1 and Radius 2 but be positive");
        } catch (ShapeException e) {
            assertEquals("Radius 1 and Radius 2 but be positive", e.getMessage());
        }
        try {
            new Ellipse(4, 3.5, 5, Double.NEGATIVE_INFINITY);
            fail("Radius 1 and Radius 2 but be positive");
        } catch (ShapeException e) {
            assertEquals("Radius 1 and Radius 2 but be positive", e.getMessage());
        }
    }

    @Test
    public void getCenter() throws ShapeException {
        Point center = new Point(4, 3.5);
        Point focus1 = new Point(2.5, 3.5);
        Point focus2 = new Point(5.5, 3.5);
        Ellipse myEllipse = new Ellipse(center, focus1, focus2);
        assertSame(center, myEllipse.getCenter());
        assertEquals(4, myEllipse.getCenter().getX(), 0);
        assertEquals(3.5, myEllipse.getCenter().getY(), 0);
    }

    @Test
    public void getFoci1() throws ShapeException {
        Point center = new Point(4, 3.5);
        Point foci1 = new Point(2.5, 3.5);
        Point foci2 = new Point(5.5, 3.5);
        Ellipse myEllipse = new Ellipse(center, foci1, foci2);
        assertSame(foci1, myEllipse.getFoci1());
        assertEquals(2.5, myEllipse.getFoci1().getX(), 0);
        assertEquals(3.5, myEllipse.getFoci1().getY(), 0);
    }

    @Test
    public void getFoci2() throws ShapeException {
        Point center = new Point(4, 3.5);
        Point foci1 = new Point(2.5, 3.5);
        Point foci2 = new Point(5.5, 3.5);
        Ellipse myEllipse = new Ellipse(center, foci1, foci2);
        assertSame(foci1, myEllipse.getFoci1());
        assertEquals(5.5, myEllipse.getFoci2().getX(), 0);
        assertEquals(3.5, myEllipse.getFoci2().getY(), 0);
    }

    @Test
    public void move() throws ShapeException {
        Ellipse myEllipse = new Ellipse(4, 3.5, 5, 3);
        myEllipse.move(2.5, 1.25);
        assertEquals(6.5, myEllipse.getCenter().getX(), 0);
        assertEquals(4.75, myEllipse.getCenter().getY(), 0);
    }

    @Test
    public void computeArea() throws ShapeException {
        Ellipse myEllipse = new Ellipse(4, 3.5, 5, 3);
        assertEquals(47.12, myEllipse.computeArea(), 0.01);
    }
}