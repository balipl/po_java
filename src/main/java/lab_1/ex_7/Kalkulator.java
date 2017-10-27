package lab_1.ex_7;
import lab_1.ex_1.javaIn.JIn;
public class Kalkulator {

    public static void main(String[] argv){
        System.out.println("Podaj wysokosc macierzy");
        Integer wys = JIn.getInteger();
        System.out.println("Podaj szerokosc macierzy");
        Integer szer = JIn.getInteger();
        Macierz macierz1 = new Macierz(wys,szer);
        macierz1.wczytajDane();
        Macierz macierz2 = new Macierz(wys,szer);
        macierz2.wczytajDane();
        macierz1.add(macierz2).wypiszDane();

        macierz1.mul(macierz2).wypiszDane();

    }
}
