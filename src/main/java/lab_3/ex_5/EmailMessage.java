package lab_3.ex_5;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.LinkedList;
import java.util.Properties;

public class EmailMessage {

    private String _from; //required (must be e-mail)
    private LinkedList<String> _to; //required at least one (must be e-mail)
    private String _subject; //optional
    private String _content; //optional
    private String _mimeType;  // optional
    private LinkedList<String> _cc; //optional
    private LinkedList<String> _bcc; // optional

    private EmailMessage(Builder builder){
        _from = builder.from;
        _to = builder.to;
        _subject = builder.subject;
        _content = builder.content;
        _mimeType = builder.mimeType;
        _cc = builder.cc;
        _bcc = builder.bcc;
    }

    public static Builder builder() {
        return new EmailMessage.Builder();
    }

    //Przykładowy konstruktor (można założyć, że pola opcjonalne mogą być null)

    public void send(){
        final String username = "bartosz.gaj.test.pl@gmail.com";
        final String password = "haslohaslo";

        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");

        Session session = Session.getInstance(props,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(username, password);
                    }
                });

        try {

            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(this._from));
            message.setRecipients(Message.RecipientType.TO,
                    InternetAddress.parse(_to.get(0)));
            message.setSubject(_subject);
            message.setText(_content);

            Transport.send(message);

            System.out.println("Done");

        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }

    }

    public static class Builder{
        String from;
        LinkedList<String> to;
        String subject;
        String content;
        String mimeType;
        LinkedList<String> cc;
        LinkedList<String> bcc;
        public EmailMessage build(){
            return new EmailMessage(this);
        }


        public Builder(){}
        public Builder (String from1, LinkedList<String> to1){
            from = from1;
            to = to1;
         }
         public Builder addFrom(String from1){
            from= from1;
            return this;
         }
         public Builder addTo(String to1){
             to = new LinkedList<String>();
             to.add(to1);
             return this;
         }
        public Builder addTo(LinkedList<String> to1){
             to = to1;
            return this;
        }
        public Builder addSubject(String subject1){
            subject = subject1;
            return this;
        }
        public Builder addContent(String content1){
            content = content1;
               return this;
        }
}

}
