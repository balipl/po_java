package lab_4.ex_1;

import lab_3.ex_4.Circle;
import lab_3.ex_4.Shape;
import lab_3.ex_4.Square;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.*;
import java.util.LinkedList;
import java.util.List;

public class MyPanel extends Panel implements MouseMotionListener, MouseListener {

    MyPanel(){
        addMouseListener(this);
        addMouseMotionListener(this);
        setPreferredSize(new Dimension(1000, 500));
    }

    static final int WIDTH = 800, HEIGHT = 375; // Size of our example

    Circle kolo = new Circle(100,100);
    Square kwadrat = new Square(0,0);
    lab_3.ex_4.Rectangle prostokat = new lab_3.ex_4.Rectangle(200,200);
    Shape movingShape;

    public static List<Shape> lista = new ArrayList<Shape>();

    @Override
    public void paint(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        lista.add(kolo);
        lista.add(kwadrat);
        lista.add(prostokat);
        for(Shape element : lista){
            element.draw(g2);
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
        int x1 = e.getX();
        int y1 = e.getY();

        int x2, y2;
        if (e.getButton() == MouseEvent.BUTTON1) {
            int index = 0;
            int size = lista.size();
            Shape p;
            while (movingShape == null && index < size) {
                p = lista.get(index);
                x2 = p.getX();
                y2 = p.getY();
                if (x1 >= x2 && y1 >= y2 && x1 <= x2+200  && y1 <= y2+200)
                    movingShape = p;
                index++;
            }
        }

        repaint();
    }


    @Override
    public void mouseReleased(MouseEvent e) {
        movingShape = null;
    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void mouseDragged(MouseEvent e) {
        if(movingShape != null){
            movingShape.x = e.getX();
            movingShape.y = e.getY();
        }
        repaint();
    }

    @Override
    public void mouseMoved(MouseEvent e) {
    }
}
