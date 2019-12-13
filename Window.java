import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Window {
    public static void main(String[] args) {
        BouncingBalls mainClass = new BouncingBalls();
        mainClass.mainClass();
    }
}

class BouncingBalls {
    public JFrame ballWindow;
    private DrawPanel drawPanel;
    private java.util.List<leBall> ballCollection;

    public int windowWidth = 800;
    public int windowHeight = 600;

    void mainClass() {

        ballCollection = new ArrayList<>();

        // Generates 45 balls with randomized characteristics and adds them to an ArrayList
        for (int i = 0; i < 45; i++) {
            leBall ball = new leBall(
                    /* Random positions from 0 to windowWidth or windowHeight */
                    (int) Math.floor(Math.random() * windowWidth),
                    (int) Math.floor(Math.random() * windowHeight),
                    // Size randomization from 10 to 50
                    (int) Math.floor(Math.random() * 40) + 10,
                    // Random colors using RGB
                    new Color(
                        (int) Math.floor((Math.random() * 256)),
                        (int) Math.floor((Math.random() * 256)),
                        (int) Math.floor((Math.random() * 256))
                    ),
                    // Random velocities from -10 to 10 
                    Math.floor((Math.random() * 20) - 10),
                    Math.floor((Math.random() * 20) - 10),
                    (windowHeight),
                    (windowWidth) 
            );
            ballCollection.add(ball);
        }

        // Start JFrame and initialize basic parameters
        ballWindow = new JFrame();
        drawPanel = new DrawPanel();
        ballWindow.getContentPane().add(drawPanel);
        ballWindow.setTitle("Buncha' balls");
        ballWindow.setSize(windowWidth, windowHeight);
        ballWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ballWindow.setVisible(true);


        //Updating ball position
        while (true) {
            for (leBall theBallsLol: ballCollection) {
                theBallsLol.update();
            }

            //Determines visual update speed
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            ballWindow.repaint();
        }
    }

    //Introduces graphics and calls the draw method from leBall.java. Draws all ball in ArrayList
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