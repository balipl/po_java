package lab_2.ex_1;

import lab_2.ex_1.pkg1.B;

public class Test {
    public static void main(String[] argv){
        B b = new B(10,"test");

        System.out.println(b.getNumber());
        b.callIncrement();
        System.out.println(b.getNumber());

    }
}
