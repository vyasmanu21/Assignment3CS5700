//import java.awt.image.BufferedImage;
//
//import java.io.File;
//import java.io.IOException;
//import javax.imageio.ImageIO;
//import javax.swing.*;
//
//public class MyImage extends JFrame {
//    public BufferedImage img;
//
//    public MyImage(String path){
//        try {
//            img = ImageIO.read(new File(path));
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//
//    public static void main(String[] args){
//
//        JFrame window = new JFrame();
//        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        window.setBounds(30, 30, 300, 300);
//        window.setVisible(true);
//        window.setSize(600, 400);
//
//        MyImage i = new MyImage("YOUR IMG PATH");
//        JPanel panel = new JPanel();
//        JLabel label = new JLabel();
//        label.setIcon(new ImageIcon(i.img));
//        panel.add(label);
//        window.add(panel);
//    }
//}
//
