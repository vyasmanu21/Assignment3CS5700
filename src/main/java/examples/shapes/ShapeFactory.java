package examples.shapes;

public class ShapeFactory {

    public static AbstractShape create(String shapeDetails) throws ShapeException {
        String[] splits = shapeDetails.split(",");
        String shapeName = splits[0];
        switch (shapeName) {
            case "Circle": {
                double x = Double.parseDouble(splits[1]);
                double y = Double.parseDouble(splits[2]);
                double radius = Double.parseDouble(splits[3]);
                return new Circle(x, y, radius);
            }
            case "Line": {
                double x = Double.parseDouble(splits[1]);
                double y = Double.parseDouble(splits[2]);
                double radius = Double.parseDouble(splits[3]);
                return new Circle(x, y, radius);
            }
            case "Rectangle":{
                double x1 = Double.parseDouble(splits[1]);
                double y1 = Double.parseDouble(splits[2]);
                double x2 = Double.parseDouble(splits[3]);
                double y2 = Double.parseDouble(splits[4]);
                double x3 = Double.parseDouble(splits[5]);
                double y3 = Double.parseDouble(splits[6]);
                double x4 = Double.parseDouble(splits[7]);
                double y4 = Double.parseDouble(splits[8]);
                return new Rectangle(x1, y1, x2, y2, x3, y3, x4, y4);
            }

        }
        if (shapeName.equals("Circle")) {
            double x = Double.parseDouble(splits[1]);
            double y = Double.parseDouble(splits[2]);
            double radius = Double.parseDouble(splits[3]);
            return new Circle(x, y, radius);
        } else if (shapeName.equals("Line")) {
            double x1 = Double.parseDouble(splits[1]);
            double y1 = Double.parseDouble(splits[2]);
            double x2 = Double.parseDouble(splits[3]);
            double y2 = Double.parseDouble(splits[4]);
            return new Line(x1, y1, x2, y2);
        } else if (shapeName.equals("Rectangle")) {
            double x1 = Double.parseDouble(splits[1]);
            double y1 = Double.parseDouble(splits[2]);
            double x2 = Double.parseDouble(splits[3]);
            double y2 = Double.parseDouble(splits[4]);
            double x3 = Double.parseDouble(splits[5]);
            double y3 = Double.parseDouble(splits[6]);
            double x4 = Double.parseDouble(splits[7]);
            double y4 = Double.parseDouble(splits[8]);
            return new Rectangle(x1, y1, x2, y2, x3, y3, x4, y4);
        } else if (shapeName.equals("Point")) {
            double x = Double.parseDouble(splits[1]);
            double y = Double.parseDouble(splits[2]);
            return new Point(x, y);
        } else if (shapeName.equals("Triangle")) {
            double x1 = Double.parseDouble(splits[1]);
            double y1 = Double.parseDouble(splits[2]);
            double x2 = Double.parseDouble(splits[3]);
            double y2 = Double.parseDouble(splits[4]);
            double x3 = Double.parseDouble(splits[5]);
            double y3 = Double.parseDouble(splits[6]);
            return new Triangle(x1, y1, x2, y2, x3, y3);
        }
        if (shapeName.equals("Circle")) {
            double x = Double.parseDouble(splits[1]);
            double y = Double.parseDouble(splits[2]);
            double radius = Double.parseDouble(splits[3]);
            return new Circle(x, y, radius);
        }

        return null;
    }

}
