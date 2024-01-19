package swordfighting;

import java.awt.Color;
import java.awt.Graphics;

public class Player {
    public static final int Width = 20, Height = 20;
    public static final int MaxSpeed = 3;

    public double posX, posY;
    public double velX, velY;

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
        g.fillRoundRect((int) posX,(int) posY, Width, Height, Width, Height);
    }
}
