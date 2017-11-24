package kol1;

import javax.xml.crypto.Data;
import java.io.File;
import java.io.FileNotFoundException;

import java.util.Scanner;
import java.util.Stack;

public class WeWy {
public static Stack<Operator> pobierzDzialanie() throws DataException{
    Stack<Operator> stack = new Stack<Operator>();

    Scanner sc2 = null;
    try {
        sc2 = new Scanner(new File("F:\\Studia\\Semestr 3\\Programowanie_Obiektowe\\PO\\src\\main\\java\\kol1\\test.txt"));
    } catch (FileNotFoundException e) {
        e.printStackTrace();
    }
    while (sc2.hasNextLine()) {
        Scanner s2 = new Scanner(sc2.nextLine());
        while (s2.hasNext()) {
            String s = s2.next();
            System.out.println(s);
            if(isNumeric(s)){
                stack.push(new Stala(s));
            }
            else if(s.equals("!")){
                stack.push(new Silnia(s));
            }
            else if(s.equals("/")){
                stack.push(new Dzielenie(s));
            }
            else if(s.equals("+")){
                stack.push(new Dodawanie(s));
            }
            else if(s.equals("*")){
                stack.push(new Mnozenie(s));
            }
            else{throw new DataException("Bledne dane");

            }
        }
    }
    return stack;
}
public static void zapiszWynik(Double v){
    System.out.println(v);
}

    public static boolean isNumeric(String s) {
        return s.matches("[+-]?(?:\\d+(?:\\.\\d*)?|\\.\\d+)");
    }
}
