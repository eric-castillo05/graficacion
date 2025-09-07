package org.example;

import javax.swing.*;
import java.awt.*;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;

public class Main extends JFrame {
    public void paint(Graphics g){
        g.setColor(Color.yellow);
        g.fillRect(0,0,600,600);

        g.setColor(Color.red);
        g.fillRect(75, 75, 1, 1);
        g.setColor(Color.blue);
        g.drawLine(0, 0, 599, 599);
        g.drawLine(0, 599, 599, 0);
        g.setColor(Color.magenta);
//        g.drawOval(200, 200, 200, 200);
        g.fillOval(200, 200, 200, 200);
        g.setColor(Color.black);
        g.fillOval(250, 250, 100, 100);
        int x[] = {0, 150, 300};
        int y[] = {599, 450, 599};
        g.fillPolygon(x, y, 3);


        /* Leer archivos byte by byte */
        try {
            File f = new File("/home/eric/Documents/dev/graficacion/unidad1/imagenesTib/ojos.tib");
            FileInputStream fis = new FileInputStream(f);
            BufferedInputStream b = new BufferedInputStream(fis);
            System.out.println("Success");
            int byte1 = b.read();
            int byte2 = b.read();
            System.out.println(String.format("%c", byte1) + "\n" + String.format("%c", byte2));
            b.close();
            fis.close();

        } catch (Exception e){
            System.out.println("Error " + e.getMessage());
        }

    }
    public Main() {
        setTitle("Ejemplo de un JFrame");
        setSize(600, 600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        setBackground(Color.yellow);


    }
    public static void main(String[] args) {
        Main main = new Main();
    }
}