package GUI;

import Logic.Vertex;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import javax.swing.*;

public class Surface extends JPanel implements MouseMotionListener {
    private final int vertexSize = 22;
    private Rectangle[] vertices = new Rectangle[4];
    private Polygon polygon;
    private Logic.Polygon p;
    private int vIndex;
    private float pWidth = 4;
    private JButton areaButton;
    private final JButton resetButton = new JButton("RESET");

    public Surface(JFrame frame) {
        areaButton = new JButton();

        setSize(800, 600);
        setBackground(Color.WHITE);
        setLayout(new BorderLayout());

        Vertex[] v = new Vertex[4];
        v[0] = new Vertex(getWidth()/2-100, getHeight()/2-100);
        v[1] = new Vertex(getWidth()/2+100, getHeight()/2-100);
        v[2] = new Vertex(getWidth()/2+100, getHeight()/2+100);
        v[3] = new Vertex(getWidth()/2-100, getHeight()/2+100);

        p = new Logic.Polygon(v);
        int[] xs = new int[4];
        int[] ys = new int[4];
        for (int i=0; i<4; i++) {
            xs[i] = p.getCorners()[i].getX();
            ys[i] = p.getCorners()[i].getY();
        }

        p.calculateArea();
        polygon = new Polygon(xs, ys, 4);

        areaButton.setForeground(Color.DARK_GRAY);
        areaButton.setBackground(Color.LIGHT_GRAY);
        areaButton.setSize(200,50);
        add(areaButton, BorderLayout.PAGE_START);

        resetButton.setForeground(Color.DARK_GRAY);
        resetButton.setBackground(Color.LIGHT_GRAY);
        resetButton.setSize(200,50);
        add(resetButton, BorderLayout.PAGE_END);

        for (int i=0; i<4; i++) {
            Rectangle r = new Rectangle();
            int x = p.getCorners()[i].getX() - vertexSize/2;
            int y = p.getCorners()[i].getY() - vertexSize/2;
            r.setBounds(x,y,vertexSize,vertexSize);
            vertices[i] = r;
        }

        areaButton.setText("Area: " + p.getArea() + " unit\u00B2");

        resetButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.getContentPane().removeAll();
                Main page = new Main(frame,0);
                frame.getContentPane().add(page);
            }
        });

        addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                int x = e.getX();
                int y = e.getY();
                vIndex = getValidVertexIndex(x,y);
                if (getValidVertexIndex(x,y) >= 0) {
                    setCursor(Cursor.getPredefinedCursor(Cursor.CROSSHAIR_CURSOR));
                } else {
                    setCursor(Cursor.getDefaultCursor());
                }
            }
        });

        addMouseMotionListener(this);
    }

    public int getValidVertexIndex(int x, int y) {
        for (int i=0; i<4; i++) {
            if (vertices[i].contains(x,y)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.WHITE);

        for (int i=0; i<4; i++) {
            ((Graphics2D) g).draw(vertices[i]);
        }

        g.setColor(Color.BLACK);
        ((Graphics2D) g).setStroke(new BasicStroke(pWidth, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND));
        ((Graphics2D) g).draw(polygon);
        g.drawString(p.getAngles()[0].getAngle() + "\u00B0", p.getCorners()[0].getX() + 10, p.getCorners()[0].getY() + 25);
        g.drawString(p.getAngles()[1].getAngle() + "\u00B0", p.getCorners()[1].getX() - 45, p.getCorners()[1].getY() + 25);
        g.drawString(p.getAngles()[2].getAngle() + "\u00B0", p.getCorners()[2].getX() - 40, p.getCorners()[2].getY() - 15);
        g.drawString(p.getAngles()[3].getAngle() + "\u00B0", p.getCorners()[3].getX() + 10, p.getCorners()[3].getY() - 15);
        g.drawString(p.getSides()[0].getLength() + " units", p.getSides()[0].getMidPoint().getX() - 30, p.getSides()[0].getMidPoint().getY() - 10);
        g.drawString(p.getSides()[1].getLength() + " units", p.getSides()[1].getMidPoint().getX() + 10, p.getSides()[1].getMidPoint().getY() + 5);
        g.drawString(p.getSides()[2].getLength() + " units", p.getSides()[2].getMidPoint().getX() - 30, p.getSides()[2].getMidPoint().getY() + 20);
        g.drawString(p.getSides()[3].getLength() + " units", p.getSides()[3].getMidPoint().getX() - 80, p.getSides()[3].getMidPoint().getY() + 5);
        areaButton.setText(" Area: " + p.getArea() + " unit\u00B2");
    }

    public void mouseMoved(MouseEvent e) {
        int x = e.getX();
        int y = e.getY();

        if (getValidVertexIndex(x,y) >= 0)
            setCursor(Cursor.getPredefinedCursor(Cursor.CROSSHAIR_CURSOR));
        else
            setCursor(Cursor.getDefaultCursor());
    }

    public void mouseDragged(MouseEvent me) {
        int x = me.getX();
        int y = me.getY();

        if (getBounds().contains(x,y)) {
            if (vIndex >= 0) {

                Graphics g = getGraphics();
                ((Graphics2D) g).setStroke(new BasicStroke(pWidth, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND));
                g.setColor(Color.WHITE);
                ((Graphics2D) g).draw(polygon);
                g.drawString(p.getAngles()[0].getAngle() + "\u00B0", p.getCorners()[0].getX() + 10, p.getCorners()[0].getY() + 25);
                g.drawString(p.getAngles()[1].getAngle() + "\u00B0", p.getCorners()[1].getX() - 45, p.getCorners()[1].getY() + 25);
                g.drawString(p.getAngles()[2].getAngle() + "\u00B0", p.getCorners()[2].getX() - 40, p.getCorners()[2].getY() - 15);
                g.drawString(p.getAngles()[3].getAngle() + "\u00B0", p.getCorners()[3].getX() + 10, p.getCorners()[3].getY() - 15);
                g.drawString(p.getSides()[0].getLength() + " units", p.getSides()[0].getMidPoint().getX() - 30, p.getSides()[0].getMidPoint().getY() - 10);
                g.drawString(p.getSides()[1].getLength() + " units", p.getSides()[1].getMidPoint().getX() + 10, p.getSides()[1].getMidPoint().getY() + 5);
                g.drawString(p.getSides()[2].getLength() + " units", p.getSides()[2].getMidPoint().getX() - 30, p.getSides()[2].getMidPoint().getY() + 20);
                g.drawString(p.getSides()[3].getLength() + " units", p.getSides()[3].getMidPoint().getX() - 80, p.getSides()[3].getMidPoint().getY() + 5);
                areaButton.setText(" Area: " + p.getArea() + " unit\u00B2");

                p.getCorners()[vIndex].setCoordinates(x,y);

                for (int i = 0; i < 4; i++) {
                    p.getSides()[i].setLength();
                    p.getSides()[i].setMidPoint();
                }

                for (int i = 0; i < 4; i++) {
                    p.getAngles()[i].setAngle();
                }

                p.calculateArea();

                vertices[vIndex].x = (p.getCorners()[vIndex].getX() - vertexSize/2);
                vertices[vIndex].y = (p.getCorners()[vIndex].getY() - vertexSize/2);

                int[] xs = new int[4];
                int[] ys = new int[4];
                for (int i=0; i<4; i++) {
                    xs[i] = p.getCorners()[i].getX();
                    ys[i] = p.getCorners()[i].getY();
                }

                polygon = new Polygon(xs, ys, 4);
                ((Graphics2D) g).draw(vertices[vIndex]);

                g.setColor(Color.BLACK);
                ((Graphics2D) g).setStroke(new BasicStroke(pWidth, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND));
                ((Graphics2D) g).draw(polygon);
                g.drawString(p.getAngles()[0].getAngle() + "\u00B0", p.getCorners()[0].getX() + 10, p.getCorners()[0].getY() + 25);
                g.drawString(p.getAngles()[1].getAngle() + "\u00B0", p.getCorners()[1].getX() - 45, p.getCorners()[1].getY() + 25);
                g.drawString(p.getAngles()[2].getAngle() + "\u00B0", p.getCorners()[2].getX() - 40, p.getCorners()[2].getY() - 15);
                g.drawString(p.getAngles()[3].getAngle() + "\u00B0", p.getCorners()[3].getX() + 10, p.getCorners()[3].getY() - 15);
                g.drawString(p.getSides()[0].getLength() + " units", p.getSides()[0].getMidPoint().getX() - 30, p.getSides()[0].getMidPoint().getY() - 10);
                g.drawString(p.getSides()[1].getLength() + " units", p.getSides()[1].getMidPoint().getX() + 10, p.getSides()[1].getMidPoint().getY() + 5);
                g.drawString(p.getSides()[2].getLength() + " units", p.getSides()[2].getMidPoint().getX() - 30, p.getSides()[2].getMidPoint().getY() + 20);
                g.drawString(p.getSides()[3].getLength() + " units", p.getSides()[3].getMidPoint().getX() - 80, p.getSides()[3].getMidPoint().getY() + 5);
                areaButton.setText(" Area: " + p.getArea() + " unit\u00B2");

                g.dispose();
            }
        }
    }
}
