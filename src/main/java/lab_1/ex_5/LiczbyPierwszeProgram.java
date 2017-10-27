package lab_1.ex_5;
import lab_1.ex_1.javaIn.JIn;

public class LiczbyPierwszeProgram {
    public static void main(String [] argv){
        System.out.print("Podaj liczbe calkowita: ");
        Integer number = JIn.getInteger();
        LiczbyPierwsze prime = new LiczbyPierwsze(number);
        prime.search();
    }
}
//śśśśśżźćśą