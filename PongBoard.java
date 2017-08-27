package game.pong;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class PongBoard extends JPanel implements Runnable, KeyListener {
    private final int B_WIDTH = ScreenSize.getbWidth();
    private final int B_HEIGHT = ScreenSize.getbHeight();
    Thread timer;
    HumanPaddle p1;
    AIPaddle p2;
    Ball b;
    Paddle paddle;
    boolean gameStarted;

    PongBoard() {
        gameStarted = false;
        setBackground(Color.BLACK);
        setPreferredSize(new Dimension(B_WIDTH, B_HEIGHT));
        setDoubleBuffered(true);
        addKeyListener(this);
        setFocusable(true);
        setFocusTraversalKeysEnabled(false);

        b = new Ball();
        p1 = new HumanPaddle(1);
        p2 = new AIPaddle(2, b);

        timer = new Thread(this);
        timer.start();
    }

    @Override
    public void run() {
        while (true) {
            if (gameStarted) {
                p1.move();
                p2.move();
                b.move();
            }
            repaint();
            paddle = b.getVelX() < 0 ? p1 : p2;
            b.checkCollision(paddle);
            try {
                Thread.sleep(15);
            } catch ( Exception e ) {
            }
        }
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.WHITE);

        /*g.drawLine(10,10,10, B_HEIGHT-10);
        g.drawLine(10,10,B_WIDTH - 10, 10);
        g.drawLine(B_WIDTH - 10,B_HEIGHT-10,10, B_HEIGHT-10);
        g.drawLine(B_WIDTH - 10,B_HEIGHT-10,B_WIDTH - 10, 10);
        g.drawLine(B_WIDTH/2,10,B_WIDTH/2, B_HEIGHT-10);
        g.drawOval(B_WIDTH/2 - 150,B_HEIGHT / 2 - 150, 300,300);
        g.fillOval(B_WIDTH/2 - 5,B_HEIGHT / 2 - 5,10,10);*/

        p1.draw(g);
        p2.draw(g);
        b.draw(g);
        if (!gameStarted) {
            g.setColor(Color.WHITE);
            g.drawString("Ping Pong", B_WIDTH / 2 - 25, 100);
            g.drawString("Press Enter to Start the Game.", B_WIDTH / 2 - 50, 130);
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int code = e.getKeyCode();
        switch (code) {
            case KeyEvent.VK_UP:
                p1.setUpAccel(true);
                break;
            case KeyEvent.VK_DOWN:
                p1.setDownAccel(true);
                break;
            case KeyEvent.VK_ENTER:
                gameStarted = true;
                break;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        int code = e.getKeyCode();
        switch (code) {
            case KeyEvent.VK_UP:
                p1.setUpAccel(false);
                break;
            case KeyEvent.VK_DOWN:
                p1.setDownAccel(false);
                break;
        }
    }
}
