package game.pong;

public class AIPaddle extends Paddle {
    Ball b1;

    public AIPaddle(int playerNumber, Ball b) {
        b1 = b;
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
        double destiny = b1.getY() - (HEIGHT - b1.SIZE) * 0.5;//make ball strike to the center
        y += (destiny - y) * 0.2;
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
}
