package examples.shapes;

import java.io.*;
import java.util.Scanner;

public abstract class Shape {
    public abstract double computeArea() throws ShapeException;

    public abstract void move(double deltaX,double deltaY) throws ShapeException;

    public void save(String fileName)throws Exception{
        PrintWriter writer = new PrintWriter(fileName, "UTF-8");
        writer.println(this.toString());
        writer.close();
           }

    public Shape load(String fileName) throws Exception {
        String shapeDetails="";
        try
        {
            FileReader fileReader =
                    new FileReader(fileName);
            // Always wrap FileReader in BufferedReader.
            BufferedReader bufferedReader =
                    new BufferedReader(fileReader);
            shapeDetails=bufferedReader.readLine();
            // Always close files.
            bufferedReader.close();

            return ShapeFactory.create(shapeDetails);

        }catch(Exception e)
        {

        }
        return null;
    }
}
