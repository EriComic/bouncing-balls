import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Window {
    public static void main(String[] args) {
        Program program = new Program();
        program.runner();
    }
}


class Program {
    public JFrame ballWindow;
    private DrawPanel drawPanel;
    private java.util.List<leBall> ballCollection;

    public int windowWidth = 900;
    public int windowHeight = 900;
    private String windowLabel = "Collection of bouncing balls";

    void runner() {

        ballCollection = new ArrayList<>();

        /* Generate balls */
        for (int i = 0; i < 50; i++) {
            leBall ball = new leBall(
                    /* Random positions from 0 to windowWidth or windowHeight */
                    (int) Math.floor(Math.random() * windowWidth),
                    (int) Math.floor(Math.random() * windowHeight),
                    // Random size from 10 to 30 
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

            ballCollection.add(ball);
        }

        /* Initialize program */
        ballWindow = new JFrame();
        drawPanel = new DrawPanel();
        ballWindow.getContentPane().add(drawPanel);
        ballWindow.setTitle(windowLabel);
        ballWindow.setSize(windowWidth, windowHeight);
        ballWindow.setVisible(true);
        ballWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        while (true) {
            for (leBall theBallsLol: ballCollection) {
                theBallsLol.update();
            }

            /* Give Swing 10 milliseconds to see the update! */
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            ballWindow.repaint();
        }
    }

    class DrawPanel extends JPanel {
        @Override
        public void paintComponent(Graphics graphics) {
            super.paintComponent(graphics);

            for (leBall b: ballCollection) {
                b.draw(graphics);
            }
        }
    }
}
