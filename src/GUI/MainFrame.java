package GUI;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import javax.swing.border.EtchedBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainFrame extends JFrame {
    // text fields
    private JTextArea angleText;
    private JTextField areaText;
    private JTextArea edgeText;

    public MainFrame() {
        // Frame
        JFrame frame = new JFrame("POLYGON AREA CALCULATOR");
        frame.setSize(800, 800);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // container
        Container c = frame.getContentPane();
        c.setBackground(Color.decode("#170055"));

        JLabel heading = new JLabel("POLYGON AREA CALCULATOR");
        c.add(heading);

        // Menu bar

        // Middle Panel

        angleText = new JTextArea("A : " + 90 + "\nB : " + 90 + "\nC : " + 90 + "\nD : " + 90);
        areaText = new JTextField("160000.00");
        edgeText = new JTextArea("AB : " + 400 + "\nBC : " + 400 + "\nCD : " + 400 + "\nDA : " + 400);

        ResizablePolygon panel = new ResizablePolygon(areaText, edgeText, angleText);
        panel.setBackground(Color.white);
        panel.setBounds(0, 55, 580, 750);
        panel.setLayout(new GridBagLayout());
        c.add(panel);

        ImageIcon icon1 = new ImageIcon(MainFrame.class.getResource("images/menu.png"));
        JButton back = new JButton(icon1);
        back.setBounds(0, 0, 50, 55);
        back.setBorder(new EtchedBorder(EtchedBorder.RAISED));
        back.setBackground(Color.decode("#61E7C8"));
        back.setBorderPainted(false);
        c.add(back);

        JPopupMenu menu = new JPopupMenu();
        menu.setPopupSize(150, 60);

        ImageIcon share1 = new ImageIcon(MainFrame.class.getResource("images/share.png"));
        Image image1 = share1.getImage(); // transform it
        Image new2 = image1.getScaledInstance(50, 50, java.awt.Image.SCALE_SMOOTH); // scale it smoothly
        ImageIcon newImageIcon1 = new ImageIcon(new2);
        JMenuItem share = new JMenuItem("Share", newImageIcon1);
        share.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ev) {
                try {
                    String url = "https://github.com/narayanaditya1007/PolygonAreaCalculator";
                    java.awt.Desktop.getDesktop().browse(java.net.URI.create(url));
                } catch (java.io.IOException e) {
                    System.out.println(e.getMessage());
                }
            }
        });

        menu.add(share);

        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                menu.show(back, 0, 0);
                menu.setBorderPainted(true);

            }
        });

        // Side Panel
        JPanel side = new JPanel();
        side.setBackground(Color.decode("#61E7C7"));
        side.setBounds(580, 0, 220, 800);

        // Reset Button
        JButton Reset = new JButton("RESET");
        Font font1 = new Font("Arial", Font.BOLD, 50);
        Reset.setFont(font1);
        Reset.setFocusPainted(false);
        Reset.setBackground(Color.decode("#6AD8F0"));
        Reset.setForeground(Color.white);
        Reset.setBounds(580, 560, 220, 80);
        frame.add(Reset);

        Reset.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                new MainFrame();
            }
        });

        // AREA TEXT FIELD
        JLabel area = new JLabel("AREA");
        area.setBounds(580, 60, 200, 50);
        Font font2 = new Font("Arial Rounded MT Bold", Font.BOLD, 24);
        area.setForeground(Color.white);
        area.setFont(font2);
        c.add(area);

        areaText.setFont(font2);
        areaText.setBounds(580, 100, 220, 70);
        areaText.setBackground(Color.decode("#F8E2C2"));
        areaText.setBorder(new BevelBorder(BevelBorder.LOWERED));
        c.add(areaText);

        // EDGE TEXT FIELD
        JLabel edge = new JLabel("EDGE LENGTH");
        edge.setBounds(580, 180, 220, 50);
        edge.setFont(font2);
        edge.setForeground(Color.white);
        c.add(edge);

        edgeText.setFont(font2);
        edgeText.setBounds(580, 220, 220, 140);
        edgeText.setBackground(Color.decode("#F8E2C2"));
        edgeText.setBorder(new BevelBorder(BevelBorder.LOWERED));
        c.add(edgeText);

        // ANGLE TEXT FIELD
        JLabel angle = new JLabel("ANGLES");
        angle.setBounds(580, 370, 220, 50);
        angle.setFont(font2);
        angle.setForeground(Color.white);
        c.add(angle);

        angleText.setFont(font2);
        angleText.setBounds(580, 410, 220, 140);
        angleText.setBackground(Color.decode("#F8E2C2"));
        angleText.setBorder(new BevelBorder(BevelBorder.LOWERED));
        c.add(angleText);

        frame.setLayout(null);
        frame.setVisible(true);
    }
}
