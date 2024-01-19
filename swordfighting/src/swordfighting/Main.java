package swordfighting.src.swordfighting;

import javax.swing.JFrame;

public class Main {
    public static void main() {
        JFrame window = new JFrame();

        window.setSize(Game.WINDOW_WIDTH, Game.WINDOW_HEIGHT);
        window.setResizable(false);

        window.setTitle("irresponsible sword fighting");
        
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        window.add(new Game());

        window.setVisible(true);
    }
}
