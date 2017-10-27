package main.java.lab_2.ex_1.pkg2;

import main.java.lab_2.ex_1.pkg1.B;

public class C extends B {

    //int test = number;  - niedostepne bo nie jest w tym samym pakiecie
    String test1 = name;

void changeName(){
        name = "Klasa C";
    }
}
