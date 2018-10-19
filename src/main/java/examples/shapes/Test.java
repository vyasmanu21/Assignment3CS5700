package examples.shapes;
import java.io.File;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.IOException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Scanner;

public class Test {
        public static void main(String[] args) throws Exception {

            Scanner input = new Scanner(new File("/Users/manuvyas/Desktop/OOS/a.txt"));
            input.useDelimiter("-|\n");
            while(input.hasNext()) {
                System.out.println(input.next());
            }

}}
