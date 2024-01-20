package dodge;

import javax.swing.JFrame;

public class Main {
    public static void main(String[] args) {
        JFrame window = new JFrame();

        window.setSize(Game.WindowWidth, Game.WindowHeight);
        window.setResizable(false);

        window.setTitle("irresponsible sword fighting");
        
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        window.add(new Game());

        window.setVisible(true);
    }
}
