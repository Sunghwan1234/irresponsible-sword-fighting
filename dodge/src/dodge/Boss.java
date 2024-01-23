package dodge;

import java.awt.Color;
import java.awt.Graphics;
import static java.lang.Math.PI;

public class Boss {
    public double posX, posY;
    public int Width = 100, Height = 100;

    public double[][] object = new double[1000][5];
    public int count = 0;

    public double beat = Math.floor((Game.tick-13)/30.1);
    
    public Boss(double posX, double posY) {
        this.posX = posX; this.posY = posY;

    }
    public void actions() {
        // The beat is 30.1 ticks (very accurate, Tested), starts at 0 at 13 first beat at 44

        shoot(2,0,74);
        shoot(2,0,104);
        shoot(2,0,134);
        // REST
        shoot(2,100,194);
        shoot(2,100,224);
        shoot(2,100,254);

        shoot(2,260,284);
        shootduo(260,20,292);
        shoot(2,260,299);
        shootduo(260,20,307);

        shoot(2,180,337);

    }
    public void shoot(int type, double deg, int tickreq) {
        if (Game.tick==tickreq) {
            // Variables
            int speed = 3;


            switch (type) {
                case 1:
                    double dx = Math.sin((deg)*PI/180); double dy = Math.cos((deg)*PI/180);
                    double spx = speed*dx; double spy = speed*dy;
                    double sx = 50*dx; double sy = 50*dy;

                    object[count][0] = 1;
                    object[count][1]=posX+sx; object[count][2]=posY-sy;
                    object[count][3]=spx; object[count][4]=-spy;
                    count+=1;
                    break;
                case 2:
                    double Ldx = Math.sin((deg-40)*PI/180); double Ldy = Math.cos((deg-40)*PI/180);
                    double Rdx = Math.sin((deg+40)*PI/180); double Rdy = Math.cos((deg+40)*PI/180);
                    double Lx = 50*Ldx; double Ly = 50*Ldy; double Rx = 50*Rdx; double Ry = 50*Rdy;
                    double Lspeedx = speed*Ldx; double Lspeedy = speed*Ldy;
                    double Rspeedx = speed*Rdx; double Rspeedy = speed*Rdy;

                    object[count][0]=1;
                    object[count][1]=posX+Lx; object[count][2]=posY-Ly;
                    object[count][3]=Lspeedx; object[count][4]=-Lspeedy;
                    count+=1;
                    object[count][0]=1;
                    object[count][1]=posX+Rx; object[count][2]=posY-Ry;
                    object[count][3]=Rspeedx; object[count][4]=-Rspeedy;
                    count+=1;
                    break;
                default:
                    break;
            }
        }
    }
    public void shootduo(double deg, double ideg, double tickreq) {
        if (Math.floor(Game.tick)==tickreq) {
                int speed = 3;

                double Ldx = Math.sin((deg-ideg)*PI/180); double Ldy = Math.cos((deg-ideg)*PI/180);
                double Rdx = Math.sin((deg+ideg)*PI/180); double Rdy = Math.cos((deg+ideg)*PI/180);

                double Lx = 50*Ldx; double Ly = 50*Ldy; double Rx = 50*Rdx; double Ry = 50*Rdy;

                double Lspeedx = speed*Ldx; double Lspeedy = speed*Ldy;
                double Rspeedx = speed*Rdx; double Rspeedy = speed*Rdy;

                object[count][0]=1;
                object[count][1]=posX+Lx; object[count][2]=posY-Ly;
                object[count][3]=Lspeedx; object[count][4]=-Lspeedy;
                count+=1;
                object[count][0]=1;
                object[count][1]=posX+Rx; object[count][2]=posY-Ry;
                object[count][3]=Rspeedx; object[count][4]=-Rspeedy;
                count+=1;
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