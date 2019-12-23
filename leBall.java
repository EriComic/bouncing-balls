import java.awt.*;

public class leBall {

    public leBall(Double positionX, Double positionY, int size, Color color, double vx, double vy, int windowHeight, int windowWidth) {
        this.positionX = positionX;
        this.positionY = positionY;
        this.size = size;
        this.color = color;
        this.vx = vx;
        this.vy = vy;
        this.windowHeight = windowHeight;
        this.windowWidth = windowWidth;
    }
    
    //Initialize paramters from main java file to ball file, using the "this" statement
    private double vx = 5;
    private double vy = 5;
    private double positionX, positionY; 
    private int size;
    private int windowHeight, windowWidth;
    private Color color;
    private double time = 0.01; //Time variable is gained from our visual update speed of 10 ms
    private double gravity = -300;

    void update() {    

        if (positionX < 0) {
            vx *= -1;
        }
        
        if (positionX > (windowWidth - size)) {
            vx *= -1;
        }

        if (positionY < (0)) {
            vy *= -1;
        }

        if (positionY > (windowHeight - size)) {
            vy *= -1;
        }

        if (positionX > windowWidth) {
            positionX = windowWidth - size;
        }

        if (positionX < 0) {
            positionX = 0;
        }

        if (positionY > windowHeight) {
            positionY = (windowHeight);
        }

        if (positionY < 0) {
            positionY = (0 - size);
        }

        this.positionX += vx;

        //gravity
        this.positionY = this.positionY + time * vy - gravity * (time * time / 2);
        vy = vy - gravity * time;

    }

    // Assigning color, position and size to the ball, is called from Window.java
    void draw(Graphics g) {
        g.setColor(color);
        g.fillOval((int)positionX, (int)positionY, size, size);
    }
}