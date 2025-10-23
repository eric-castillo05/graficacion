package org.example;


import tiburcio.lib3D.m3D;
import tiburcio.lib3D.obj3D;
import tiburcio.lib3D.s3D;

import javax.swing.plaf.TableHeaderUI;
import java.awt.*;

public class Main extends s3D {
    public Main() {
        DEF_SISTEMA("Transformaciones 3d", 800, 800, Color.BLACK, 45, 0, 1, 400, 400);
    }
    public void paint(Graphics g) {
        ejes3D(Color.CYAN, g);
        obj3D cubo = new obj3D("/home/eric/Documents/dev/graficacion/unidad2/cubo/src/main/java/org/example/cubo.txt");
        g.setColor(Color.YELLOW);
        dibObj3D(cubo, g);
        m3D esc = new m3D();
        esc.escalacion(50, 50, 20);
        obj3D cubo_esc = cubo.transforma(esc);
        dibObj3D(cubo_esc, g);

        //TIP ref yz
        m3D ref_yz = new m3D();
        ref_yz.reflexionYZ();
        obj3D cubo_ref_yz = cubo_esc.transforma(ref_yz);
        g.setColor(Color.RED);
//        dibObj3D(cubo_ref_yz, g);

        //TIP ref xz
        m3D ref_xz = new m3D();
        ref_xz.reflexionXZ();
        obj3D cubo_ref_xz = cubo_esc.transforma(ref_xz);
        g.setColor(Color.GREEN);
//        dibObj3D(cubo_ref_xz, g);

        //TIP ref xy
        m3D ref_xy = new m3D();
        ref_xy.reflexionXY();
        obj3D cubo_ref_xy = cubo_esc.transforma(ref_xy);
        g.setColor(Color.MAGENTA);
//        dibObj3D(cubo_ref_xy, g);

        //TIP Rotacion
        m3D rot_y = new m3D();
//        for (double ang = 0; ang < 360; ang += 10){
//            g.setColor(Color.GREEN);
//            rot_y.rotacionY(ang);
//            obj3D cubo_rot_y = cubo_esc.transforma(rot_y);
//            dibObj3D(cubo_rot_y, g);
//            try {
//                Thread.sleep(100);
//            } catch (Exception e) {}
//            g.setColor(Color.BLACK);
//            dibObj3D(cubo_rot_y, g);
//        }
        ejes3D(Color.CYAN, g);

        m3D rot_x = new m3D();
//        for (double ang = 0; ang < 360; ang += 1){
//            g.setColor(Color.YELLOW);
//            rot_x.rotacionX(ang);
//            obj3D cubo_rot_x = cubo_esc.transforma(rot_x);
//            dibObj3D(cubo_rot_x, g);
//            try {
//                Thread.sleep(50);
//            } catch (Exception e) {}
//            g.setColor(Color.BLACK);
//            dibObj3D(cubo_rot_x, g);
//        }
        ejes3D(Color.CYAN, g);
        m3D rot_z = new m3D();
//        for (double ang = 0; ang < 360; ang += 1){
//            g.setColor(Color.RED);
//            rot_z.rotacionZ(ang);
//            obj3D cubo_rot_z = cubo_esc.transforma(rot_z);
//            dibObj3D(cubo_rot_z, g);
//            try {
//                Thread.sleep(20);
//            } catch (Exception e) {}
//            g.setColor(Color.BLACK);
//            dibObj3D(cubo_rot_z, g);
//        }

        //TIP Rotation from specific point
        m3D toOrigin = new m3D();
        toOrigin.traslacion(-100, 0, 0);
        m3D back = new m3D();
        back.traslacion(100, 0, 0);

//        for (double ang = 0; ang < 360; ang += 10){
//            g.setColor(Color.ORANGE);
//            m3D mtc = new m3D();
//            rot_y.rotacionY(ang);
//            mtc = toOrigin.multiplica(rot_y).multiplica(back);
//            obj3D cubo_rot_punto = cubo_esc.transforma(mtc);
//            dibObj3D(cubo_rot_punto, g);
//
//            try {
//                Thread.sleep(40);
//            } catch (Exception e) {}
//            g.setColor(Color.BLACK);
//            dibObj3D(cubo_rot_punto, g);
//        }

        for (double ang = 0; ang < 4; ang += 0.1){
            g.setColor(Color.ORANGE);
            m3D mtc = new m3D();
            esc.escalacion(ang, ang, ang);
            mtc = toOrigin.multiplica(esc).multiplica(back);
            obj3D cubo_rot_punto = cubo_esc.transforma(mtc);
            dibObj3D(cubo_rot_punto, g);

            try {
                Thread.sleep(40);
            } catch (Exception e) {}
            g.setColor(Color.BLACK);
            dibObj3D(cubo_rot_punto, g);
            ejes3D(Color.CYAN, g);
        }
    }
    public static void main(String[] args) {
        Main main = new Main();
    }
}