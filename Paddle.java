package game.pong;

import java.awt.*;

abstract class Paddle {
    protected final int HEIGHT = 100;
    protected final int WIDTH = 20;
    protected int playerNumber;
    protected double x, y, velY;

    public void draw(Graphics g) {
        g.fillRect((int) x, (int) y, WIDTH, HEIGHT);
    }

    public int getY() {
        return (int) y;
    }

    public int getX() {
        return (int) x;
    }

    public int getPlayer() {
        return this.playerNumber;
    }

    public abstract void move();
}
