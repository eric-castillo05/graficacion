package org.example;

import java.awt.Color;
import java.awt.Graphics;
import java.io.BufferedReader;
import java.io.FileReader;
import javax.swing.JFrame;

public class Main extends JFrame{
    int resX =800;
    int resY = 600;
    int Ox = 400;
    int Oy = 300;
    double A = 30;
    double B = 30;

    public Main(){
        setSize(resX, resY);
        setTitle("Graficas 3D");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public void paint(Graphics g){
        g.fillRect(0, 0, resX-1, resY-1);
        g.setColor(Color.red);
        g.setColor(Color.pink);
        ejes3D(g);
        g.setColor(Color.red);


        //try (FileReader fr = new FileReader("modelosdraw/tetera.tib")) {
        try (FileReader fr = new FileReader("C:\\Users\\misae\\OneDrive\\Documentos\\generartib\\teteradoble\\teteradoble.tib")) {
            BufferedReader br = new BufferedReader(fr);
            // Lectura del fichero
            String linea;
            int fe=100;
            linea=br.readLine();
            int ntri=Integer.parseInt(linea);
            System.out.println("Numero de triangulos:"+ntri);
            for (int i=1;i<=ntri;i++){
                System.out.println("Triangulo "+i);
                double x0=0,y0=0,z0=0;
                double x1=0,y1=0,z1=0;
                double x2=0,y2=0,z2=0;
                for (int v=0;v<3;v++){
                    linea=br.readLine();
                    String valores[]=linea.split(",");
                    double x=Double.parseDouble(valores[0]);
                    double y=Double.parseDouble(valores[1]);
                    double z=Double.parseDouble(valores[2]);
                    switch (v) {
                        case 0:
                            x0=x;
                            y0=y;
                            z0=z;
                            break;
                        case 1:
                            x1=x;
                            y1=y;
                            z1=z;
                            break;
                        case 2:
                            x2=x;
                            y2=y;
                            z2=z;
                            break;
                    }
                    //System.out.println(linea);
                }
           /* System.out.println(String.format("%10.4f %10.4f %10.4f", x0,y0,z0));
            System.out.println(String.format("%10.4f %10.4f %10.4f", x1,y1,z1));
            System.out.println(String.format("%10.4f %10.4f %10.4f", x2,y2,z2));
            System.out.println("================================");*/

                linea3D(x0*fe,y0*fe,z0*fe, x1*fe,y1*fe,z1*fe, g);
                linea3D(x1*fe,y1*fe,z1*fe, x2*fe,y2*fe,z2*fe, g);
                linea3D(x2*fe,y2*fe,z2*fe, x0*fe,y0*fe,z0*fe, g);
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }


    }

    public int coorXD(double x, double y, double z){
        return (int) (Ox + (x*Math.cos(Math.toRadians(B))) + z * Math.cos(Math.toRadians(A)));
    }

    public int coorYD(double x, double y, double z){
        return (int) (Oy - (y - (x * Math.sin(Math.toRadians(B))) + z * Math.sin(Math.toRadians(A))));
    }

    public void ejes3D(Graphics g){
        g.drawLine(Ox, Oy, coorXD(1000, 0, 0), coorYD(1000, 0, 0));
        g.drawLine(Ox, Oy, coorXD(0, 1000, 0), coorYD(0, 1000, 0));
        g.drawLine(Ox, Oy, coorXD(0, 0, -1000), coorYD(0, 0, -1000));
    }

    public void dibujaPrixel(double x, double y, double z, Graphics g){
        g.fillRect(coorXD(x, y, z), coorYD(x, y, z), 1, 1);
    }

    public void linea3D(double x1, double y1, double z1, double x2, double y2, double z2, Graphics g){
        g.drawLine(coorXD(x1, y1, z1), coorYD(x1, y1, z1), coorXD(x2, y2, z2), coorYD(x2, y2, z2));
    }

    public static void main(String[] args) {
        Main main = new Main();
    }

}