package game.pong;

public class HumanPaddle extends Paddle {
    public final double GRAVITY = 0.94;
    boolean upAccel, downAccel;

    public HumanPaddle(int playerNumber) {
        upAccel = false;
        downAccel = false;
        if (playerNumber == 1) {
            x = 20;
        } else if (playerNumber == 2) {
            x = ScreenSize.getbWidth() - 20 - WIDTH;
        }
        y = ScreenSize.getbHeight() / 2 - HEIGHT / 2;
        this.playerNumber = playerNumber;
    }

    @Override

    public void move() {
        if (upAccel) {
            velY -= 2;
        } else if (downAccel) {
            velY += 2;
        } else if (!upAccel && !downAccel) {
            velY *= GRAVITY;
        }
        if (velY >= 6) {
            velY = 6;
        } else if (velY <= -6) {
            velY = -6;
        }
        y += velY;
        if (y < 10) {
            y = 10;
        }
        if (y > ScreenSize.getbHeight() - HEIGHT - 10) {
            y = ScreenSize.getbHeight() - HEIGHT - 10;
        }

    }

    public void setUpAccel(boolean val) {
        this.upAccel = val;
    }

    public void setDownAccel(boolean val) {
        this.downAccel = val;
    }

}
