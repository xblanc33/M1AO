package fr.ubordeaux.ao;

import java.util.HashSet;
import java.util.Set;

public class Contact {
    private String firstName;
    private String secondName;
    private Address address;
    private Set<Mail> mails;
    private Set<PhoneNumber> phones;


    public Contact(String firstName, String secondName, Address address) {
        this.setFirstName(firstName);
        this.setSecondName(secondName);
        this.setAddress(address);
        mails = new HashSet<Mail>();
        phones = new HashSet<PhoneNumber>();
    }

    private void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    private void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    private void setAddress(Address address) {
        this.address = address;
    }

    public void changeAddress(Address newAddress) {
        this.address = newAddress;
    }

    public void addMail(Mail mail) {
        mails.add(mail);
    }

    public void removeMail(Mail mail) {
        mails.remove(mail);
    }

    public Set<Mail> getMails() {
        Set<Mail> mailz = new HashSet<Mail>();
        mailz.addAll(mails);
        return mailz;
    }

    public void addPhoneNumber(PhoneNumber phone) {
        phones.add(phone);
    }

    public void removePhoneNumber(PhoneNumber phone) {
        phones.remove(phone);
    }

    public Set<PhoneNumber> getPhoneNumbers() {
        Set<PhoneNumber> phonez = new HashSet<PhoneNumber>();
        phonez.addAll(phones);
        return phonez;
    }


}