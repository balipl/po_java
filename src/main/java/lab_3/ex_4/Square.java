package lab_3.ex_4;

public class Square extends Shape {
    public void draw(){
        for (int i = 0; i < 5; i++) {
            System.out.println("To jest kwadrat");
        }
    }
    public Square (int size1){
        size = size1;
    }
}
