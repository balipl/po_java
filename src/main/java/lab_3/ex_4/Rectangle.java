package lab_3.ex_4;

import java.awt.*;

public class Rectangle extends Shape {
    public void draw() {
            System.out.println("To jest prostokat  ");
    }

    public Rectangle(int x, int y){
        this.x = x;
        this.y = y;
    }

    @Override
    public void draw(Graphics grafika) {
        grafika.fillRect(this.x,this.y,100,200);
    }
}
