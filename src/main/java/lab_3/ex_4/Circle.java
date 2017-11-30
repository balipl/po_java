package lab_3.ex_4;

import java.awt.*;

public class Circle extends Shape {
    public void draw() {
        System.out.println("To jest kolo");
    }

    public Circle(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public void draw(Graphics grafika) {

        grafika.fillOval(this.x,this.y,100,100);
        grafika.setColor(Color.blue);

    }
}
