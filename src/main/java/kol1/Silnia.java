package kol1;

import java.util.Stack;

public class Silnia extends Operator1Arg{
    public Silnia(String str){
        wartosc = str;
    }
    public double oblicz(Stack<Operator> operator){
        Double tmp = operator.pop().oblicz(operator);
        int number1 = tmp.intValue();
        return fact(number1);
    }
    double fact(int liczba){
        double wynik = 1;
        for (int i = 1; i <= 3; i++) {
            wynik *= i;
        }
        return wynik;
    }
}
