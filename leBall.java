import java.awt.*;

public class leBall {
    
    private int positionX, positionY, size, windowHeight, windowWidth;
    private Color color;


    private double vx = 5;
    private double vy = 5;


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

    void update() {
        

        if (positionX > windowWidth || positionX < 0) {
            vx *= -1.1;
        }

        if (positionY > windowHeight || positionY < 0) {
            vy *= -1.1;
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

    void draw(Graphics g) {
        g.setColor(color);
        g.fillOval(positionX, positionY, size, size);
    }
}