package org.example;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;

import javax.swing.JComponent;
import javax.swing.JFrame;


public class Main2 extends JFrame {
    static final int FRACTAL_WIDTH = 1000;
    static final int FRACTAL_HEIGHT = 1000;
    static ArrayList<FractalShape> fractalList = new ArrayList<FractalShape>();

    public static void main(String[] args) {
        JFrame frame = new JFrame("The Sierpiński Carpet");
        frame.setSize(1000, 1000);
        //frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setBackground(Color.ORANGE);
        CreateFractal(frame);
        frame.setVisible(true);


    }

    public static void CreateFractal(JFrame frame) {

        FractalRecursive(frame, 0, 0, FRACTAL_WIDTH / 3, FRACTAL_HEIGHT / 3);
    }

    private static void FractalRecursive(JFrame frame, int x, int y, int width, int height) {
        // Base case: stop recursion when the the width and height is <= 1
        if(width <= 1) {
            return;
        }

        // NOTE: We use (width * 3) instead of FRACTAL_WIDTH and (height * 3) instead of FRACTAL_HEIGHT because we might have a FRACTAL_WIDTH or FRACTAL_HEIGHT that is not fully divisible by 3
        // Therefore, we need to add x and y because width and height gets smaller and smaller rather than staying constant
        // so basically, multiplying width and height by three every recursion WONT get you to FRACTAL_WIDTH or FRACTAL_HEIGHT, it will just get you a small value that will stop it short

        for(int f_x = x; f_x < (width * 3) + x; f_x += width) {
            for(int f_y = y; f_y < (height * 3) + y; f_y += height)  {

                // Exclude Middle
                if(f_x == (x + width) && f_y == (y + height)) {
                    continue;
                }

                FractalShape shape = new FractalShape(f_x, f_y, width, height);
                frame.getContentPane().add(shape);
                fractalList.add(shape);

                FractalRecursive(frame, f_x, f_y, width / 3, height / 3);
            }
        }
    }

}


class FractalShape extends JComponent{
    public int x;
    public int y;
    public int width;
    public int height;


    public FractalShape(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    public void paint(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;

        for(FractalShape fractal : Main2.fractalList) {
            g2.setColor(Color.RED);
            g2.drawRect(fractal.x, fractal.y, fractal.width, fractal.height);

        }
    }

}
