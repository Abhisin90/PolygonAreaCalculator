package GUI;

import Logic.Angle;
import Logic.Line;
import Logic.Polygon;
import Logic.Vertex;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.Rectangle2D;
import javax.swing.*;

public class ResizablePolygon extends JPanel {

    private java.awt.Polygon poly;
    private Rectangle2D[] vertices = new Rectangle2D[4];
    private Polygon p;
    private final int v_size = 8;

    public ResizablePolygon(JTextField areaText, JTextArea edgeText, JTextArea angleText) {
        Vertex[] v = {
                new Vertex(100, 100),
                new Vertex(500, 100),
                new Vertex(500, 500),
                new Vertex(100, 500)
        };

        p = new Polygon(v);
        for (int i = 0; i < 4; i++) {
            vertices[i] = new Rectangle2D.Double(p.getCorners()[i].getX(), p.getCorners()[i].getY(), v_size, v_size);
        }

        ShapeResizeHandler ada = new ShapeResizeHandler(areaText, edgeText, angleText);
        addMouseListener(ada);
        addMouseMotionListener(ada);
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        Graphics2D g1 = (Graphics2D) g;

        for (Rectangle2D vertex : vertices) {
            g1.fill(vertex);
        }

        int[] xs = new int[4];
        int[] ys = new int[4];
        for (int i = 0; i < 4; i++) {
            xs[i] = p.getCorners()[i].getX();
            ys[i] = p.getCorners()[i].getY();
        }

        poly = new java.awt.Polygon(xs, ys, 4);
        g2.draw(poly);
        g2.drawString("A", xs[0] - 10, ys[0] - 10);
        g2.drawString("B", xs[1] + 10, ys[1] - 10);
        g2.drawString("C", xs[2] + 18, ys[2] + 18);
        g2.drawString("D", xs[3] - 18, ys[3] + 18);
    }

    class ShapeResizeHandler extends MouseAdapter {
        private int pos = -1;
        private JTextField areaText;
        private JTextArea edgeText;
        private JTextArea angleText;

        public ShapeResizeHandler(JTextField areaText, JTextArea edgeText, JTextArea angleText) {
            this.areaText = areaText;
            this.edgeText = edgeText;
            this.angleText = angleText;
        }

        public void mousePressed(MouseEvent event) {
            Point p = event.getPoint();

            for (int i = 0; i < vertices.length; i++) {
                if (vertices[i].contains(p)) {
                    pos = i;
                    return;
                }
            }
        }

        public void mouseReleased(MouseEvent event) {
            pos = -1;

            // Area
            p.calculateArea();
            areaText.setText(" " + p.getArea());

            // Edge lengths
            Line[] sides = p.getSides();
            for (int i = 0; i < 4; i++) {
                sides[i].setLength();
            }
            double AB = sides[0].getLength();
            double BC = sides[1].getLength();
            double CD = sides[2].getLength();
            double DA = sides[3].getLength();
            edgeText.setText("AB : " + AB + "\nBC : " + BC + "\nCD : " + CD + "\nDA : " + DA);

            // Angles
            Angle[] angles = p.getAngles();
            for (int i = 0; i < 4; i++) {
                angles[i].setAngle();
            }
            double A = angles[0].getAngle();
            double B = angles[1].getAngle();
            double C = angles[2].getAngle();
            double D = angles[3].getAngle();
            angleText.setText("A : " + A + "\nB : " + B + "\nC : " + C + "\nD : " + D);

        }

        public void mouseDragged(MouseEvent event) {
            if (pos == -1)
                return;

            vertices[pos].setRect(event.getPoint().x, event.getPoint().y, vertices[pos].getWidth(),
                    vertices[pos].getHeight());

            Vertex[] v = p.getCorners();
            if (pos == 0) {
                v[0].setCoordinates(event.getPoint().x, event.getPoint().y);
            } else if (pos == 1) {
                v[1].setCoordinates(event.getPoint().x, event.getPoint().y);
            } else if (pos == 2) {
                v[2].setCoordinates(event.getPoint().x, event.getPoint().y);
            } else {
                v[3].setCoordinates(event.getPoint().x, event.getPoint().y);
            }

            poly.reset();

            int[] xs = new int[4];
            int[] ys = new int[4];
            for (int i = 0; i < 4; i++) {
                xs[i] = p.getCorners()[i].getX();
                ys[i] = p.getCorners()[i].getY();
            }

            poly = new java.awt.Polygon(xs, ys, 4);
            repaint();
        }
    }
}
