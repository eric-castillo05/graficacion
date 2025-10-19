package org.example;


import javax.swing.*;
import java.awt.*;

public class Main extends JFrame {
    double XMmin, YMmin, XMmax, YMmax;
    double XNmin, YNmin, XNmax, YNmax;
    int resX = 1024, resY = 1024;

    public void Ventana (double a, double b, double c, double d) {
        XMmin = a;
        YMmin = b;
        XMmax = c;
        YMmax = d;

    }

    public void Mirilla (double a, double b, double c, double d) {
        XNmin = a;
        YNmin = b;
        XNmax = c;
        YNmax = d;
    }

    public double CoorNX (double xm){
        return XNmin + (XNmax - XNmin) * (xm - XMmin) / (XMmax - XMmin);
    }
    public double CoorNY (double ym){
        return YNmin + (YNmax- YNmin) * (YMmax - ym) / (YMmax - YMmin);
    }

    public int CoorDX (double xm) {
        return (int)((resX - 1) * CoorNX(xm));
    }

    public int CoorDY (double ym) {
        return (int)((resY - 1) * CoorNY(ym));
    }

//    public void procesar () {
//        resX = 1024;
//        resY = 768;
//        Ventana(-10, -20, 10, 100);
//        Mirilla(0, 0, 1, 1);
//        System.out.println(CoorNX(5));
//        System.out.println(CoorNY(50));
//        System.out.println(CoorDX(5));
//        System.out.println(CoorDY(50));
//        Mirilla(1.0/3.0, 0.5, 2.0/3.0, 1);
//        System.out.println(CoorNX(5));
//        System.out.println(CoorNY(50));
//        System.out.println(CoorDX(5));
//        System.out.println(CoorDY(50));
//    }

    public void marco (Graphics g) {
        int x_inicial = (int)((resX - 1) * (XNmin));
        int x_final = (int)((resX - 1) * (XNmax));
        int y_inicial = (int)((resY - 1) * (YNmin));
        int y_final = (int)((resY - 1) * (YNmax));

        g.drawRect(x_inicial, y_inicial, x_final - x_inicial, y_final - y_inicial);

    }

    public boolean in_window(double x, double y){
        return XMmin <= x && x <= XMmax && YMmin <= y && y <= YMmax;
    }

    public void paint (Graphics g) {
//        Mirilla(1/3, 1/2, 2/3, 1);
//        Mirilla(0.1, 0.1, 0.9, 0.9);
        Mirilla(0.33, 0.33, 0.66, 0.66);
        Ventana(-2 * Math.PI, -3, 2 * Math.PI, 3);
        g.setColor(Color.RED);
        marco(g);
        ejes(g);
        g.setColor(Color.BLUE);
        for (double x = -2 * Math.PI; x < 2 * Math.PI + 1; x+=0.0001){
//            double y = -Math.abs(Math.sin(x * 2));
//            double y = Math.sin(x+ Math.PI / 2) ;
//            double y = 1 / Math.tan(x);
            double y = 1 / Math.cos(x);

            if (in_window(x, y)){
                int x_d = CoorDX(x);
                int y_d = CoorDY(y);
                g.drawRect(x_d, y_d, 1, 1);
            }
        }

        g.setColor(Color.GREEN);
        Ventana(-6, -6, 6, 6);
        double r = 2.5;
        for (double angulo = 0; angulo <= 2 * Math.PI * 20; angulo += 0.01){
            double x = r * Math.cos(angulo);
            double y = r * Math.sin(angulo);
            if (in_window(x, y)){
                int x_d = CoorDX(x);
                int y_d = CoorDY(y);
                g.drawRect(x_d, y_d, 1, 1);
            }
            r += 0.001;
        }
        g.setColor(Color.MAGENTA);

        for (double angulo = 0; angulo <= 2 * Math.PI * 50; angulo += 0.01){
            r = Math.sin(angulo * 10);
            double x = r * Math.cos(angulo);
            double y = r * Math.sin(angulo);
            if (in_window(x, y)){
                int x_d = CoorDX(x);
                int y_d = CoorDY(y);
                g.drawRect(x_d, y_d, 1, 1);
            }
            r += 0.01;
        }
    }

    public void ejes (Graphics g) {
//        dibujar ejex
        if (YMmin * YMmax < 0) {
            int x_d1 = CoorDX(XMmin);
            int x_d2 = CoorDX(XMmax);
            int yd = CoorDY(0);
            g.drawLine(x_d1, yd, x_d2, yd);
        }
        if (XMmin * XMmax < 0) {
            int y_d1 = CoorDY(YMmin);
            int y_d2 = CoorDY(YMmax);
            int xd = CoorDX(0);
            g.drawLine(xd, y_d1, xd, y_d2);
        }
    }

    public Main (){
        setSize(resX, resY);
        setTitle("Coordenadas");
        setVisible(true);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    public static void main(String[] args) {
        Main main = new Main();
//        main.procesar();
    }
}