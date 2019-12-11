import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Window {
    public static void main(String[] args) {
        Program program = new Program();
        program.run();
    }
}


class Program {
    public JFrame mainFrame;
    private DrawPanel drawPanel;
    private java.util.List<leBall> balls;

    public int windowWidth = 960;
    public int windowHeight = 550;
    private String windowLabel = "Bounce Program";

    void run() {

        balls = new ArrayList<>();

        /* Generate balls */
        for (int i = 0; i < 50; i++) {
            leBall ball = new leBall(
                    /* Random positions from 0 to windowWidth or windowHeight */
                    (int) Math.floor(Math.random() * windowWidth),
                    (int) Math.floor(Math.random() * windowHeight),
                    /* Random size from 10 to 30 */
                    (int) Math.floor(Math.random() * 20) + 10,
                    /* Random RGB colors*/
                    new Color(
                        (int) Math.floor((Math.random() * 256)),
                        (int) Math.floor((Math.random() * 256)),
                        (int) Math.floor((Math.random() * 256))
                    ),
                    // Random velocities from -5 to 5 
                    Math.floor((Math.random() * 10) - 5),
                    Math.floor((Math.random() * 10) - 5),
                    (windowHeight),
                    (windowWidth) 
            );

            balls.add(ball);
        }

        /* Initialize program */
        mainFrame = new JFrame();
        drawPanel = new DrawPanel();
        mainFrame.getContentPane().add(drawPanel);
        mainFrame.setTitle(windowLabel);
        mainFrame.setSize(windowWidth, windowHeight);
        mainFrame.setVisible(true);
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        while (true) {
            for (leBall b: balls) {
                b.update();
            }

            /* Give Swing 10 milliseconds to see the update! */
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            mainFrame.repaint();
        }
    }

    class DrawPanel extends JPanel {
        @Override
        public void paintComponent(Graphics graphics) {
            super.paintComponent(graphics);

            for (leBall b: balls) {
                b.draw(graphics);
            }
        }
    }
}
