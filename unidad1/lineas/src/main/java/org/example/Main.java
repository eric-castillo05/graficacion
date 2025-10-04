package org.example;

import javax.swing.*;
import java.awt.*;
import java.util.Vector;

public class Main extends JFrame {

    public void paint(Graphics g) {
//        double start_time = System.currentTimeMillis();
//        g.setColor(Color.BLUE);
//        for (int i = 0; i < 100; i++) {
//            lineaDDA(0,0,300,599, g);
//            lineaDDA(0,599,300,0, g);
//        }
//        double end_time = System.currentTimeMillis();
//        System.out.println("Tiempo DDA: " + (end_time - start_time) +"\n");
//        g.setColor(Color.RED);
//        start_time = System.currentTimeMillis();
//        for (int i = 0; i < 100; i++) {
//            lineaBres(300, 599, 599, 0, g);
//            lineaBres(599, 599, 300, 0, g);
//        }
//        end_time = System.currentTimeMillis();
//        System.out.println("Tiempo BRES: " + (end_time - start_time) +"\n");
        g.setColor(Color.RED);
        bresCircle(300, 300, 100, g);
        g.setColor(Color.MAGENTA);
        for (float theta = 0; theta < 2 * Math.PI; theta += 0.00125) {
            double x = 300 + 90 * Math.cos(theta);
            double y = 300 - 90 * Math.sin(theta);
            g.drawLine(300,  300, (int) x, (int) y);
        }
        Vector<Double> X = new Vector<Double>();

        for (float a = 0; a < 360; a += 72){
            double x = 300 + 100 * Math.cos(a * Math.PI / 180);
            double y = 300 - 100 * Math.sin(a * Math.PI / 180);
            System.out.println("x: " + x + " " + "y: " +  y);
        }
        int x[] = {400, 303, 219, 219, 303};
        int y[] = {204, 241, 358, 395};
        g.drawPolygon(x,y,3);

    }

    private void bresCircle(int centerX, int centerY, int radius, Graphics g) {
        int x = 0;
        int y = radius;
        int d = 3 - 2 * radius;

        while (x <= y) {
            // Dibujar los octantes
            g.drawRect(centerX + x, centerY + y, 1, 1);
            g.drawRect(centerX - x, centerY + y, 1, 1);
            g.drawRect(centerX + x, centerY - y, 1, 1);
            g.drawRect(centerX - x, centerY - y, 1, 1);
            g.drawRect(centerX + y, centerY + x, 1, 1);
            g.drawRect(centerX - y, centerY + x, 1, 1);
            g.drawRect(centerX + y, centerY - x, 1, 1);
            g.drawRect(centerX - y, centerY - x, 1, 1);

//            try {
//                Thread.sleep(100);
//            } catch (InterruptedException e) {
//                throw new RuntimeException(e);
//            }

            if (d < 0) {
                d = d + 4 * x + 6;
            } else {
                d = d + 4 * (x - y) + 10;
                y--;
            }
            x++;
        }
    }
    public void lineaDDA(int x0, int y0, int x1, int y1, Graphics g){
        int dx = x1 - x0;
        int dy = y1 - y0;
        int steps = Math.max(Math.abs(dx), Math.abs(dy));

        float xIncrement = dx / (float) steps;
        float yIncrement = dy / (float) steps;

        float x = x0;
        float y = y0;

        for (int i = 0; i <= steps; i++) {
            g.drawRect(Math.round(x),Math.round(y),1,1);
            x += xIncrement;
            y += yIncrement;
        }
    }

    public void lineaBres(int x0, int y0, int x1, int y1, Graphics g){
        int dx = Math.abs(x1 - x0);
        int dy = Math.abs(y1 - y0);
        int sx = x0 < x1 ? 1 : -1;
        int sy = y0 < y1 ? 1 : -1;
        int err = dx - dy;

        while (true) {
            g.drawRect(x0,y0,1,1);
            if (x0 == x1 && y0 == y1) break;
            int e2 = 2 * err;
            if (e2 > -dy) {
                err -= dy;
                x0 += sx;
            }
            if (e2 < dx) {
                err += dx;
                y0 += sy;
            }
        }
    }

    public Main() {
        setSize(600, 600);
        setTitle("Algoritmos de lineas");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
//        setUndecorated(true);
        setVisible(true);
    }

    public static void main(String[] args) {
        Main main = new Main();
    }
}

