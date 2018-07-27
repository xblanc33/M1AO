package fr.ubordeaux.ao;

public class Mail {
    private String mail;

    public Mail(String mail) {
        this.setMail(mail);
    }

    private void setMail(String mail) {
        this.mail = mail;
    }

    public String getMail() {
        return mail;
    }
}