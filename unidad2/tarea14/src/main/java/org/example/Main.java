package org.example;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JFrame;

public class Main extends JFrame{

    int ox=400, oy=400;
    double A=30, B=30;
    int resX=800, resY=800;

    public int coorxd(double x, double y, double z){
        return (int)(ox + x * Math.cos(B*Math.PI/180) + z * Math.cos(A*Math.PI/180));
    }

    public int cooryd(double x, double y, double z){
        return (int)(oy - (y - x * Math.sin(B*Math.PI/180) + z * Math.sin(A*Math.PI/180)));
    }

    public void pixel3D(double x, double y, double z, Graphics g){
        int xd = coorxd(x,y,z);
        int yd = cooryd(x,y,z);
        g.fillRect(xd, yd, 3, 3);
    }

    public void linea3D(double x1, double y1, double z1, double x2, double y2, double z2, Graphics g){
        int xd1 = coorxd(x1,y1,z1);
        int yd1 = cooryd(x1,y1,z1);
        int xd2 = coorxd(x2,y2,z2);
        int yd2 = cooryd(x2,y2,z2);

        g.drawLine(xd1, yd1, xd2, yd2);
    }

    public void ParcheBezier(int x[][],int y[][],int z[][],int n,Graphics g){
        double ds=1.0/n;
        double dt=1.0/n;
        double s=0,t=0,t2,t3,s2,s3;
        double As,Bs,Cs,Ds;
        double At,Bt,Ct,Dt;
        double BXA,BXB,BXC,BXD;
        double BYA,BYB,BYC,BYD;
        double BZA,BZB,BZC,BZD;

        int xd[][]=new int[n+1][n+1];
        int yd[][]=new int[n+1][n+1];
        int zd[][]=new int[n+1][n+1];
        for (int i=0;i<=n;i++){
            s=i*ds;
            s2=s*s;
            s3=s*s*s;
            As=  -s3+3*s2-3*s+1;
            Bs= 3*s3-6*s2+3*s;
            Cs=-3*s3+3*s2;
            Ds=   s3;

            BXA=As*x[0][0]+Bs*x[1][0]+Cs*x[2][0]+Ds*x[3][0];
            BXB=As*x[0][1]+Bs*x[1][1]+Cs*x[2][1]+Ds*x[3][1];
            BXC=As*x[0][2]+Bs*x[1][2]+Cs*x[2][2]+Ds*x[3][3];
            BXD=As*x[0][3]+Bs*x[1][3]+Cs*x[2][3]+Ds*x[3][3];

            BYA=As*y[0][0]+Bs*y[1][0]+Cs*y[2][0]+Ds*y[3][0];
            BYB=As*y[0][1]+Bs*y[1][1]+Cs*y[2][1]+Ds*y[3][1];
            BYC=As*y[0][2]+Bs*y[1][2]+Cs*y[2][2]+Ds*y[3][3];
            BYD=As*y[0][3]+Bs*y[1][3]+Cs*y[2][3]+Ds*y[3][3];

            BZA=As*z[0][0]+Bs*z[1][0]+Cs*z[2][0]+Ds*z[3][0];
            BZB=As*z[0][1]+Bs*z[1][1]+Cs*z[2][1]+Ds*z[3][1];
            BZC=As*z[0][2]+Bs*z[1][2]+Cs*z[2][2]+Ds*z[3][3];
            BZD=As*z[0][3]+Bs*z[1][3]+Cs*z[2][3]+Ds*z[3][3];


            for (int j=0;j<=n;j++){
                t=j*dt;
                System.out.println(t+" "+s);
                t2=t*t;
                t3=t*t*t;
                At=  -t3+3*t2-3*t+1;
                Bt= 3*t3-6*t2+3*t;
                Ct=-3*t3+3*t2;
                Dt=   t3;

                xd[i][j]=(int)(BXA*At+BXB*Bt+BXC*Ct+BXD*Dt);
                yd[i][j]=(int)(BYA*At+BYB*Bt+BYC*Ct+BYD*Dt);
                zd[i][j]=(int)(BZA*At+BZB*Bt+BZC*Ct+BZD*Dt);

            } // for j
        } // for i

        for(int i=0;i<=n;i++)
            for(int j=0;j<n;j++)
                linea3D(xd[i][j],yd[i][j],zd[i][j],xd[i][j+1],yd[i][j+1],zd[i][j+1],g);

        for(int j=0;j<=n;j++)
            for(int i=0;i<n;i++)
                linea3D(xd[i][j],yd[i][j],zd[i][j],xd[i+1][j],yd[i+1][j],zd[i+1][j],g);
    } // ParcheBezi

