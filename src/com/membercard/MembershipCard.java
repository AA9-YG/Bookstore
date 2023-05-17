package com.membercard;

public class MembershipCard {

    private int id;

    private int pin;

    private String cardHolderName;

    private String expirationDate;

    public MembershipCard(int id, int pin, String cardHolderName, String expirationDate) {
        this.id = id;
        this.pin = pin;
        this.cardHolderName = cardHolderName;
        this.expirationDate = expirationDate;
    }

    public int getId() {
        return id;
    }

    public String getCardHolderName() {
        return cardHolderName;
    }

    public int getPin() {
        return pin;
    }

    public void setPin(int pin) {
        this.pin = pin;
    }

    public void setCardHolderName(String cardHolderName) {
        this.cardHolderName = cardHolderName;
    }

    public String getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(String expirationDate) {
        this.expirationDate = expirationDate;
    }

    @Override
    public String toString() {
        return "MembershipCard{" +
                "id=" + id +
                ", cardHolderName='" + cardHolderName + '\'' +
                ", expirationDate='" + expirationDate + '\'' +
                ", PIN='" + pin + '\'' +
                '}';
    }

}
