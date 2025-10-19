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

    public void marco (Graphics g) {
        int x_inicial = (int)((resX - 1) * (XNmin));
        int x_final = (int)((resX - 1) * (XNmax));
        int y_inicial = (int)((resY - 1) * (YNmin));
        int y_final = (int)((resY - 1) * (YNmax));

        g.drawRect(x_inicial, y_inicial, x_final - x_inicial, y_final - y_inicial);

    }
    public void ejes(Graphics g) {
        if (YMmin * YMmax < 0) {
            int xd1 = CoorDX(XMmin);
            int xd2 = CoorDX(XMmax);
            int yd = CoorDY(0);
            g.drawLine(xd1, yd, xd2, yd);
        }
        if (XMmin * XMmax < 0) {
            int yd1 = CoorDY(YMmin);
            int yd2 = CoorDY(YMmax);
            int xd = CoorDX(0);
            g.drawLine(xd, yd1, xd, yd2);
        }
    }

    public boolean in_window(double x, double y){
        return XMmin <= x && x <= XMmax && YMmin <= y && y <= YMmax;
    }

    public void paint (Graphics g) {

        // Parabola X^3
        Mirilla(0, 0, 0.33, 0.50);
        Ventana(-2, -1, 2, 1);
        marco(g);
        ejes(g);
        g.setColor(Color.RED);
        for (double x = -2 * Math.PI; x < 2 * Math.PI + 1; x+=0.0001){
            double y = x * x * x;
            if (in_window(x, y)){
                int x_d = CoorDX(x);
                int y_d = CoorDY(y);
                g.drawRect(x_d, y_d, 1, 1);
            }
        }
        g.setColor(Color.BLUE);
        for (double x = -2 * Math.PI; x < 2 * Math.PI + 1; x+=0.0001){
            double y = x * x;
            if (in_window(x, y)){
                int x_d = CoorDX(x);
                int y_d = CoorDY(y);
                g.drawRect(x_d, y_d, 1, 1);
            }
        }

        // sin
        g.setColor(Color.BLACK);
        Mirilla(0.33, 0, 0.66, 0.50);
        Ventana(-2 * Math.PI, -3, 2 * Math.PI, 3);
        marco(g);
        ejes(g);
        for (double x = -2 * Math.PI; x < 2 * Math.PI + 1; x+=0.0001){
            double y = Math.sin(x);
            if (in_window(x, y)){
                int x_d = CoorDX(x);
                int y_d = CoorDY(y);
                g.drawRect(x_d, y_d, 1, 1);
            }
        }

        // Rosa con n petalos
        Mirilla(0.66, 0, 1, 0.50);
        Ventana(-2, -2, 2, 2);
        marco(g);
        double r;
        for (double angulo = 0; angulo <= 2 * Math.PI * 50; angulo += 0.01){
            r = Math.sin(angulo * 3);
            double x = r * Math.cos(angulo);
            double y = r * Math.sin(angulo);
            if (in_window(x, y)){
                int x_d = CoorDX(x);
                int y_d = CoorDY(y);
                g.drawRect(x_d, y_d, 1, 1);
            }
            r += 0.01;
        }

        // funcion propia
        Mirilla(0, 0.50, 0.33, 1);
        Ventana(-3, -3, 3, 3);
        g.setColor(Color.RED);
        marco(g);
        double R = 0.9, r2 = 0.75;
        for (double ang = 0; ang <= 2 * 10 * Math.PI; ang += 0.01) {
            double x = (R + r2) * Math.cos(ang) - r2 * Math.cos((R + r2) / r2 * ang);
            double y = (R + r2) * Math.sin(ang) - r2 * Math.sin((R + r2) / r2 * ang);
            if (in_window(x, y)) {
                int xd = CoorDX(x);
                int yd = CoorDY(y);
                g.drawRect(xd, yd, 1, 1);
            }
        }

        // spiral
        Mirilla(0.33, 0.5, 0.66, 1);
        Ventana(-2 * Math.PI, - 2 * Math.PI, 2 * Math.PI, 2 * Math.PI);
        g.setColor(Color.GREEN);
        marco(g);
        r = 0.1;
        for (double angulo = 0; angulo <= 2 * Math.PI*30; angulo += 0.01){
            double x = r * Math.cos(angulo);
            double y = r * Math.sin(angulo);
            if (in_window(x, y)){
                int x_d = CoorDX(x);
                int y_d = CoorDY(y);
                g.drawRect(x_d, y_d, 1, 1);
            }
            r += 0.001;
        }

        // 1 / tan(x)
        Mirilla(0.66, 0.5, 1, 1);
        Ventana(-2 * Math.PI, -3, 2 * Math.PI, 3);
        g.setColor(Color.BLUE);
        marco(g);
        ejes(g);
        for (double x = -10; x <= 10; x += 0.001) {
            double y = 2 * x * x + 3 * x * x * x + 1;
            if (in_window(x, y)) {
                int xd = CoorDX(x);
                int yd = CoorDY(y);
                g.drawRect(xd, yd, 1, 1);
            }
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


    }
}