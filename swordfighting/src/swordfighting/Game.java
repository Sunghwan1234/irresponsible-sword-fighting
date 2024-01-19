package swordfighting;

import javax.swing.JPanel;
import javax.swing.Timer;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Game extends JPanel implements ActionListener, KeyListener {
    public static final int WindowWidth = 750, WindowHeight = 500;

    private final Timer timer;
    public final Player player;

    public Game() { // Variables at game start
        this.player = new Player(
            WindowWidth/2,
            300
        );
        
        this.timer = new Timer(1, this);
        this.timer.start();

        setFocusable(true);
        setFocusTraversalKeysEnabled(false);
        addKeyListener(this);
    
    new Timer(1, this);
        this.timer.start();

        setFocusable(true);
        setFocusTraversalKeysEnabled(false);
        addKeyListener(this);
    }
        @Override
        public void paint(Graphics g) { // DRAWING - - - - - - - - - - -
    
            // Draw background
            g.setColor(Color.BLACK);
            g.fillRect(0, 0, WindowWidth, WindowHeight);
    
            // Draw Entities
            player.render(g);
    
            // Draw Score
            g.setColor(Color.WHITE);
            g.drawString("Timer: " + timer.toString(), 12, 16);
            
            g.dispose();
    
            
        }
    
        @Override
        public void keyTyped(KeyEvent e) {
        }
    
        @Override
        public void keyPressed(KeyEvent e) { // - - - - - - - - - - CONTROLS - - - - - - - - - - \\
            // Left arrow: 37
            switch(e.getKeyCode()) {
                case 38: // Up Key
                    
                    break;
                default: // Everything else
                    break; 
            }
        }
    
        @Override
        public void keyReleased(KeyEvent e) {
        }
    
        @Override
        public void actionPerformed(ActionEvent e) {
            timer.start();
    
            repaint();
    }
}
