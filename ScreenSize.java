package game.pong;

import java.awt.*;

public class ScreenSize {
    private static final int B_WIDTH = (int) (Toolkit.getDefaultToolkit().getScreenSize().getWidth() * 0.9);
    private static final int B_HEIGHT = (int) (Toolkit.getDefaultToolkit().getScreenSize().getHeight() * 0.8);

    public static int getbWidth() {
        return B_WIDTH;
    }

    public static int getbHeight() {
        return B_HEIGHT;
    }
}
