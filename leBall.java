import javax.swing.*;
import java.awt.*;

public class leBall {
    
    private int posX, posY, size, windowHeight, windowWidth;
    private Color color;


    private double vx = 5;
    private double vy = 5;


    public leBall(int posX, int posY, int size, Color color, double vx, double vy, int windowHeight, int windowWidth) {
        this.posX = posX;
        this.posY = posY;
        this.size = size;
        this.color = color;
        this.vx = vx;
        this.vy = vy;
        this.windowHeight = windowHeight;
        this.windowWidth = windowWidth;
    }
    public JFrame mainFrame;

    void update() {

        if (posX > windowWidth || posX < 0) {
            vx *= -1;
        }

        if (posY > windowHeight || posY < 0) {
            vy *= -1;
        }

        if (posX > windowWidth) {
            posX = windowWidth;
        }

        if (posX < 0) {
            posX = 0;
        }

        if (posY > windowHeight) {
            posY = windowHeight;
        }

        if (posY < 0) {
            posY = 0;
        }

        this.posX += vx;
        this.posY += vy;

    }

    void draw(Graphics g) {
        g.setColor(color);
        g.fillOval(posX, posY, size, size);
    }
}