    public void ejes3D(Graphics g){
        linea3D(0, 0, 0, 1000, 0, 0, g);
        linea3D(0, 0, 0, 0, 1000, 0, g);
        linea3D(0, 0, 0, 0, 0, -1000, g);
    }

    public void caja3D(double x1, double y1, double z1, double x2, double y2, double z2, Graphics g){

        linea3D(x1, y2, z2, x2, y2, z2, g);
        linea3D(x2, y2, z2, x2, y2, z1, g);
        linea3D(x2, y2, z1, x1, y2, z1, g);
        linea3D(x1, y2, z1, x1, y2, z2, g);

        linea3D(x1, y1, z2, x2, y1, z2, g);
        linea3D(x2, y1, z2, x2, y1, z1, g);
        linea3D(x2, y1, z1, x1, y1, z1, g);
        linea3D(x1, y1, z1, x1, y1, z2, g);

        linea3D(x1, y2, z2, x1, y1, z2, g);
        linea3D(x1, y2, z1, x1, y1, z1, g);
        linea3D(x2, y2, z2, x2, y1, z2, g);
        linea3D(x2, y2, z1, x2, y1, z1, g);

    }

    public void paint(Graphics g){

        int z[][]={{-300,-300,-300,-300},
                {-150,-150,-150,-150},
                {150,150,150,150},
                {300,300,300,300}};
        int x[][]={{-300,-150,150,300},
                {-300,-150,150,300},
                {-300,-150,150,300},
                {-300,-150,150,100}};
        int y[][]={{0,0,0,0},
                {0,0,0,0},
                {0,500,0,0},
                {0,0,0,300}};
        g.setColor(Color.red);
        ejes3D(g);
        g.setColor(Color.green);
        ParcheBezier(x,y,z,50,g);
        /*
        System.out.println(coorxd(200,0,0));
        System.out.println(cooryd(200,0,0));
        g.setColor(Color.red);
        pixel3D(0, 0, 0, g);
        g.setColor(Color.blue);
        pixel3D(-200, 0, 0, g);

        g.setColor(Color.MAGENTA);
        linea3D(0, 0, 0, 200, 0, 0, g);

        g.setColor(Color.black);
        ejes3D(g);

        /*
        for(double z = -70; z < 70; z+=10){
            for(double x = -400; x < 400; x+=0.01){
                //double x = ang/(2*Math.PI)*400;
                double y = -Math.abs(Math.sin(x * 4*Math.PI/400) * 25);

                g.setColor(Color.green);
                pixel3D(x, y, z, g);
            }
        }*/

        /*for(double z = -70; z < 70; z+=14){
            double z = -300;
            for(double ang = 0; ang < 20 * Math.PI; ang+=0.01){
                double x = 100 * Math.cos(ang);
                double y = 100 * Math.sin(ang);

                g.setColor(Color.orange);
                pixel3D(x, y, z, g);
                z+=0.1;
            }
        */
        // caja3D(0, 0, 40, 50, 60, 100, g);
    }

    public Main() {
        setTitle("Trabajando en 3D");
        setSize(resX,resY);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        setBackground(Color.white);
    }



    public static void main(String[] args) {
        Main main = new Main();
    }

}