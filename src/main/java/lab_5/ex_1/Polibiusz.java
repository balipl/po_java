package lab_5.ex_1;

public class Polibiusz implements Algorithm {
    static final char[][] polibiuszMatrix = {{'A','B','C','D','E'},
            {'F','G','H','I','K'},
            {'L','M','N','O','P'},
            {'Q','R','S','T','U'},
            {'V','W','X','Y','Z'}};

    @Override
    public String crypt(String slowo) {
        String exitword="";

        for (int i = 0; i < slowo.length(); i++) {
            char letter = slowo.charAt(i);
            for (int j = 0; j < 5; j++) {
                for (int k = 0; k < 5; k++) {
                    if(letter == polibiuszMatrix[j][k]){
                        System.out.println("XD" + letter + " " + polibiuszMatrix[j][k]);
                        exitword += j+1;
                        exitword += k+1;
                        exitword += " ";
                    }
                }
            }
        }
        return exitword;
    }

    @Override
    public String decrypt(String slowo) {
        String exitstring = "";
        for (int i = 0; i < slowo.length(); i+=3) {
            int number1 = slowo.charAt(i) - '0';
            int number2 = slowo.charAt(i+1) - '0';
           // System.out.println(number1+ " " + number2);
            char deciphred = polibiuszMatrix[number1-1][number2-1];
            exitstring += deciphred;
        }
        return exitstring;
    }
}
