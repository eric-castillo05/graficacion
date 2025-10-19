package org.example;

import javax.swing.*;
import java.awt.*;

public class Main extends JPanel {

    // Profundidad del Sierpinski (aumenta para más detalle, ojo con el rendimiento)
    private int profundidad = 10;

    public Main() {
        setBackground(Color.BLACK);
    }

    // Dibuja el triángulo de Sierpinski.
    private void drawSierpinski(Graphics2D g2,
                                int x1, int y1,
                                int x2, int y2,
                                int x3, int y3,
                                int depth) {
        if (depth == 0) {
            // Rellenar el triángulo base
            int[] xs = {x1, x2, x3};
            int[] ys = {y1, y2, y3};
            g2.fillPolygon(xs, ys, 3);
            return;
        }

        // Calcular puntos medios
        int mx12 = (x1 + x2) / 2;
        int my12 = (y1 + y2) / 2;

        int mx23 = (x2 + x3) / 2;
        int my23 = (y2 + y3) / 2;

        int mx31 = (x3 + x1) / 2;
        int my31 = (y3 + y1) / 2;

        // Llamadas recursivas para los 3 sub-triángulos
        drawSierpinski(g2, x1, y1, mx12, my12, mx31, my31, depth - 1);
        drawSierpinski(g2, x2, y2, mx23, my23, mx12, my12, depth - 1);
        drawSierpinski(g2, x3, y3, mx31, my31, mx23, my23, depth - 1);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        // Preparar Graphics2D
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);

        // Color del triángulo
        g2.setColor(Color.GREEN);

        // Coordenadas del triángulo grande (ajusta margenes/posición si quieres)
        int width = getWidth();
        int height = getHeight();

        // Triángulo equilátero centrado en la parte superior/central del panel
        int padding = 40;
        int x1 = width / 2;
        int y1 = padding; // vértice superior

        int side = Math.min(width, height) - padding * 2;
        // Vértices de la base
        int x2 = (width - side) / 2;
        int y2 = padding + (int) (Math.sqrt(3) / 2 * side);

        int x3 = x2 + side;
        int y3 = y2;

        drawSierpinski(g2, x1, y1, x2, y2, x3, y3, profundidad);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Sierpinski Gasket");
            Main panel = new Main();
            frame.add(panel);
            frame.setSize(800, 700);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        });
    }
}
