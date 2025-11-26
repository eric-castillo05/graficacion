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
        obj3D cubo = new obj3D("/home/eric/Documents/dev/graficacion/unidad2/tarea12/src/main/java/org/example/temp.tib");
        g.setColor(Color.YELLOW);
//        dibObj3D(cubo, g);

        // Escalación base
        m3D esc = new m3D();
        esc.escalacion(20, 20, 20);
        obj3D cubo_esc = cubo.transforma(esc);
//        dibObj3D(cubo_esc, g);

        // Reflexiones
        m3D ref_yz = new m3D();
        ref_yz.reflexionYZ();

        m3D ref_xz = new m3D();
        ref_xz.reflexionXZ();

        m3D ref_xy = new m3D();
        ref_xy.reflexionXY();

        // Rotaciones
        m3D rot_y = new m3D();
        m3D rot_x = new m3D();
        m3D rot_z = new m3D();

        // Traslaciones (para rotar desde punto específico)
        m3D toOrigin = new m3D();
        toOrigin.traslacion(-150, 0, 0);
        m3D back = new m3D();
        back.traslacion(150, 0, 0);

        for (double ang = 0; ang < 360; ang += 5) {
            g.setColor(Color.ORANGE);

            m3D esc_anim = new m3D();
//            esc_anim.escalacion(0.01 * ang, 0.01 * ang, 0.01 * ang);

            rot_x.rotacionX(ang);
            rot_y.rotacionY(ang);
            rot_z.rotacionZ(ang);

            m3D tras = new m3D();
            tras.traslacion(ang * -0.2, ang * 0.1, ang / 2);

            m3D mtc = new m3D();
            mtc = esc_anim
                    .multiplica(ref_yz)
                    .multiplica(rot_x)
                    .multiplica(ref_xy)
                    .multiplica(rot_y)
                    .multiplica(ref_xz)
                    .multiplica(rot_z)
//                    .multiplica(toOrigin)
                    .multiplica(tras);
//                    .multiplica(back);

            obj3D cubo_transf = cubo_esc.transforma(mtc);
            dibObj3D(cubo_transf, g);

            try {
                Thread.sleep(100);
            } catch (Exception e) {}

            g.setColor(Color.BLACK);
            dibObj3D(cubo_transf, g);
            ejes3D(Color.CYAN, g);
        }
    }

    public static void main(String[] args) {
        Main main = new Main();
    }
}
