package org.example;

import tiburcio.lib2D.obj2D;
import tiburcio.lib2D.s2D;

import java.awt.*;

public class Main extends s2D {
    public Main() {
        DEF_SISTEMA("Camara sintetica sin perspectiva", 800, 800, Color.BLACK);
    }

    public void paint(Graphics g) {
        MIRILLA(0, 0, 1, 1);
        VENTANA(-200, -200, 200, 200);
        g.setColor(Color.white);
        ejes(g);
        obj2D cubo = new obj2D("/home/eric/Documents/dev/graficacion/camara_sintetica_sin_perspectiva/src/main/java/org/example/cubo.txt");
        g.setColor(Color.RED);
        dibObj2D(cubo, g);
    }
    public static void main(String[] args) {
        Main main = new Main();
    }
}