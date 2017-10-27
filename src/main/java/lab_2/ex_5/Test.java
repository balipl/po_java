package lab_2.ex_5;

import lab_2.ex_4.Punkt3D;
import lab_1.ex_1.javaIn.JIn ;
import java.util.Scanner;

import java.util.LinkedList;

public class Test {
    public static LinkedList<Punkt3D> _punkty = new LinkedList<Punkt3D>();



    public static void main(String[] argv){
        boolean canstop = false;
        while(canstop == false) {
            System.out.println("1. Wczytaj punkt 3D");
            System.out.println("2. Wyswietl wszystkie punkty");
            System.out.println("3. Oblicz odleglosc");
            System.out.println("4. Zakoncz");

            Integer choice = JIn.getInteger();

            switch (choice) {
                case 1: {
                    Scanner in = new Scanner(System.in);
                    System.out.println("Podaj x:");
                    double x = in.nextDouble();
                    System.out.println("Podaj y:");
                    double y = in.nextDouble();
                    System.out.println("Podaj z;");
                    double z = in.nextDouble();
                    Punkt3D punkt = new Punkt3D(x,y,z);
                    _punkty.add(punkt);
                    break;
                }
                case 2: {
                    for(Punkt3D pkt : _punkty)
                        pkt.wypisz();
                    break;
                    }

                case 3: {
                    for (int i = 0; i < _punkty.size()-1; i++) {
                        System.out.println(_punkty.get(i).distance(_punkty.get(i+1)));
                    }
                    break;
                }
                case 4: {
                System.out.println("Dzieki za skorzystanie z programu!");
                canstop = true;
                break;
                }
            }
        }
}}

