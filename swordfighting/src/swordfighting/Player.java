package swordfighting;

import java.awt.Color;
import java.awt.Graphics;

public class Player {
    public static final int Width = 20, Height = 20;
    public double posX, posY;

    public Player(double posX, double posY) {
        this.posX = posX;
        this.posY = posY;
    }
    public void render(Graphics g) {
        g.setColor(Color.white);
        // g.fillRect((int) posX,(int) posY,(int) Width,(int) Height);
        g.fillRoundRect((int) posX,(int) posY, Width, Height, Width, Height);
    }
}
