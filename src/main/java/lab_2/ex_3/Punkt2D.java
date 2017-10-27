package lab_2.ex_3;

public class Punkt2D {
    private double _x;
    private double _y;

    public Punkt2D(double x, double y){
        _y=y;
        _x=x;
    }
    public double getX(){
        return _x;
    }
    public double getY(){
        return _y;
    }
    public void setX(double x){
        _x = x;
    }
    public void setY(double y){
        _y = y;
    }
    public double distance(Punkt2D punkt2){
        return Math.sqrt(Math.pow(punkt2._x - _x,2) + Math.pow(punkt2._y - _y,2));
    }
}
