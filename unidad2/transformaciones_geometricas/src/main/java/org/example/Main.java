package org.example;
import tiburcio.lib2D.m2D;
import tiburcio.lib2D.obj2D;
import tiburcio.lib2D.s2D;

import java.awt.*;

public class Main extends s2D {

    public Main() {
        DEF_SISTEMA("Transformaciones geometricas", 600, 600, Color.BLACK);
    }

    public void paint(Graphics g) {
        MIRILLA(0, 0, 1, 1);
        VENTANA(-10, -10, 10, 10);
        g.setColor(Color.GREEN);
        ejes(g);
        obj2D tr = new obj2D("/home/eric/Documents/dev/graficacion/unidad2/transformaciones_geometricas/src/main/java/org/example/triangulo.txt");
        g.setColor(Color.YELLOW);
        dibObj2D(tr, g);
//        m2D ref = new m2D();
//        for (double ang = 0; ang < 360; ang+=20){
//            ref.rotacion(ang);
//            obj2D tri2 = tr.transforma(ref);
//            dibObj2D(tri2, g);
//            g.setColor(Color.red);
//            dibObj2D(tri2, g);
//            try {
//                Thread.sleep(100);
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//            g.setColor(Color.black);
//            dibObj2D(tri2, g);
//        }
//        g.setColor(Color.GREEN);
//        ref.rotacion(-45);
//        obj2D triref = tr.transforma(ref);
//        dibObj2D(triref, g);
//TIP rotacion respecto a un eje
//        m2D mat = new m2D();
//        m2D mt1 = new m2D();
//        mt1.traslacion(-6, -4);
//        m2D mt2 = new m2D();
//        mt2.traslacion(6, 4);
//        m2D mtc = new m2D();
//        for (double ang = 0; ang < 360; ang+=15){
//            mat.rotacion(ang);
//            mtc = mt1.multiplica(mat).multiplica(mt2);
//            obj2D tri2 = tr.transforma(mtc);
//            dibObj2D(tri2, g);
//            g.setColor(Color.YELLOW);
//            dibObj2D(tri2, g);
//            try {
//                Thread.sleep(100);
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//            g.setColor(Color.black);
//            dibObj2D(tri2, g);
//        }
        m2D mt1 = new m2D();
        mt1.escalacion(0, 0);
        m2D mt2 = new m2D();
        mt2.escalacion(0, 0);
        m2D mtc = new m2D();
        m2D mtesc = new m2D();
        for (double esc = 1; esc < 10; esc += 0.1){
            mtesc.escalacion(esc, esc);
            mtc =  mt1.multiplica(mtesc).multiplica(mt2);
            obj2D tri2 = tr.transforma(mtc);
            dibObj2D(tri2, g);
            g.setColor(Color.YELLOW);
            dibObj2D(tri2, g);
            try {
                Thread.sleep(50);
            } catch (Exception e) {
                e.printStackTrace();
            }
            g.setColor(Color.black);
            dibObj2D(tri2, g);
        }


    }
    public static void main(String[] args) {
        Main m = new Main();
    }
}