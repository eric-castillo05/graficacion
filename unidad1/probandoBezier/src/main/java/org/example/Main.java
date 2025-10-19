package org.example;

import javax.swing.*;
import java.awt.*;

public class Main extends JFrame {

    public void dibujaBezierD(int x[], int y[], int n, Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        double dt = 1.0 / n;
        double A, B, C, D;
        double t = 0, t2, t3;
        int dx[] = new int[n+1];
        int dy[] = new int[n+1];
        for (int i = 0; i <= n; i++) {
            t3 = t * t * t;
            t2 = t * t;
            A = -t3 + 3 * t2 - 3 * t + 1;
            B = 3 * t3 - 6 * t2 + 3 * t;
            C = -3 * t3 + 3 * t2;
            D = t3;
            dx[i] = (int)(A * x[0] + B * x[1] + C * x[2] + D * x[3]);
            dy[i] = (int)(A * y[0] + B * y[1] + C * y[2] + D * y[3]);
            t += dt;
        }
        g2.setStroke(new BasicStroke(1));
        for (int i = 0; i < n; i++) {
            g2.drawLine(dx[i], dy[i], dx[i + 1], dy[i + 1]);
        }
    }

    public void paint(Graphics g) {
        int x[] = {0, 200, 600, 799};
        int y[] = {0, 300, 300, 0};
        g.setColor(Color.RED);
        dibujaBezierD(x, y, 100, g);

        g.setColor(Color.BLUE);
        int x2[] = {0, 200, 799, 799};
        int y2[] = {0, 300, 300, 0};
        dibujaBezierD(x2, y2, 100, g);

        g.setColor(Color.MAGENTA);
        int x3[] = {0, 200, 600, 799};
        int y3[] = {300, 599, 0, 300};
        dibujaBezierD(x3, y3, 100, g);
    }

    public Main() {
        setTitle("Bezier");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        setLocationRelativeTo(null);
    }
    public static void main(String[] args) {
        Main main = new Main();
    }
}