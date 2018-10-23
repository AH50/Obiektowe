package lab3;


import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import java.util.LinkedList;

public class EmailMessage {
    private String from;
    private LinkedList<String> to;
    private String subject;
    private String content;
    private String mimeType;
    private LinkedList<String> cc;
    private LinkedList<String> bcc;

    public String getFrom() {
        return from;
    }

    public LinkedList<String> getTo() {
        return to;
    }

    public String getSubject() {
        return subject;
    }

    public String getContent() {
        return content;
    }

    public String getMimeType() {
        return mimeType;
    }

    public LinkedList<String> getCc() {
        return cc;
    }

    public LinkedList<String> getBcc() {
        return bcc;
    }

    public static Builder builder() {
        return new EmailMessage.Builder();
    }

    protected EmailMessage(String from, LinkedList<String> to, String subject, String content, String mimeType, LinkedList<String> cc, LinkedList<String> bcc)
    {
        this.from = from;
        this.to = to;
        this.subject = subject;
        this.content = content;
        this.mimeType = mimeType;
        this.cc = cc;
        this.bcc = bcc;
    }

    public static class Builder
    {
        private String from;
        private LinkedList<String> to = new LinkedList();
        private String subject;
        private String content;
        private String mimeType;
        private LinkedList<String> cc = new LinkedList();
        private LinkedList<String> bcc = new LinkedList();

        public Builder addFrom(String from_){
            if(Emailcheck(from_)) {
                this.from = from_;
            }
            else
            {
                System.out.printf("Błędny adres email!");
            }

            return this;
        }
        public Builder addTo(String to_)
            {
            if(Emailcheck(to_)) {
                this.to.add(to_);
            }
            else
            {
                System.out.printf("Błędny adres email!");
            }
            return this;
        }
        public Builder addSubject(String subject_)
        {
            subject = subject_;
            return this;
        }
        public Builder addContent(String content_)
        {
            content = content_;
            return this;
        }
        public Builder addMimeType(String mimeType_)
        {
            mimeType = mimeType_;
            return this;
        }
        public Builder addCC(String cc_)
        {
            cc.add(cc_);
            return this;
        }
        public Builder addBCC(String bcc_)
        {
            bcc.add(bcc_);
            return this;
        }
        public EmailMessage build()
        {
            return new EmailMessage(this.from, this.to, this.subject, this.content, this.mimeType, this.cc, this.bcc);
        }
        public static boolean Emailcheck(String email)
        {
            boolean result = true;
            try{
                InternetAddress mail = new InternetAddress(email);
                mail.validate();
            } catch (AddressException d)
            {
                result = false;
            }
            return result;
        }
        }
}