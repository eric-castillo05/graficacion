package org.example;

import javax.swing.*;
import java.awt.*;

public class Main extends JFrame {

    public void paint(Graphics g) {
        g.setColor(Color.RED);
        bresCircle(450, 160, 120, g);
        g.setColor(Color.BLUE);
        bresCircle(400, 200, 100, g);
        g.setColor(Color.MAGENTA);
        bresCircle(350, 240, 100, g);
        g.setColor(Color.YELLOW);
        bresCircle(325, 280, 100, g);
        g.setColor(Color.CYAN);
        bresCircle(350, 340, 100, g);
        g.setColor(Color.ORANGE);
        bresCircle(400, 390, 75, g);
        g.setColor(Color.GREEN);
        bresCircle(370, 390, 20, g);
        bresCircle(430, 390, 20, g);

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

        for (float theta = 0; theta < 2 * Math.PI; theta += 0.0125){
            double x_1 = centerX + radius * Math.cos(theta);
            double y_1 = centerY + radius * Math.sin(theta);
            g.drawLine((int) centerX, (int) centerY, (int) x_1, (int) y_1);
        }
    }

    public Main() {
        setSize(600, 600);
        setTitle("Algoritmos de lineas");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }
    public static void main(String[] args) {
        Main main = new Main();
    }
}