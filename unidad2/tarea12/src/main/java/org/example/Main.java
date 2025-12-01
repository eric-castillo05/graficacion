package org.example;

import tiburcio.lib3D.m3D;
import tiburcio.lib3D.obj3D;
import tiburcio.lib3D.s3D;

import java.awt.*;

public class Main extends s3D {
    public Main() {
        DEF_SISTEMA("Transformaciones 3d", 800, 800, Color.BLACK, 35, 35, 1, 400, 400);
    }

    public void paint(Graphics g) {
        ejes3D(Color.CYAN, g);

        obj3D figura = new obj3D("/home/eric/Documents/dev/graficacion/unidad2/tarea12/src/main/java/org/example/heart.txt");

        m3D esc = new m3D();
        esc.escalacion(10, 10, 10);
        obj3D figEsc = figura.transforma(esc);

        m3D refXY = new m3D(); refXY.reflexionXY();
        m3D refYZ = new m3D(); refYZ.reflexionYZ();
        m3D refXZ = new m3D(); refXZ.reflexionXZ();
        for (int i = 0; i <= 360; i += 1) {

            m3D t = new m3D();
            t.traslacion(i, i, i);

            obj3D trans = figEsc.transforma(t);

            g.setColor(Color.YELLOW);
            dibObj3D(trans, g);


            g.setColor(Color.BLACK);
            dibObj3D(trans, g);
            ejes3D(Color.CYAN, g);
            try { Thread.sleep(10); } catch (Exception e) {}

        }

        for (int ang = 0; ang < 360; ang += 1) {
            m3D es =  new m3D();
            es.escalacion(ang/100, ang/50, ang/20);
            m3D r = new m3D();
            r.rotacionY(ang);

            obj3D rotado = figEsc.transforma(r).transforma(es);

            g.setColor(Color.ORANGE);
            dibObj3D(rotado, g);


            g.setColor(Color.BLACK);
            dibObj3D(rotado, g);
            ejes3D(Color.CYAN, g);
            try { Thread.sleep(20); } catch (Exception e) {}

        }

        for (int ang = 0; ang < 360; ang += 1) {

            m3D rotX = new m3D();
            rotX.rotacionX(ang);

            m3D rotY = new m3D();
            rotY.rotacionY(ang);

            m3D rotZ = new m3D();
            rotZ.rotacionZ(ang);

            obj3D figXY = figEsc.transforma(refXY.multiplica(rotX));

            obj3D figYZ = figEsc.transforma(refYZ.multiplica(rotY));

            obj3D figXZ = figEsc.transforma(refXZ.multiplica(rotZ));

            g.setColor(Color.GREEN);
            dibObj3D(figXY, g);

            g.setColor(Color.CYAN);
            dibObj3D(figYZ, g);

            g.setColor(Color.MAGENTA);
            dibObj3D(figXZ, g);


            g.setColor(Color.BLACK);
            dibObj3D(figXY, g);
            dibObj3D(figYZ, g);
            dibObj3D(figXZ, g);
            ejes3D(Color.CYAN, g);
            try { Thread.sleep(20); } catch (Exception e) {}

        }
    }



    public static void main(String[] args) {
        Main main = new Main();
    }
}
