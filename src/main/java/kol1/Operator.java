package kol1;

public abstract class Operator implements Obliczanie {
    public String wartosc;

    Operator(){}
    Operator(String element){
        wartosc = element;
    }

}
