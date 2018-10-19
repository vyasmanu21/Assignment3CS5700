//
//import examples.shapes.Shape;
//
//import java.awt.image.BufferedImage;
//
//import java.io.File;
//import java.io.IOException;
//import javax.imageio.ImageIO;
//
//public class Embedded extends Shape {
//    public static void main(String args[])throws IOException
//        int width = 963;
//    int height = 640;
//    BufferedImage image = null;
//    File f = null;
//
//    try{
//        f = new File("");
//        image = new BufferedImage();
//
//
//
//
//
//
//
//}
//    private static BufferedImage map( int sizeX, int sizeY ){
//        final BufferedImage res = new BufferedImage( sizeX, sizeY, BufferedImage.TYPE_INT_RGB );
//        for (int x = 0; x < sizeX; x++){
//            for (int y = 0; y < sizeY; y++){
//                res.setRGB(x, y, Color.WHITE.getRGB() );
//            }
//        }
//        return res;
//    }
//
//    private static void savePNG( final BufferedImage bi, final String path ){
//        try {
//            RenderedImage rendImage = bi;
//            ImageIO.write(rendImage, "bmp", new File(path));
//            //ImageIO.write(rendImage, "PNG", new File(path));
//            //ImageIO.write(rendImage, "jpeg", new File(path));
//        } catch ( IOException e) {
//            e.printStackTrace();
//        }
//    }
//
//}