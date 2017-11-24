package kol1;

import java.util.Stack;

public class Stala extends Operator0Arg {
    public Stala(String str){
        wartosc = str;
    }

    public double oblicz (Stack<Operator> operator){
        return Double.parseDouble(wartosc);
    }
}
