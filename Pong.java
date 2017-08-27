package game.pong;

import javax.swing.*;
import java.awt.*;

public class Pong extends JFrame {

    public Pong() {
        add(new PongBoard());
        setResizable(false);
        pack();
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            new Pong().setVisible(true);
        });
    }
}

