import java.awt.*;
import java.util.Random;
import javax.swing.*;

public class Window extends JPanel {
    int Number_Ball=5;
    int x,y;
    Graphics g;
    Window(){
        Random r = new Random();
        x=r.nextInt(320);
        y=r.nextInt(550);
    }
public static JFrame frame;
    public static void main(String[] args) {
        Window a= new Window();
        frame= new JFrame("Bouncing Balls");
        frame.setSize(400,600);
        frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.add(a);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for(int i=0;i<Number_Ball;i++){
            g.fillOval(x, y, 30, 30);
        }
        repaint();
    }

}