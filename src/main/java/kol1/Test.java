package kol1;

import java.util.Stack;

public class Test {
    public static void main(String[] argv){
        Stack<Operator> stack = new Stack<Operator>();
        try {
            stack = WeWy.pobierzDzialanie();
        }catch(DataException e){e.printStackTrace();}

        Operator first_one = stack.pop();
        WeWy.zapiszWynik(first_one.oblicz(stack));

    }
}
