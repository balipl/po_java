package lab_1.ex_6;

public class Pesel {


    public static boolean check(String pesel) {

        Integer p1 = pesel.charAt(0) - '0';
        Integer p2 = pesel.charAt(1) - '0';
        Integer p3 = pesel.charAt(2) - '0';
        Integer p4 = pesel.charAt(3) - '0';
        Integer p5 = pesel.charAt(4) - '0';
        Integer p6 = pesel.charAt(5) - '0';
        Integer p7 = pesel.charAt(6) - '0';
        Integer p8 = pesel.charAt(7) - '0';
        Integer p9 = pesel.charAt(8) - '0';
        Integer p10 = pesel.charAt(9) - '0';
        Integer p11 = pesel.charAt(10) - '0';

        if (pesel.length() != 11) {
            return false;
        }
        else if(( p1*9 + p2*7 + p3 *3 + p4 + p5*9 + p6*7 + p7*3 + p8 * 1 + p9*9 + p10*7)%10 != p11){
            return false;


        }

        return true;

    }
}
