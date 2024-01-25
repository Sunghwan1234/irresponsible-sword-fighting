package dodge;

import java.awt.Color;
import java.awt.Graphics;
import static java.lang.Math.PI;

public class Boss {
    public double posX, posY;
    public double direction;
    public int Width = 100, Height = 100;
    public double mdirection = 0;
    public double dmx = Math.sin(mdirection*PI/180);
    public double dmy = Math.cos(mdirection*PI/180);

    public double[][] object = new double[1000][5];
    public int count = 0;

    public int tick = Game.tick;
    public double tbeat = Math.floor((Game.tick-13)/30.1);
    // other crap
    public double fspeed = 0.1;
    public double SR_speed = 0.1;
    
    public Boss(double posX, double posY, double direction) {
        this.posX = posX; this.posY = posY;
        this.direction = direction;
    }

    public void rotateToDir(double dir, double speed, int tickreq) {
        if (tick>tickreq && tick<tickreq+30) {
            direction+=(dir-direction)/speed;
        }
    }
    public void startRotating(double speed, double stopat, int tickreq, int endtick) {
        if (tick>tickreq && tick<endtick) {
            if (SR_speed<speed) {SR_speed+=0.1;}
            direction+=SR_speed;
        }
    }

    public void upddirmov() {dmx = Math.sin(mdirection*PI/180);dmy = Math.cos(mdirection*PI/180);}
    public void movebydir(double spd) {
        double xdirspd = dmx*spd; double ydirspd = dmy*spd; posX+=xdirspd; posY-=ydirspd;
    }
    public void actions() {
        // The beat is 30.1 ticks (very accurate, Tested), starts at 0 at 13 first beat at 44
        // variables
            upddirmov();
            tick = Game.tick;
            int beat = (int) Math.floor(tbeat);

 
        // rest 44
        shoot(2,direction,74);
        shoot(2,direction,104);
        shoot(2,direction,134);

        rotateToDir(100,3,164); // rotate
        shoot(2,direction,194);
        shoot(2,direction,224);
        shoot(2,direction,254);
        rotateToDir(260,3,254); // rotate

        shoot(2,direction,284);     // fast
        shootduo(direction,20,292);
        shoot(2,direction,299);
        shootduo(direction,20,309);

        rotateToDir(170,3,314); // rotate
        shoot(2,direction,344);
        shoot(2,direction,374);

        rotateToDir(340,3,404); // rotate
        shoot(2, direction, 434);
        shoot(2, direction, 464);
        shoot(2, direction, 494);

        floatmove(2, 524, 1490);
        startRotating(1.8,0,524,1490);

        shoot(2,direction,555);
        shoot(2,direction,585);
        shoot(2,direction,615);
        // rest 645
        shoot(2,direction,675);
        shoot(2,direction,705);
        shoot(2,direction,736);
        
        shoot(2,direction,766);     // fast
        shootduo(direction-10,15,773);
        shoot(2,direction-20,781);
        shootduo(direction-30,15,789);
        // 796
        shoot(2,direction,827);
        shoot(2,direction,857);

    }
    public void floatmove(int type, int tickreq, int tickto) {
        if (Game.tick>tickreq && tickto>Game.tick) {
            switch (type) {
                case 2:
                movebydir(fspeed);
                mdirection += 1.1;
                if (fspeed<2.2) {fspeed+=0.005;}
                break;
            default:
                break;
            }
        }}
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
            }}}
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

        double Ldx = Math.sin((direction-40)*PI/180); double Ldy = Math.cos((direction-40)*PI/180);
        double Rdx = Math.sin((direction+40)*PI/180); double Rdy = Math.cos((direction+40)*PI/180);
        double Lx = 55*Ldx; double Ly = 55*Ldy; double Rx = 55*Rdx; double Ry = 55*Rdy;
        g.fillOval((int) (posX+Lx-3),(int) (posY-Ly-3),6,6);
        g.fillOval((int) (posX+Rx-3),(int) (posY-Ry-3),6,6);

        // OBJECTS RENDER
        for (int i=0; i<120;i++) {
            if (object[i][0] == 1) {
                object[i][1]+=object[i][3]; object[i][2]+=object[i][4];

                g.setColor(Color.red);
                g.fillOval((int) object[i][1]-10, (int) object[i][2]-10,20,20);
            }
        }
    }
}