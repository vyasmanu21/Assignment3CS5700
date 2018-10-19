package examples.shapes;

import org.junit.Test;

import static org.junit.Assert.*;

public class EllipseTest {
    @Test
    public void testValidConstruction() throws ShapeException {
        Point center = new Point(4, 3.5);
        Point foci1 = new Point(2.5, 3.5);
        Point foci2 = new Point(5.5, 3.5);
        Ellipse myEllipse = new Ellipse(center, foci1, foci2, 5, 3);
        assertSame(center, myEllipse.getCenter());
        assertSame(foci1, myEllipse.getFoci1());
        assertSame(foci2, myEllipse.getFoci2());

        assertEquals(4, myEllipse.getCenter().getX(), 0);
        assertEquals(3.5, myEllipse.getCenter().getY(), 0);
        assertEquals(2.5, myEllipse.getFoci1().getX(), 0);
        assertEquals(3.5, myEllipse.getFoci1().getY(), 0);
        assertEquals(5.5, myEllipse.getFoci2().getX(), 0);
        assertEquals(3.5, myEllipse.getFoci2().getY(), 0);

    }

    @Test
    public void testInvalidConstruction() throws ShapeException {
        Point center = new Point(4, 3.5);
        Point foci1 = new Point(2.5, 3.5);
        Point foci2 = new Point(5.5, 3.5);
        try {
            new Ellipse(Double.POSITIVE_INFINITY, 3.5, 2.5, 3.5, 5.5, 3.5, 5, 3);
            fail("Expected exception not thrown for when the last parameter is null");
        } catch (ShapeException e) {
            assertEquals("Invalid x-location", e.getMessage());
        }
        try {
            new Ellipse(4, Double.POSITIVE_INFINITY, 2.5, 3.5, 5.5, 3.5, 5, 3);
            fail("Expected exception not thrown for when the last parameter is null");
        } catch (ShapeException e) {
            assertEquals("Invalid y-location", e.getMessage());
        }
        try {
            new Ellipse(4, 3.5, Double.POSITIVE_INFINITY, 3.5, 5.5, 3.5, 5, 3);
            fail("Expected exception not thrown for when the last parameter is null");
        } catch (ShapeException e) {
            assertEquals("Invalid x-location", e.getMessage());
        }
        try {
            new Ellipse(4, 3.5, 2.5, Double.POSITIVE_INFINITY, 5.5, 3.5, 5, 3);
            fail("Expected exception not thrown for when the last parameter is null");
        } catch (ShapeException e) {
            assertEquals("Invalid y-location", e.getMessage());
        }
        try {
            new Ellipse(4, 3.5, 2.5, 3.5, Double.POSITIVE_INFINITY, 3.5, 5, 3);
            fail("Expected exception not thrown for when the last parameter is null");
        } catch (ShapeException e) {
            assertEquals("Invalid x-location", e.getMessage());
        }
        try {
            new Ellipse(4, 3.5, 2.5, 3.5, 5.5, Double.POSITIVE_INFINITY, 5, 3);
            fail("Expected exception not thrown for when the last parameter is null");
        } catch (ShapeException e) {
            assertEquals("Invalid y-location", e.getMessage());
        }
        try {
            new Ellipse(4, 3.5, 2.5, 3.5, 5.5, 3.5, Double.POSITIVE_INFINITY, 3);
            fail("Expected exception not thrown for when the last parameter is null");
        } catch (ShapeException e) {
            assertEquals("Invalid Major-axis", e.getMessage());
        }
        try {
            new Ellipse(4, 3.5, 2.5, 3.5, 5.5, 3.5, 5, Double.POSITIVE_INFINITY);
            fail("Expected exception not thrown for when the last parameter is null");
        } catch (ShapeException e) {
            assertEquals("Invalid Minor-axis", e.getMessage());
        }
        }
  //    try {
    //        Point center1 = new Point(4, 3.5);
    //        Point focus3 = new Point(2.5, 3);
    //        Point focus4 = new Point(5.5, 3.5);
     //       new Ellipse(center1, foci3, foci4, 3, 3);
     //   } catch (ShapeException e) {
    //        assertEquals("Invalid Focal distance", e.getMessage());
    //    }
  //  }

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

//    @Test
//    public void getMajorAxis() throws ShapeException {
//        Ellipse myEllipse = new Ellipse(4, 3.5, 2.5, 3.5, 5.5, 3.5, 5, 3);
//        assertEquals(5, myEllipse.getMajorAxis(), 0);
//    }
//
//    @Test
//    public void getMinorAxis() throws ShapeException {
//        Ellipse myEllipse = new Ellipse(4, 3.5, 2.5, 3.5, 5.5, 3.5, 5, 3);
//        assertEquals(3, myEllipse.getMinorAxis(), 0);
//    }

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
        Ellipse myEllipse = new Ellipse(4, 3.5, 2.5, 3.5, 5.5, 3.5, 5, 3);
        myEllipse.move(2.5, 1.25);
        assertEquals(6.5, myEllipse.getCenter().getX(), 0);
        assertEquals(4.75, myEllipse.getCenter().getY(), 0);
        assertEquals(5, myEllipse.getFoci1().getX(), 0);
        assertEquals(4.75, myEllipse.getFoci1().getY(), 0);
        assertEquals(8, myEllipse.getFoci2().getX(), 0);
        assertEquals(4.75, myEllipse.getFoci2().getY(), 0);
    }

    @Test
    public void computeArea() throws ShapeException {
        Ellipse myEllipse = new Ellipse(4, 3.5, 2.5, 3.5, 5.5, 3.5, 5, 3);
        assertEquals(11.781, myEllipse.computeArea(), 0.0001);
    }
}