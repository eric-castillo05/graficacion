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
        g2.setStroke(new BasicStroke(2));
        for (int i = 0; i < n; i++) {
            g2.drawLine(dx[i], dy[i], dx[i + 1], dy[i + 1]);
        }
    }

    public void paint(Graphics g) {
        //int x[] = {0, 200, 600, 799};
        //int y[] = {0, 300, 300, 0};
        int x[] = {187, 135-70, 317+70, 375};
        int y[] = {160, 300+30, 380, 500};
        g.setColor(Color.RED);
        dibujaBezierD(x, y, 100, g);
        int x_1[] = {187, 150-100, 260+30, 240};
        int y_1[] = {160, 260, 260, 510};
        g.setColor(Color.black);
        dibujaBezierD(x_1, y_1, 100, g);

        int x_2[] = {180, 255, 300, 340};
        int y_2[] = {280, 230, 300+6, 320};
        g.setColor(Color.BLUE);
        dibujaBezierD(x_2, y_2, 100, g);

        int x_3[] = {180, 245, 270, 340};
        int y_3[] = {280, 310, 340+60, 320};
        g.setColor(Color.BLUE);
        dibujaBezierD(x_3, y_3, 100, g);


        int x_4[] = {125, 135, 190, 187};
        int y_4[] = {170, 115, 110, 160};
        g.setColor(Color.BLUE);
        dibujaBezierD(x_4, y_4, 100, g);

        int x_5[] = {125, 135, 190, 187};
        int y_5[] = {170, 115+30, 110+20, 160};
        g.setColor(Color.MAGENTA);
        dibujaBezierD(x_5, y_5, 100, g);


    }

    public Main() {
        setTitle("Bezier");
        setSize(500, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        setLocationRelativeTo(null);
    }
    public static void main(String[] args) {
        Main main = new Main();
    }
}