package kol1;

import java.util.Stack;

public class Mnozenie extends Operator2Arg {
    public Mnozenie(String str){
        wartosc = str;
    }
    public double oblicz(Stack<Operator> operator){
        double number1 = operator.pop().oblicz(operator);
        double number2 = operator.pop().oblicz(operator);
        return number1 * number2;
    }
}
