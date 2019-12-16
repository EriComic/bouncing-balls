import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Window {
    public static void main(String[] args) {
        BouncingBalls mainClass = new BouncingBalls();
        mainClass.start();
    }
}

class BouncingBalls {
    public JFrame ballWindow;
    private DrawPanel drawPanel;
    private java.util.List<leBall> ballCollection;

    void start() {

        ballCollection = new ArrayList<>();

        // Generates 42 balls with randomized characteristics and adds them to an ArrayList. 
        //#MeaningOfLife
        for (int i = 0; i < 42; i++) {
            leBall ball = new leBall(
                    /* Random positions from 0 to window width or window height */
                    Math.floor(Math.random() * 1000),
                    Math.floor(Math.random() * 600),
                    // Size randomization from 10 to 50
                    (int) Math.floor(Math.random() * 40) + 10,
                    // Random colors using RGB
                    new Color(
                        (int) Math.floor((Math.random() * 256)),
                        (int) Math.floor((Math.random() * 256)),
                        (int) Math.floor((Math.random() * 256))
                    ),
                    // Random velocities from -10 to 10 
                    Math.floor((Math.random() * 5) - 2.5),
                    Math.floor((Math.random() * 20) - 10),
                    (600),
                    (1000) 
            );
            ballCollection.add(ball);
        }

        // Start JFrame and initialize basic parameters
        ballWindow = new JFrame();
        drawPanel = new DrawPanel();
        ballWindow.getContentPane().add(drawPanel);
        ballWindow.setTitle("Buncha' balls");
        ballWindow.setSize(1000, 600);
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