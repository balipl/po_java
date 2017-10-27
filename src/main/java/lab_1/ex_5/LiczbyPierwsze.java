package lab_1.ex_5;

public class LiczbyPierwsze {
    private Integer _number;

    public LiczbyPierwsze(Integer number){
        _number = number;
    }

    public void search(){
        for (int i = 2; i < _number; i++) {
            if(check(i)){
                System.out.println(i+"jest liczba pierwsza");

        }
//śćź
        }
    }
    public boolean check(Integer number_to_check){
        for (int i = 2; i <= Math.sqrt(number_to_check); i++) {
            if(number_to_check%i==0){
                return false;
            }

        }
        return true;
    }
}
