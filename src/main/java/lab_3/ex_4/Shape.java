package lab_3.ex_4;

import java.awt.*;

public abstract class Shape{
    public String name;
    public int x;
    public int y;



    public abstract void draw();

    public int getX(){
        return x;
    }
    public int getY(){
        return y;
    }

    public abstract void draw(Graphics grafika);
}