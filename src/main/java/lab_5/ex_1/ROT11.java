package lab_5.ex_1;

public class ROT11 implements Algorithm {
    static String alfabet = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
    static Integer przesuniecie = 13;

    @Override
    public String crypt(String slowo) {
        String slowo_down = slowo.toLowerCase();
        String exit_string = "";
        for (int i = 0; i < slowo_down.length(); i++) {
            char letter = slowo_down.charAt(i);
            if(letter == ' '){
                exit_string += " ";
                continue;
            }
            int letter_asci = Character.valueOf(letter);
            int exit_asci = letter_asci + przesuniecie;
            if(exit_asci >122){
                exit_asci = 96 + (exit_asci-122);
            }
            char exit_letter = (char)exit_asci;
            exit_string+=exit_letter;
            System.out.println("XD" + i + " " + letter + " " + letter_asci + " " + exit_asci + " " + exit_letter);
        }
        return exit_string;
    }

    @Override
    public String decrypt(String slowo) {
        String slowo_down = slowo.toLowerCase();
        String exit_string = "";
        for (int i = 0; i < slowo_down.length(); i++) {
            char letter = slowo_down.charAt(i);
            if(letter == ' '){
                exit_string += " ";
                continue;
            }
            int letter_asci = Character.valueOf(letter);
            int exit_asci = letter_asci - przesuniecie;
            if(exit_asci <97){
                exit_asci = 122 + exit_asci - 96;
            }
            char exit_letter = (char)exit_asci;
            exit_string+=exit_letter;

            //System.out.println("XD" + i + " " + letter + " " + letter_asci + " " + exit_asci + " " + exit_letter);
        }
        return exit_string;
    }
}
