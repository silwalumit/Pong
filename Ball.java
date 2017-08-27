package game.pong;

import java.awt.*;

public class Ball {
    private double x, y, velX, velY, speed = 5;
    public final int SIZE = 20;

    //private double offset;
    public Ball() {
        x = ScreenSize.getbWidth() / 2 - 10;
        y = ScreenSize.getbHeight() / 2 - 10;
        velX = 4;
        velY = 4;
    }

    /*velX = getRandomDirection() * getRandomSpeed();
    velY = getRandomDirection() * getRandomSpeed();
}
public double getRandomSpeed(){
    return Math.random()* 3 + 2;
}
public double getRandomDirection(){
    int rand = (int) (Math.random() * 2);
    if(rand >= 1){
        return 1;
    }else{
        return -1;
    }
}*/
    public void draw(Graphics g) {
        g.fillRect((int) x, (int) y, SIZE, SIZE);
    }

    public void move() {
        x += velX;
        y += velY;
        if (y < 0 || y > ScreenSize.getbHeight() - SIZE) {
            velY *= -1;
        }
    }

    public void checkCollision(Paddle paddle) {
        if( paddle.getX() < x + SIZE && paddle.getY() < y + SIZE && x < paddle.getX() + paddle.WIDTH && y < paddle.getY() + paddle.HEIGHT ){
            //normalized value from 0 to 1 depending on where the ball strikes on the bat
            double normalValue = (y + SIZE - paddle.y) / (paddle.HEIGHT + SIZE);
            /*
            range of angle from 45 to -45,
            If ball strikes the paddle at upper edge the angle is 45
            If ball strikes the paddle at lower edge the angle is -45
            */
            double angle = 45 * (2 * normalValue - 1);
            //ball is returned at a angle depending on which part it strikes on the paddle

            velX = (paddle.getPlayer() == 1 ? 1 : -1 ) * speed * Math.cos(angle);
            velY = speed * Math.sin(angle);
        }
    }

    public double getY() {
        return y;
    }

    public double getVelX() {
        return velX;

    }
}
