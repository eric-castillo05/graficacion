package org.example;

import javax.swing.*;
import java.awt.*;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;

public class Main extends JFrame {

    public void paint(Graphics g){
        try {
            File f = new File("/home/eric/Documents/dev/graficacion/unidad1/imagenesTib/ojosm.tib");
            FileInputStream fis = new FileInputStream(f);
            BufferedInputStream b = new BufferedInputStream(fis);
            // read the first 8 bytes
            int bytes[] = new int[8];
            for (int i = 0; i < 8; i++) {
                bytes[i] = b.read();
            }
            for (int i = 0; i < 8; i++) {
                System.out.println(String.format("%c", bytes[i]));
            }
            int width, height, temp1, temp2;
            temp1 = b.read();
            temp2 = b.read();
            width = temp1 *  256 + temp2;
            temp1 = b.read();
            temp2 = b.read();
            height = temp1 * 256 + temp2;
            System.out.println(width + " " + height);
            setSize(width, height);

            for (int i = 0; i < height; ++i) {
                for (int j = 0; j < width; ++j) {
                    int red, green, blue;
                    red = b.read();
                    green = b.read();
                    blue = b.read();
                    System.out.println(red + " " + green + " " + blue);
                    // Normal Colors
//                    g.setColor(new Color(red, green, blue));
//                    g.fillRect(j, i, 1, 1);
                    // Gray Scale
//                    int gray = (red + green + blue) / 3;
//                    g.setColor(new Color(gray, gray, gray));
//                    g.fillRect(j, i, 1, 1);
                    // Negative Scale
//                    int gray = (red + green + blue) / 3;
//                    g.setColor(new Color(255 - gray, 255 - gray, 255 - gray));
//                    g.fillRect(j, i, 1, 1);
                    // Anohter negative
//                    g.setColor(new Color(255 - red, 255 - green, 255 - blue));
//                    g.fillRect(j, i, 1, 1);
                    // Binarizacion
//                    int gray = (red + green + blue) / 3;
//                    if (gray > 0 && gray <= 127){
//                        g.setColor(Color.black);
//                    } else {
//                        g.setColor(Color.white);
//                    }
//                    g.fillRect(j, i, 1, 1);

                    // binariazion negativo
//                    int gray = (red + green + blue) / 3;
//                    int nColor = gray <= 127 ? 0: 255;
//                    g.setColor(new Color(255 - nColor, 255 - nColor, 255 - nColor));
//                    g.fillRect(j, i, 1, 1);



                    // 1 Generar la imagen binarizada
//                    int gray = (red + green + blue) / 3;
//                    if (gray > 0 && gray <= 127){
//                        g.setColor(Color.black);
//                    } else {
//                        g.setColor(Color.white);
//                    }
//                    g.fillRect(j, i, 1, 1);

                    // 2 Imagen a 16 millones de colores
//                    g.setColor(new Color(red, green, blue));
//                    g.fillRect(j, i, 1, 1);
                    // 3 Imagen en la escala de grises
//                    int gray = (red + green + blue) / 3;
//                    g.setColor(new Color(gray, gray, gray));
//                    g.fillRect(j, i, 1, 1);

                    // 4 Negativo de la escala de grises
                    int gray = (red + green + blue) / 3;
                    g.setColor(new Color(255 - gray, 255 - gray, 255 -gray));
                    g.fillRect(j, i, 1, 1);



                }
            }



        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public Main(){
        setTitle("Bytes");
//        setSize(height, width);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
    public static void main(String[] args) {
        Main main = new Main();



    }
}