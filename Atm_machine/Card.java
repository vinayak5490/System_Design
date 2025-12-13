package Atm_machine;

public class Card {
    private final String cardNumber;
    private final String accountNumber;
    private final int pin;

    public Card(String cardNumber, String accountNumber, int pin){
        this.cardNumber = cardNumber;
        this.accountNumber = accountNumber;
        this.pin = pin;
    }

    public String getCardNumber(){
        return cardNumber;
    }

    public String getAccountNumber(){
        return accountNumber;
    }
    public boolean validatePin(int inputPin){
        return this.pin == inputPin;
    }
}
