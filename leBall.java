import java.awt.*;

public class leBall {

    public leBall(int positionX, int positionY, int size, Color color, double vx, double vy, int windowHeight, int windowWidth) {
        this.positionX = positionX;
        this.positionY = positionY;
        this.size = size;
        this.color = color;
        this.vx = vx;
        this.vy = vy;
        this.windowHeight = windowHeight;
        this.windowWidth = windowWidth;
    }
    
    private double vx = 5;
    private double vy = 5;
    private int positionX, positionY; 
    private int size;
    private int windowHeight, windowWidth;
    private Color color;

    void update() {    

        if (positionX > windowWidth || positionX < 0) {
            vx *= -1;
        }

        if (positionY > windowHeight || positionY < 0) {
            vy *= -1;
        }

        if (positionX > windowWidth) {
            positionX = windowWidth;
        }

        if (positionX < 0) {
            positionX = 0;
        }

        if (positionY > windowHeight) {
            positionY = windowHeight;
        }

        if (positionY < 0) {
            positionY = 0;
        }

        this.positionX += vx;
        this.positionY += vy;

    }

    // Assigning color, position and size to the ball, is called from Window.java
    void draw(Graphics g) {
        g.setColor(color);
        g.fillOval(positionX, positionY, size, size);
    }
}