package fr.ubordeaux.ao;

public class PhoneNumber {
    private int number;

    public PhoneNumber(int number) {
        this.setPhoneNumber(number);
    }

    private void setPhoneNumber(int number) {
        this.number = number;
    }

    public int getPhoneNumber() {
        return number;
    }
}