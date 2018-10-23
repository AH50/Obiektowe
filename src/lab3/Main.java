package lab3;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {


        EmailMessage wiadomosc = EmailMessage.builder()
                .addFrom("adspammail50@gmail.com")
                .addTo("adspammail50@gmail.com")
                .addSubject("Tytuł")
                .addContent("Treść maila")
                .build();
        send(wiadomosc);
    }
    private static void send(EmailMessage message1) {
        String username;
        String password;
        System.out.print("Podaj haslo:");
        username = message1.getFrom();
        Scanner scan = new Scanner(System.in);
        password = scan.nextLine();


        Properties props = new Properties();
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.socketFactory.port", "465");
        props.put("mail.smtp.socketFactory.class",
                "javax.net.ssl.SSLSocketFactory");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.port", "465");
        Session session = Session.getDefaultInstance(props,
                new Authenticator()
                {
                    @Override
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(username,password);
                    }
                });

        try {
            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress(message1.getFrom()));
            for (int i = 0; i < message1.getTo().size(); i++) {
                message.addRecipients(Message.RecipientType.TO, InternetAddress.parse(message1.getTo().get(i)));
            }
            message.setSubject(message1.getSubject());
            message.setText(message1.getContent());
            Transport.send(message);
            System.out.println("Wiadomość została wysłana poprawnie");

        } catch (MessagingException obj) {
            obj.printStackTrace();
        }
    }
}