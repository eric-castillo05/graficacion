package org.example;

import javax.swing.*;
import java.awt.*;

public class Main extends JFrame {
    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D g2d = (Graphics2D) g;
        // f8fcd7 // sky color
        Color skyColor = Color.decode("#f8fcd7");
        g.setColor(skyColor);
        g.fillRect(0, 0, 1000, 390);

        Color skinColor = Color.decode("#fdceae");
        Color grassColor1 = Color.decode("#7fc2b0");
        Color grassColor2 = Color.decode("#509a81");
        Color grassColor3 = Color.decode("#105a41");
        Color bodyColor = Color.decode("#b3b3a5");

        // background
        // Grass 1
        g.setColor(grassColor1);
        g.fillRect(0, 390, 1000, 500);
        // Grass 2
        g.setColor(grassColor2);
        g.fillRect(0, 700, 1000, 100);

        //shadow body
        g.setColor(grassColor3);
        g.fillOval(370, 720, 100, 40);

        // ear
        g.drawOval(515, 330, 40, 50);

        // head
        g.setColor(skinColor);
        g.fillRect(270, 200, 250, 200);
        g.setColor(Color.BLACK);
        g.drawRect(270, 200, 250, 200);

        // feet
        // right
        g.setColor(Color.BLACK);
        g.drawOval(400, 535, 40, 40);
        g.fillOval(400, 535, 40, 40);
        g.setColor(grassColor1);
        g.drawRect(425, 535, 40, 40);
        g.fillRect(425, 535, 40, 40);
        //left
        g.setColor(Color.BLACK);
        g.drawOval(430, 535, 40, 40);
        g.fillOval(430, 535, 40, 40);
        g.setColor(grassColor1);
        g.drawRect(455, 535, 40, 40);
        g.fillRect(455, 535, 40, 40);

        // body
        g.setColor(Color.BLACK);
        g.drawRect(370, 400, 100, 150);
        g.setColor(bodyColor);
        g.fillRect(370, 400, 100, 150);

        // corona
        g.setColor(Color.GRAY);
        g.drawPolygon(new int[] {490, 520, 520}, new int[] {170, 170, 110}, 3);
        g.fillPolygon(new int[] {490, 520, 520}, new int[] {170, 170, 110}, 3);


        // eyes with sunglasses
        g.setColor(Color.BLACK);
        // right eye
        g.drawOval(265, 250, 85, 70);
        g.fillOval(265, 250, 85, 70);
        // left eye
        g.drawOval(350, 250, 85, 70);
        g.fillOval(350, 250, 85, 70);



        // face fill
        g.setColor(skinColor);
        g.fillRect(270, 230, 250, 50);
        // face outline
        g.setColor(Color.BLACK);
        g.drawRect(270, 200, 250, 200);

        // ear fill
        g.setColor(skinColor);
        g.fillOval(515, 330, 40, 50);

        g.setColor(Color.BLACK);
        // eybrows
        Graphics2D g2d_r_eyebrows = (Graphics2D) g2d.create();
        int x, y, w, h;
        // right
        x = 270;
        y = 260;
        w = 70;
        h = 20;
        g2d_r_eyebrows.rotate(Math.toRadians(10), x+w/2.0, y+h/2.0);
        g2d_r_eyebrows.fillRect(x, y, w, h);
        g2d_r_eyebrows.drawRect(x, y, w, h);
        g2d_r_eyebrows.dispose();

        // left
        Graphics2D g2d_l_eyebrows = (Graphics2D) g2d.create();
        x = 360;
        y = 260;
        w = 70;
        h = 20;
        g2d_l_eyebrows.rotate(Math.toRadians(-10), x+w/2.0, y+h/2.0);
        g2d_l_eyebrows.drawRect(x, y, w, h);
        g2d_l_eyebrows.fillRect(x, y, w, h);
        g2d_l_eyebrows.dispose();


        // nose
        g.setColor(Color.BLACK);
//        g.drawPolygon(new int[] {330, 355, 360}, new int[] {300, 300, 320}, 3);
        g.drawLine(330, 300, 355, 300);
        g.drawLine(330, 300, 360, 320);
        g.setColor(skinColor);
        g.fillPolygon(new int[] {330, 355, 360}, new int[] {300, 300, 320}, 3);

        // mouth
        g.setColor(Color.BLACK);
        g.drawLine(360, 330, 355, 350);
        g.drawLine(355, 350, 390, 350);



        // hair
        g.setColor(Color.BLACK);
        g.fillOval(260, 120, 100, 100);
        g.setColor(skyColor);
        g.fillOval(300, 100, 110, 110);



        g.setColor(Color.BLACK);
        g.fillOval(290, 140, 100, 100);
        g.setColor(skyColor);
        g.fillOval(320, 130, 90, 70);



        // fill head
        g.setColor(skinColor);
        g.fillRect(270, 200, 250, 40);
        // outline head
        g.setColor(Color.BLACK);
        g.drawRect(270, 200, 250, 200);

        // side hair
        g.setColor(Color.BLACK);
        g.fillRect(270, 179, 250, 22);
        g.fillOval(470, 180, 100, 145);

        // fill side hair
        g.setColor(skyColor);
        g.fillRect(520, 177, 909, 149);
        // sunglasses
        g.setColor(Color.BLACK);
        g.drawRect(270, 280, 290, 20);
        g.fillRect(270, 280, 290, 20);







    }

    public Main() {
        setTitle("Tarea 2");
        setSize(1000, 800);
        setLocationRelativeTo(null);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
    public static void main(String[] args) {
        Main main = new Main();

    }
}