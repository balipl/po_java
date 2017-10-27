package lab_1.ex_6;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import lab_1.ex_1.javaIn.JIn;

public class PeselChecker {
    public static void main(String[] argv){


        System.out.println("Podaj numer PESEL:");
        String pesel = JIn.getString();

        if(Pesel.check(pesel)){
            System.out.println("Twoj PESEL jest poprawny");
        }else{
            System.out.println("Twoj PESEL nie jest poprawny");
        }



    }
}
