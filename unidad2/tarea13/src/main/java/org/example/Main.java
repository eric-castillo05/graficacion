package org.example;

import tiburcio.lib3D.obj3D;
import tiburcio.lib3D.s3D;
import tiburcio.lib3D.v3D;

import java.awt.*;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Main extends s3D {
    public Main(){
        DEF_SISTEMA("Transformaciones 3d", 800, 800, Color.BLACK, 45, 45, 1, 400, 400);
    }

    public obj3D createTriangle(double x0,  double y0, double z0, double x1, double y1, double z1, double x2, double y2, double z2){
        obj3D triangle = new obj3D(3, 3);

        triangle.vertice[0] = new v3D(x0, y0, z0);
        triangle.vertice[1] = new v3D(x1, y1, z1);
        triangle.vertice[2] = new v3D(x2, y2, z2);

        triangle.arista[0][0] = 0;
        triangle.arista[0][1] = 1;

        triangle.arista[1][0] = 1;
        triangle.arista[1][1] = 2;

        triangle.arista[2][0] = 2;
        triangle.arista[2][1] = 0;

        return triangle;
    }

    public void paint(Graphics g){
        ejes3D(Color.CYAN, g);
        try (FileReader fr = new FileReader("/home/eric/Documents/dev/graficacion/unidad2/tarea13/src/main/java/org/example/ship_aristas.txt")) {
            BufferedReader br = new BufferedReader(fr);
            String linea = br.readLine();
            int ntri = Integer.parseInt(linea);
            System.out.println(ntri);
            for (int i = 1; i <= ntri; i++) {
                double x0 = 0, y0 = 0, z0 = 0;
                double x1 = 0, y1 = 0, z1 = 0;
                double x2 = 0, y2 = 0, z2 = 0;
                for (int v = 0; v < 3; v++) {
                    linea = br.readLine();
                    String valores[] = linea.split(",");
                    double x = Double.parseDouble(valores[0]);
                    double y = Double.parseDouble(valores[1]);
                    double z = Double.parseDouble(valores[2]);
                    if (v == 0){
                        x0 = x;
                        y0 = y;
                        z0 = z;
                    } else if (v == 1){
                        x1 = x;
                        y1 = y;
                        z1 = z;
                    } else if (v == 2){
                        x2 = x;
                        y2 = y;
                        z2 = z;
                    }
                }
                System.out.println(x0 + " " + y0 + " " + z0);
                System.out.println(x1 + " " + y1 + " " + z1);
                System.out.println(x2 + " " + y2 + " " + z2);
                dibObj3D(createTriangle(x0, y0, z0, x1, y1, z1, x2, y2, z2), g);

            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
    public static void main(String[] args) {
        Main main = new Main();
    }
}