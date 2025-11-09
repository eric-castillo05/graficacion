package org.example;

import tiburcio.lib3D.m3D;
import tiburcio.lib3D.obj3D;
import tiburcio.lib3D.s3D;

import java.awt.*;

public class Main extends s3D {
    public Main() {
        DEF_SISTEMA("Transformaciones 3d", 800, 800, Color.BLACK, 45, 45, 1, 400, 400);
    }

    public void paint(Graphics g) {
        ejes3D(Color.CYAN, g);
        obj3D cubo = new obj3D("/home/eric/Documents/dev/graficacion/unidad2/examenu3/src/main/java/org/example/fig.txt");
        m3D esc = new m3D();
        esc.escalacion(40, 40, 40);
        obj3D fig_esc = cubo.transforma(esc);
        dibObj3D(fig_esc, g);
        m3D t1 = new m3D();
        t1.traslacion(-3, 0, -1);
        g.setColor(Color.RED);
        obj3D fig_t1 = cubo.transforma(t1).transforma(esc);
//        dibObj3D(fig_t1, g);
        g.setColor(Color.GREEN);
        m3D t2 = new m3D();
        t2.escalacion(0.5, 1, 2);
        obj3D fig_t2 = cubo.transforma(t1).transforma(t2).transforma(esc);
//        dibObj3D(fig_t2, g);
        g.setColor(Color.YELLOW);
        m3D t3 = new m3D();
        t3.rotacionZ(-90);
        obj3D fig_t3 = cubo.transforma(t1).transforma(t2).transforma(t3).transforma(esc);
        dibObj3D(fig_t3, g);
        g.setColor(Color.RED);
        m3D t4 = new m3D();
        t4.reflexionYZ();
        obj3D fig_t4 = cubo.transforma(t1).transforma(t2).transforma(t3).transforma(t4).transforma(esc);
        dibObj3D(fig_t4, g);

        g.setColor(Color.MAGENTA);
        m3D t5 = new m3D();
        t5.reflexionXY();
        obj3D fig_t5 = cubo.transforma(t1).transforma(t2).transforma(t3).transforma(t4).transforma(t5).transforma(esc);
        dibObj3D(fig_t5, g);

        g.setColor(Color.WHITE);
        m3D t6 = new m3D();
        t6.traslacion(0, 0, -1);
        obj3D fig_t6 = cubo.transforma(t1).transforma(t2).transforma(t3).transforma(t4).transforma(t5).transforma(t6).transforma(esc);
        dibObj3D(fig_t6, g);

    }
    public static void main(String[] args) {
        Main main = new Main();

    }
}