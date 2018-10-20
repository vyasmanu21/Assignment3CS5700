package examples.shapes;

import org.junit.Test;

import static org.junit.Assert.*;

public class SquareTest {

    public void testValidConstruction() throws ShapeException {
        Point p1 = new Point(1, 1);
        Point p2 = new Point(4, 1);
        Point p3 = new Point(4, 4);
        Point p4 = new Point(1, 4);

        Rectangle myRectangle = new Rectangle(p1, p2, p3, p4);

        assertSame(p1, myRectangle.getvertice1());
        assertSame(p2, myRectangle.getvertice2());
        assertSame(p3, myRectangle.getvertice3());
        assertSame(p4, myRectangle.getvertice4());

        p1 = new Point(1.5, 1.5);
        p2 = new Point(4.5, 1.5);
        p1 = new Point(4.5, 4.5);
        p1 = new Point(1.5, 4.5);

        myRectangle = new Rectangle(p1, p2, p3, p4);

        assertSame(p1, myRectangle.getvertice1());
        assertSame(p2, myRectangle.getvertice2());
        assertSame(p3, myRectangle.getvertice3());
        assertSame(p4, myRectangle.getvertice4());

        myRectangle = new Rectangle(1, 1, 4, 1, 4, 4, 1, 4);
        assertEquals(1, myRectangle.getvertice1().getX(), 0);
        assertEquals(1, myRectangle.getvertice1().getY(), 0);
        assertEquals(4, myRectangle.getvertice2().getX(), 0);
        assertEquals(1, myRectangle.getvertice2().getY(), 0);
        assertEquals(4, myRectangle.getvertice3().getX(), 0);
        assertEquals(4, myRectangle.getvertice3().getY(), 0);
        assertEquals(1, myRectangle.getvertice4().getX(), 0);
        assertEquals(4, myRectangle.getvertice4().getY(), 0);
    }

    @Test
    public void testInvalidConstruction() throws Exception {
        Point p1 = new Point(1, 2);
        Point p2 = new Point(4, 10);
        Point p3 = new Point(1, 2);
        Point p4 = new Point(1, 2);

        try {
            new Square(null, p1, p3, p4);
            fail("Expected exception not thrown for when the first parameter is null");
        } catch (ShapeException e) {
            assertEquals("Invalid Point", e.getMessage());
        }

        try {
            new Square(p1, null, p3, p4);
            fail("Expected exception not thrown for when the second parameter is null");
        } catch (ShapeException e) {
            assertEquals("Invalid Point", e.getMessage());
        }

        try {
            new Square(p1, p2, null, p4);
            fail("Expected exception not thrown for when the first parameter is null");
        } catch (ShapeException e) {
            assertEquals("Invalid Point", e.getMessage());
        }
        try {
            new Square(p1, p2, p3, null);
            fail("Expected exception not thrown for when the first parameter is null");
        } catch (ShapeException e) {
            assertEquals("Invalid Point", e.getMessage());
        }


        try {
            new Square(Double.POSITIVE_INFINITY, 2, 3, 4, 5, 6, 7, 8);
            fail("Expected exception not thrown");
        } catch (ShapeException e) {
            assertEquals("Invalid x-location", e.getMessage());
        }

        try {
            new Square(1, Double.POSITIVE_INFINITY, 3, 4, 5, 6, 7, 8);
            fail("Expected exception not thrown");
        } catch (Exception e) {
            assertEquals("Invalid y-location", e.getMessage());
        }

        try {
            new Square(1, 2, Double.POSITIVE_INFINITY, 4, 5, 6, 7, 8);
            fail("Expected exception not thrown");
        } catch (Exception e) {
            assertEquals("Invalid x-location", e.getMessage());
        }

        try {
            new Square(1, 2, 3, Double.POSITIVE_INFINITY, 5, 6, 7, 8);
            fail("Expected exception not thrown");
        } catch (ShapeException e) {
            assertEquals("Invalid y-location", e.getMessage());
        }

        try {
            new Square(1, 2, 3, 4, Double.POSITIVE_INFINITY, 6, 7, 8);
            fail("Expected exception not thrown");
        } catch (ShapeException e) {
            assertEquals("Invalid x-location", e.getMessage());
        }

        try {
            new Square(1, 2, 3, 4, 5, Double.POSITIVE_INFINITY, 7, 8);
            fail("Expected exception not thrown");
        } catch (ShapeException e) {
            assertEquals("Invalid y-location", e.getMessage());
        }

        try {
            new Square(1, 2, 3, 4, 5, 6, Double.POSITIVE_INFINITY, 8);
            fail("Expected exception not thrown");
        } catch (ShapeException e) {
            assertEquals("Invalid x-location", e.getMessage());
        }

        try {
            new Square(1, 2, 3, 4, 5, 6, 7, Double.POSITIVE_INFINITY);
            fail("Expected exception not thrown");
        } catch (ShapeException e) {
            assertEquals("Invalid y-location", e.getMessage());
        }


    }

    @Test
    public void testMove() throws ShapeException {
        Rectangle myRectangle = new Rectangle(1, 1, 4, 1, 4, 4, 1, 4);

        myRectangle.move(3, 3);
        assertEquals(4, myRectangle.getvertice1().getX(), 0);
        assertEquals(4, myRectangle.getvertice1().getY(), 0);
        assertEquals(7, myRectangle.getvertice2().getX(), 0);
        assertEquals(4, myRectangle.getvertice2().getY(), 0);
        assertEquals(7, myRectangle.getvertice3().getX(), 0);
        assertEquals(7, myRectangle.getvertice3().getY(), 0);
        assertEquals(4, myRectangle.getvertice4().getX(), 0);
        assertEquals(7, myRectangle.getvertice4().getY(), 0);

        myRectangle.move(.4321, .7654);
        assertEquals(4.4321, myRectangle.getvertice1().getX(), 0);
        assertEquals(4.7654, myRectangle.getvertice1().getY(), 0);
        assertEquals(7.4321, myRectangle.getvertice2().getX(), 0);
        assertEquals(4.7654, myRectangle.getvertice2().getY(), 0);
        assertEquals(7.4321, myRectangle.getvertice3().getX(), 0);
        assertEquals(7.7654, myRectangle.getvertice3().getY(), 0);
        assertEquals(4.4321, myRectangle.getvertice4().getX(), 0);
        assertEquals(7.7654, myRectangle.getvertice4().getY(), 0);

        myRectangle.move(-0.4321, -0.7654);
        assertEquals(4, myRectangle.getvertice1().getX(), 0);
        assertNotEquals(5, myRectangle.getvertice1().getY(), 0);
        assertEquals(7, myRectangle.getvertice2().getX(), 0);
        assertNotEquals(7, myRectangle.getvertice2().getY(), 0);
        assertEquals(7, myRectangle.getvertice3().getX(), 0);
        assertEquals(7, myRectangle.getvertice3().getY(), 0);
        assertEquals(4, myRectangle.getvertice4().getX(), 0);
        assertEquals(7, myRectangle.getvertice4().getY(), 0);
    }

    @Test
    public void testComputeArea() throws ShapeException {

        Rectangle myRectangle = new Rectangle(1, 1, 4, 1, 4, 4, 1, 4);
        assertEquals(9, myRectangle.computeArea(), 0.001);

    }
}