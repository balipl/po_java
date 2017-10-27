package lab_3.ex_4;

public class Rectangle extends Shape {
    public void draw() {
        for (int i = 0; i < 5; i++) {
            System.out.println("To jest prostokat  ");
        }
    }

    public Rectangle(int size1) {
        size = size1;
    }
}
