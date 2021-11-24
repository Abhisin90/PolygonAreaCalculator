package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main extends JPanel {

    public Main(JFrame frame, int delay) {
        Surface surface = new Surface(frame);
        setSize(surface.getSize());
        setBackground(surface.getBackground());
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        int delayTime = delay*1000;
        ActionListener taskPerformer = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.getContentPane().removeAll();
                frame.setSize(surface.getSize());
                frame.getContentPane().add(surface);
                frame.revalidate();
                frame.repaint();
            }
        };
        Timer timer = new Timer(delayTime, taskPerformer);
        timer.start();
        timer.setRepeats(false);
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setTitle("POLYGON AREA CALCULATOR");
        Main page = new Main(frame, 1);
        frame.setSize(page.getSize());
        frame.setResizable(false);
        Container contentPane = frame.getContentPane();
        contentPane.add(page);
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
