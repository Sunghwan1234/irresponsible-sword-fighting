package dodge;

import java.awt.Color;
import java.awt.Graphics;

public class Player {
    public static final int Width = 10, Height = 10;
    public static final int MaxSpeed = 3;

    public double posX, posY;
    public double velX, velY;

    // public double swHWidth = 6/2, swHeight = 20, swTHeight = 24;
    // public double swDist = Width/2+2;

    public Player(double posX, double posY) {
        this.posX = posX;
        this.posY = posY;
    }

    public void move() {
        if (Game.KeyPressed[0]) {velX-=1;}
        if (Game.KeyPressed[1]) {velY-=1;}
        if (Game.KeyPressed[2]) {velX+=1;}
        if (Game.KeyPressed[3]) {velY+=1;}
    }
    public void physics() {
        posX+=velX; posY+=velY;
        velX *= 0.9; velY *= 0.9;
        if (velX > MaxSpeed) {velX = MaxSpeed;} if (velX < -MaxSpeed) {velX = -MaxSpeed;}
        if (velY > MaxSpeed) {velY = MaxSpeed;} if (velY < -MaxSpeed) {velY = -MaxSpeed;}
    }
    public void collision() {
        if (posX<0) {posX=0; velX*=-1;} if (posY<0) {posY=0;velY*=-1;}
        if (posX>Game.WindowWidth-Width) {posX=Game.WindowWidth-Width; velX*=-1;}
        if (posY>Game.WindowHeight-Height) {posY=Game.WindowHeight-Height; velY*=-1;}
    }
    public void render(Graphics g) {
        physics();
        collision();

        g.setColor(Color.white);
        // g.fillRect((int) posX,(int) posY,(int) Width,(int) Height);
        g.fillRoundRect((int) posX-Width/2,(int) posY-Height/2, Width, Height, Width, Height);

        // Sword for later
        // double centX = posX+Width/2, centY = posY+Height/2;

        // g.setColor(Color.red);
        // g.fillPolygon(new int[] {
        //     (int) (centX-swHWidth),
        //     (int) (centX+swHWidth),
        //     (int) (centX+swHWidth),
        //     (int) (centX),
        //     (int) (centX-swHWidth)},
        //     new int[] {
        //         (int) (centY-swDist),
        //         (int) (centY-swDist),
        //         (int) (centY-swDist-swHeight),
        //         (int) (centY-swDist-swTHeight),
        //         (int) (centY-swDist-swHeight)},
        //          5);
    }
}
