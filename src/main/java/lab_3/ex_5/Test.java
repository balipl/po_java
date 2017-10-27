package lab_3.ex_5;
import lab_3.ex_5.EmailMessage;

public class Test {

    public static void main(String[] argv){
        EmailMessage wiadomosc = EmailMessage.builder()
                .addFrom("bartoszgaj@wp.pl")
                .addTo("bartosz-gaj@wp.pl")
                .addSubject("Mail testowy")
                .addContent("Brak tresci")
                .build();

        wiadomosc.send();


    }
}
