package org.example;

import tiburcio.lib3D.obj3D;
import tiburcio.lib3D.s3D;

import java.awt.*;

public class Main extends s3D {
    public Main(){
        DEF_SISTEMA("Transformaciones 3d", 800, 800, Color.BLACK, 45, 45, 1, 400, 400);
    }

    public void paint(Graphics g){
        ejes3D(Color.CYAN, g);
        obj3D ship = new obj3D("/home/eric/Documents/dev/graficacion/unidad2/tarea13/src/main/java/org/example/ship_aristas.txt");
        g.setColor(Color.RED);
        dibObj3D(ship, g);

    }
    public static void main(String[] args) {
        Main main = new Main();
    }
}