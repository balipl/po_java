package lab_3.ex_4;

import java.awt.*;

public class Square extends Shape {
    public void draw(){
            System.out.println("To jest kwadrat");
    }

    @Override
    public void draw(Graphics grafika) {

        grafika.fillRect(this.x,this.y,100,100);
    }

    public Square (int x, int y){
        this.x = x;
        this.y = y;

    }
}
