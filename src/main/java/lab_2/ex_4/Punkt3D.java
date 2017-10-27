package lab_2.ex_4;

import lab_2.ex_3.Punkt2D;

public class Punkt3D extends Punkt2D {
    private double _z;
    //ćśż
    public Punkt3D(double x, double y, double z){
        super (x,y);
        _z = z;
    }
    void setZ(double z){
        _z = z;
    }
    double getZ(){
        return _z;
    }

    public double distance(Punkt3D punkt2){
        return Math.sqrt(Math.pow(punkt2.getX() - this.getX(),2) + Math.pow(punkt2.getY() - this.getY(),2) + Math.pow(punkt2.getZ() - this.getZ(), 2));
    }
    public void wypisz(){
        System.out.println("Punkt [" + getX() + "][" + getY() + "]["+getZ() +"]");
    }
}
