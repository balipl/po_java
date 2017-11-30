package lab_4.ex_1;
import lab_3.ex_1.*;
import lab_3.ex_4.Rectangle;
import lab_3.ex_4.Shape;
import lab_3.ex_4.Square;

import javax.swing.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class ShapeList {

    public static void main(String[] argv) {

        JFrame f = new JFrame();
        f.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
        f.setContentPane(new MyPanel());
        f.setSize(800,375);
        f.setVisible(true);
    }
}
