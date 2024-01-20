package dodge;

import java.awt.Color;
import java.awt.Graphics;


public class Boss {
    public double posX, posY;
    public int Width = 100, Height = 100;

    public double[][] object = new double[1000][5];
    public int count = 0;

    public double beat = Math.floor((Game.tick-14)/30.1);
    
    public Boss(double posX, double posY) {
        this.posX = posX; this.posY = posY;

    }
    public void actions() {
        // The beat is 30.1 ticks (very accurate, Tested), starts at 0 at 14 first beat at 44

        shoot(1,0,74);
        shoot(1,0,104);
        shoot(1,0,134);
    }
    public void shoot(int type, double deg, int tickreq) {
        if (Game.tick==tickreq) {
            switch (type) {
                case 1:
                    // posX posY, PTX PTY, PTY-posY/PTX-posX

                    object[count][0]=1;
                    object[count][1]=posX-25; object[count][2]=posY-43;
                    object[count][3]=-4; object[count][4]=-8;
                    count+=1;
                    object[count][0]=1;
                    object[count][1]=posX+25; object[count][2]=posY-43;
                    object[count][3]=4; object[count][4]=-8;
                    count+=1;
                    break;
                default:
                    break;
            }
        }
    }

    public void render(Graphics g) {



        // BOSS RENDER
        int BorderThickness = 15;
        g.setColor(Color.red);
        g.fillOval((int) posX-Width/2,(int) posY-Height/2, Width, Height);
        g.setColor(Color.black);
        g.fillOval(
            (int) (posX-(Width-BorderThickness)/2),
            (int) (posY-(Height-BorderThickness)/2), 
            Width-BorderThickness, Height-BorderThickness);
        g.setColor(Color.red);
        g.fillOval((int) posX-10,(int) posY-10, 20, 20);

        // OBJECTS RENDER
        for (int i=0; i<120;i++) {
            if (object[i][0] == 1) {
                object[i][1]+=object[i][3]; object[i][2]+=object[i][4];

                g.setColor(Color.red);
                g.fillOval((int) object[i][1]-8, (int) object[i][2]-8,16,16);
            }
        }
    }
}