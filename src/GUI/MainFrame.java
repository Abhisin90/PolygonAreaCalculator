package GUI;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import java.awt.*;

public class MainFrame {
    public static void main(String[] args) {
        // Frame
        JFrame frame = new JFrame("POLYNOMIAL AREA CALCULATOR");
        frame.setSize(800, 800);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // container
        Container c=frame.getContentPane();
        c.setBackground(Color.white);
        c.setBackground(Color.decode("#61E7C7"));

        //Menubar


        ImageIcon icon1=new ImageIcon(MainFrame.class.getResource("back.png"));
        JButton back=new JButton(icon1);
        back.setBounds(0,0,50,50);
        back.setBackground(Color.white);
        back.setBorderPainted(false);
        c.add(back);


        ImageIcon icon2=new ImageIcon(MainFrame.class.getResource("setting.png"));
        JButton setting=new JButton(icon2);
        setting.setBounds(650,-1,50,50);
        setting.setBackground(Color.white);
        setting.setBorderPainted(false);
        c.add(setting);


        ImageIcon icon3=new ImageIcon(MainFrame.class.getResource("about.png"));
        JButton about=new JButton(icon3);
        about.setBounds(730,-1,50,50);
        about.setBackground(Color.white);
        about.setBorderPainted(false);
        c.add(about);





        //Side Panel
        JPanel side=new JPanel();
        side.setBackground(Color.decode("#61E7C7"));
        side.setBounds(580,0,220,800);

        //Reset Button

        JButton Reset=new JButton("RESET");
        Font font1=new Font("Arial",Font.BOLD,50);
        Reset.setFont(font1);
        Reset.setFocusPainted(false);
        Reset.setBackground(Color.decode("#6AD8F0"));
        Reset.setBounds(580,650,220,80);
        frame.add(Reset);

        // AREA TEXT FIELD
        JLabel area=new JLabel("AREA");
        area.setBounds(580,60,200,50);
        Font font2=new Font("Arial Rounded MT Bold",Font.BOLD,24);
        area.setFont(font2);
        c.add(area);

        JTextField area1=new JTextField("40000 m^2");
        area1.setFont(font2);
        area1.setBounds(580,100,220,70);
        area1.setBackground(Color.decode("#F8E2C2"));
        area1.setBorder(new BevelBorder(BevelBorder.LOWERED));
        c.add(area1);


        // EDGE TEXT FIELD
        JLabel edge=new JLabel("EDGE LENGTH");
        edge.setBounds(580,180,220,50);
        edge.setFont(font2);
        c.add(edge);

        JTextField edge1=new JTextField("40000 m^2");
        edge1.setFont(font2);
        edge1.setBounds(580,220,220,140);
        edge1.setBackground(Color.decode("#F8E2C2"));
        edge1.setBorder(new BevelBorder(BevelBorder.LOWERED));
        c.add(edge1);


        // ANGLE TEXT FIELD
        JLabel angle=new JLabel("EDGE LENGTH");
        angle.setBounds(580,370,220,50);
        angle.setFont(font2);
        c.add(angle);

        JTextField angle1=new JTextField("40000 m^2");
        angle1.setFont(font2);
        angle1.setBounds(580,410,220,140);
        angle1.setBackground(Color.decode("#F8E2C2"));
        angle1.setBorder(new BevelBorder(BevelBorder.LOWERED));
        c.add(angle1);

        //frame.add(side);
        //frame.add(menu);



        //Middle Panel
        JPanel panel=new JPanel();
        

        frame.setLayout(null);
        frame.setVisible(true);
    }
}
