package examples.shapes;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Runner {
    public static void main(String args[]) {
        ArrayList shapes = new ArrayList<>();

        try {
            Circle circle = new Circle(new Point(0, 1), 5);
            shapes.add(circle);

            Ellipse ellipse = new Ellipse(0, 1, 5, 3);
            shapes.add(ellipse);

            Triangle triangle = new Triangle(new Point(0, 0), new Point(1, 0), new Point(0, 1));
            shapes.add(triangle);

            Rectangle rectangle = new Rectangle(new Point(0, 1), new Point(1, 1), new Point(0, 0), new Point(1, 0));
            shapes.add(rectangle);

            Square square = new Square(new Point(0, 1), new Point(1, 1), new Point(1, 0), new Point(0, 0));
            shapes.add(square);

            Line line = new Line(new Point(0, 1), new Point(1, 1));
            shapes.add(line);

            EmbeddedPicture ePicture = new EmbeddedPicture("usu`.jpg");
            shapes.add(ePicture);

            testRender();

        } catch (Exception e) {
            e.printStackTrace();
        }
        writeAllShapesToFile(shapes, "shapes.txt");
        List<Shape> allShapes = readShapesFromFile("shapes.txt");
        for (Shape s : allShapes) {
            System.out.println(s);
        }
        System.out.println("Done");
    }

    public static void writeAllShapesToFile(List<Shape> shapeList, String shapeFileName) {
        OutputStream outputStream = null;
        File shapeFile;

        try {
            shapeFile = new File(shapeFileName);
            if (!shapeFile.exists()) {
                shapeFile.createNewFile();
            }
            outputStream = new FileOutputStream(shapeFile);

            for (Shape shape : shapeList) {
                outputStream.write(shape.toString().getBytes());
                outputStream.write("\n".getBytes());
            }
            outputStream.flush();
            outputStream.close();
            outputStream = null;

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (outputStream != null) {
                    outputStream.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static List<Shape> readShapesFromFile(String shapeFileName) {
        List<Shape> shapeList = new ArrayList<>();
        try {
            BufferedReader br = new BufferedReader(new FileReader(shapeFileName));
            String stringShape;
            while ((stringShape = br.readLine()) != null) {
                shapeList.add(ShapeFactory.create(stringShape));
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return shapeList;
    }

    public static void testRender() throws ShapeException, IOException {
        Circle circle = new Circle(30, 30, 10);
        Rectangle rectangle = new Rectangle(new Point(50, 50), new Point(20, 50), new Point(50, 20), new Point(20, 20));
        Triangle triangle = new Triangle(new Point(0, 0), new Point(10, 0), new Point(0, 10));
        Line line = new Line(new Point(0, 30), new Point(30, 30));

        SaveDetails sd1 = new SaveDetails();
        sd1.setLineColour(Color.BLACK);
        sd1.setFillColor(Color.WHITE);

        SaveDetails sd2 = new SaveDetails();
        sd2.setLineColour(Color.WHITE);
        sd2.setFillColor(Color.RED);
        sd2.setxAxis(30);
        sd2.setyAxis(60);

        SaveDetails sd3 = new SaveDetails();
        sd3.setLineColour(Color.BLACK);
        sd3.setFillColor(Color.BLUE);

        SaveDetails sd4 = new SaveDetails();
        sd4.setLineColour(Color.BLUE);
        sd4.setFillColor(Color.YELLOW);

        SaveDetails sd5 = new SaveDetails();
        sd5.setxAxis(0);
        sd5.setyAxis(100);

        Composite composite = new Composite();
        rectangle.setSaveDetails(sd1);
        composite.add(rectangle);

        circle.setSaveDetails(sd2);
        composite.add(circle);

        triangle.setSaveDetails(sd3);
        composite.add(triangle);

        line.setSaveDetails(sd4);
        composite.add(line);

        BufferedImage bImg = new BufferedImage(500, 500, BufferedImage.TYPE_INT_RGB);
        Graphics2D g2D = bImg.createGraphics();

        EmbeddedPicture ePicture = new EmbeddedPicture("./usu.jpg");
        ePicture.setSaveDetails(sd5);
        ePicture.load(g2D);
        composite.add(ePicture);

        composite.setSaveDetails(sd1);
        composite.load(g2D);

        ImageIO.write(bImg, "png", new File("composite.jpg"));
    }
}
