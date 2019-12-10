import javax.swing.*;
import java.awt.*;

public class leBall {
    
    private int posX, posY, size;
    private Color color;

    private int vx = 5;
    private int vy = 5;

    public leBall(int posX, int posY, int size, Color color, int vx, int vy) {
        this.posX = posX;
        this.posY = posY;
        this.size = size;
        this.color = color;
        this.vx = vx;
        this.vy = vy;
    }

    void update() {

        if (posX > mainFrame.getWidth() || posX < 0) {
            vx *= -1;
        }

        if (posY > mainFrame.getHeight() || posY < 0) {
            vy *= -1;
        }

        if (posX > mainFrame.getWidth()) {
            posX = mainFrame.getWidth();
        }

        if (posX < 0) {
            posX = 0;
        }

        if (posY > mainFrame.getHeight()) {
            posY = mainFrame.getHeight();
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