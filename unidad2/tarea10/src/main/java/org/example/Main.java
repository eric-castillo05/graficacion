package org.example;
import tiburcio.lib2D.m2D;
import tiburcio.lib2D.obj2D;
import tiburcio.lib2D.s2D;
import java.awt.*;
public class Main extends s2D{
    public Main(){
        DEF_SISTEMA("Transformaciones geometricas", 600, 600, Color.BLACK);
    }
    public void paint(Graphics g) {
        MIRILLA(0, 0, 1, 1);
        VENTANA(-600, -600, 600, 600);
        g.setColor(Color.WHITE);
        ejes(g);
        obj2D motorcycle = new obj2D("/home/eric/Documents/dev/graficacion/unidad2/tarea10/src/main/java/org/example/motocycle.txt");
        obj2D tier = new obj2D("/home/eric/Documents/dev/graficacion/unidad2/tarea10/src/main/java/org/example/tier.txt");
        g.setColor(Color.CYAN);
        for (int i = 0; i < 200; ++i) {
            m2D t = new m2D();
            t.traslacion(i, 0);

            g.setColor(Color.RED);
            obj2D motorcycle_t = motorcycle.transforma(t);
            dibObj2D(motorcycle_t, g);

            double cx = 300, cy = 70;
            double angle = i * -5;
            m2D toOrigin = new m2D();
            toOrigin.traslacion(-cx, -cy);
            m2D rotate = new m2D();
            rotate.rotacion(angle);
            m2D back = new m2D();
            back.traslacion(cx, cy);
            m2D mtc = toOrigin.multiplica(rotate).multiplica(t).multiplica(back);
            obj2D tier_t = tier.transforma(mtc);
            dibObj2D(tier_t, g);
            try {
                Thread.sleep(5);
            } catch (Exception e) {}
//            if (i != 198) {
//                g.setColor(Color.BLACK);
//                dibObj2D(tier_t, g);
//                dibObj2D(motorcycle_t, g);
//            }
            g.setColor(Color.BLACK);
            dibObj2D(tier_t, g);
            dibObj2D(motorcycle_t, g);
            g.setColor(Color.WHITE);
            ejes(g);

        }
        ejes(g);
        for (int i = -30; i >= -90; --i) {
            g.setColor(Color.CYAN);

            double cx = 330 - 199, cy = 105;

            m2D rotation1 = new m2D();
            rotation1.rotacion(i);

            m2D trans1 = new m2D();
            trans1.traslacion(cx, cy);

            m2D mtc = rotation1.multiplica(trans1);
            obj2D motorcycle_t = motorcycle.transforma(mtc);
            dibObj2D(motorcycle_t, g);


            m2D rotate = new m2D();
            obj2D tier_t = tier.transforma(mtc);
            dibObj2D(tier_t, g);

            try {
                Thread.sleep(10);
            } catch (Exception e) {}
                g.setColor(Color.BLACK);
                dibObj2D(motorcycle_t, g);
                dibObj2D(tier_t, g);


        }
        double cx = 330 - 199, cy = 105;

        for (double i = 0; i <= 10; i+=0.1) {
            g.setColor(Color.GREEN);

            m2D rot1 = new m2D();
            rot1.rotacion(-90);

            m2D trans1 = new m2D();
            trans1.traslacion(cx, cy);

            m2D trans2 = new m2D();
            trans2.traslacion(0, cy - i);

            m2D esc1 = new m2D();
            esc1.escalacion(1 - (i / 500), 1 - (i / 500));

            m2D mtc = trans1.multiplica(rot1).multiplica(esc1).multiplica(trans2);

            obj2D motorcycle_t = motorcycle.transforma(mtc);
            dibObj2D(motorcycle_t, g);

            double angle = i * 5;
            double tx = -90, ty = -60;

            m2D toOrigin = new m2D();
            toOrigin.traslacion(-tx, -ty);
            m2D rotate = new m2D();
            rotate.rotacion(angle);
            m2D back = new m2D();
            back.traslacion(tx, ty);
            m2D mtc1 = toOrigin.multiplica(rot1).multiplica(esc1).multiplica(trans1).multiplica(back);
            obj2D tier_t = tier.transforma(mtc);
            dibObj2D(tier_t, g);

            try {
                Thread.sleep(20);
            } catch (Exception e) {}
            g.setColor(Color.BLACK);
            dibObj2D(motorcycle_t, g);
            dibObj2D(tier_t, g);
        }
        ejes(g);
        for (int i = 0; i < 200; ++i) {
            m2D t = new m2D();
            t.traslacion(i, 0);

            m2D refX = new m2D();
            refX.reflexionX();

            m2D refY = new m2D();
            refY.reflexionY();

            g.setColor(Color.CYAN);
            m2D mtcRef = t.multiplica(refX).multiplica(refY);
            obj2D motorcycle_t = motorcycle.transforma(mtcRef);
            dibObj2D(motorcycle_t, g);

            cx = 300; cy = 70;
            double angle = i * -5;
            m2D toOrigin = new m2D();
            toOrigin.traslacion(-cx, -cy);
            m2D rotate = new m2D();
            rotate.rotacion(angle);
            m2D back = new m2D();
            back.traslacion(cx, cy);
            m2D mtc = toOrigin.multiplica(rotate).multiplica(t).multiplica(back).multiplica(refX).multiplica(refY);
            obj2D tier_t = tier.transforma(mtc);
            dibObj2D(tier_t, g);
            try {
                Thread.sleep(10);
            } catch (Exception e) {}
//            if (i != 198) {
//                g.setColor(Color.BLACK);
//                dibObj2D(tier_t, g);
//                dibObj2D(motorcycle_t, g);
//            }
            g.setColor(Color.BLACK);
            dibObj2D(tier_t, g);
            dibObj2D(motorcycle_t, g);
            g.setColor(Color.WHITE);
            ejes(g);

        }



    }
    public static void main(String[] args) {
        Main main = new Main();
    }
}