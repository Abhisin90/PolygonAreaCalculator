package GUI;

import javax.imageio.IIOException;
import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.BevelBorder;
import javax.swing.border.EtchedBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class MainFrame extends JFrame
{

    public MainFrame() {
        // Frame
        JFrame frame = new JFrame("POLYGON AREA CALCULATOR");
        frame.setSize(800, 800);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);



        // container
        Container c=frame.getContentPane();
        //c.setBackground(Color.white);
        c.setBackground(Color.decode("#170055"));
        Font font3=new Font("ALGERIAN",Font.BOLD,50);

        JLabel heading=new JLabel("POLYGON AREA CALCULATOR");
       // heading.setFont(font3);
        //heading.setLocation(60,0);
        c.add(heading);
        //Menubar

        //Middle Panel
        JPanel panel=new JPanel();
        panel.setBackground(Color.white);
        panel.setBounds(0,55,580,750);
        panel.setLayout(new GridBagLayout());
        c.add(panel);


        ImageIcon icon1=new ImageIcon(MainFrame.class.getResource("menu2.png"));
        JButton back=new JButton(icon1);
        back.setBounds(0,0,50,55);
        back.setBorder(new EtchedBorder(EtchedBorder.RAISED));
        back.setBackground(Color.decode("#61E7C8"));
        back.setBorderPainted(false);
        c.add(back);

        JPopupMenu menu=new JPopupMenu();
        menu.setPopupSize(150,300);
        ImageIcon about1=new ImageIcon(MainFrame.class.getResource("about.png"));
        Image image = about1.getImage(); // transform it
        Image new1 = image.getScaledInstance(50, 50,  java.awt.Image.SCALE_SMOOTH); // scale it smoothly
        ImageIcon newImageIcon = new ImageIcon(new1);
        JMenuItem about=new JMenuItem(new AbstractAction(" About Us", newImageIcon) {
            @Override
            public void actionPerformed(ActionEvent e) {
                new About().setVisible(true);
            }
        });
        


        ImageIcon share1=new ImageIcon(MainFrame.class.getResource("share.png"));
        Image image1 = share1.getImage(); // transform it
        Image new2 = image1.getScaledInstance(50, 50,  java.awt.Image.SCALE_SMOOTH); // scale it smoothly
        ImageIcon newImageIcon1 = new ImageIcon(new2);
        JMenuItem share=new JMenuItem("Share",newImageIcon1);
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

        ImageIcon save1=new ImageIcon(MainFrame.class.getResource("save.png"));
        Image image2 = save1.getImage(); // transform it
        Image new3 = image2.getScaledInstance(50, 50,  java.awt.Image.SCALE_SMOOTH); // scale it smoothly
        ImageIcon newImageIcon2 = new ImageIcon(new3);
        JMenuItem save=new JMenuItem("Save",newImageIcon2);
        save.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Dimension d=panel.getSize();
                BufferedImage image=new BufferedImage(d.width,d.height,BufferedImage.TYPE_INT_RGB);
                Graphics2D g=image.createGraphics();
                g.dispose();
                try{
                ImageIO.write(image,".jpg",new File("C:\\Users\\SOURAV\\Downloads\\Screeshot.jpg"));}
                catch (IOException ev){

                }
            }
        });

        menu.add(about);
        menu.add(share);
        menu.add(save);

        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                    menu.show(back,0,0);
                    menu.setBorderPainted(true);

            }
        });



//        ImageIcon icon2=new ImageIcon(MainFrame.class.getResource("setting.png"));
//        JButton setting=new JButton(icon2);
//        setting.setBounds(650,-1,50,50);
//        setting.setBackground(Color.white);
//        setting.setBorderPainted(false);
//        c.add(setting);


//        ImageIcon icon3=new ImageIcon(MainFrame.class.getResource("about.png"));
//        JButton about=new JButton(icon3);
//        about.setBounds(730,-1,50,50);
//        about.setBackground(Color.white);
//        about.setBorderPainted(false);
//        c.add(about);





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
        Reset.setForeground(Color.white);
        Reset.setBounds(580,650,220,80);
        frame.add(Reset);

        Reset.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new MainFrame().setVisible(true);

            }
        });



        // AREA TEXT FIELD
        JLabel area=new JLabel("AREA");
        area.setBounds(580,60,200,50);
        Font font2=new Font("Arial Rounded MT Bold",Font.BOLD,24);
        area.setForeground(Color.white);
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
        edge.setForeground(Color.white);
        c.add(edge);

        JTextField edge1=new JTextField("40000 m^2");
        edge1.setFont(font2);
        edge1.setBounds(580,220,220,140);
        edge1.setBackground(Color.decode("#F8E2C2"));
        edge1.setBorder(new BevelBorder(BevelBorder.LOWERED));
        c.add(edge1);


        // ANGLE TEXT FIELD
        JLabel angle=new JLabel("ANGLES");
        angle.setBounds(580,370,220,50);
        angle.setFont(font2);
        angle.setForeground(Color.white);
        c.add(angle);

        JTextField angle1=new JTextField("40000 m^2");
        angle1.setFont(font2);
        angle1.setBounds(580,410,220,140);
        angle1.setBackground(Color.decode("#F8E2C2"));
        angle1.setBorder(new BevelBorder(BevelBorder.LOWERED));
        c.add(angle1);

        //frame.add(side);
        //frame.add(menu);


        //Conversion Textfield
//        JLabel scale1=new JLabel("SCALE");
//        JTextField scale=new JTextField("SCALE");
//        scale.setFont(new Font("Arial",Font.PLAIN,18));
//        scale.setBackground(Color.decode("#F8E2C2"));
//        scale.setBorder(new BevelBorder(BevelBorder.LOWERED));
//
//        panel.add(scale,we);



        frame.setLayout(null);
        frame.setVisible(true);
    }

//    @Override
//    public void actionPerformed(ActionEvent e) {
//        Object obj=e.getSource();
//        if(obj==about){
//
//        }
//    }
}
