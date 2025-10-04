package org.example;
import javax.swing.*;
import java.awt.*;

public class Main extends JFrame {

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

    public void paint(Graphics g){
        int x[] = {300, 200, 250, 300, 350, 400};
        int y[] = {400, 100, 40, 100, 40, 100};
        int points = 6;
        poligonoDDA(x,y,points,g);
        poligonoBres(x,y,points,g);
    }

    public void poligonoDDA(int[] x, int[] y, int points, Graphics g){
        for(int i = 1; i < points; ++i) {
            lineaDDA(x[i], y[i], x[i-1], y[i-1], g);
        }
        lineaDDA(x[0], y[0], x[points-1], y[points-1], g);
    }

    public void poligonoBres(int[] x, int[] y, int points, Graphics g){
        for(int i = 1; i < points; ++i) {
            lineaBres(x[i], y[i], x[i-1], y[i-1], g);
        }
        lineaBres(x[0], y[0], x[points-1], y[points-1], g);
    }

    public Main() {
        setSize(600, 600);
        setTitle("Poligonos");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public static void main(String[] args) {
        Main main = new Main();

    }
}