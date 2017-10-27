package lab_4.ex_1;
import lab_3.ex_1.*;
import lab_3.ex_4.Rectangle;
import lab_3.ex_4.Shape;
import lab_3.ex_4.Square;
import lab_3.ex_4.Circle;

import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;

public class ShapeList {

    public static void main(String[] argv) {
        LinkedList<Shape> lista = new LinkedList<Shape>();

        Rectangle prostokat = new Rectangle(5);
        Square kwadrat = new Square(4);
        Circle kolo = new Circle(3);

        lista.add(prostokat);
        lista.add(kwadrat);
        lista.add(kolo);

        for(Shape element: lista){
            element.draw();
        }

        Collections.sort(lista, new Comparator<Shape>(){
            @Override
            public int compare(Shape o1, Shape o2) {
                if(o1.size>o2.size){return 1;}
                if(o1.size<o2.size){return -1;}
                else return 0;
            }
        });
    }
}
