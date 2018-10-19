import examples.shapes.*;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.*;

public class Composite extends Shape {
    private List<Shape> shapes;


    public void add(Shape s) {
        shapes.add(s);
    }

    public void remove(Shape s) {
        shapes.remove(s);
    }

    public void clear() {
        shapes.clear();
    }

    public void move(double deltaX, double deltaY) {

        try {
            for (Shape shape : shapes) {

                shape.move(deltaX, deltaY);

            }
        } catch (Exception e) {
            System.out.println("Exception occurred");
        }
    }


    public double computeArea() {
        double sum = 0;
        try {
            for (Shape shape : shapes) {
                sum += shape.computeArea();
            }
        } catch (Exception e) {
            System.out.println("Exception occurred");
        }
    return sum;
    }

}

