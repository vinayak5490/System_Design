package Atm_machine;

public class Transaction {
    private final String type; //WITHDRAW, DEPOSIT, BALANCE
    private final double amount;
    private final long timestamp;

    public Transaction(String type, double amount){
        this.type = type;
        this.amount = amount;
        this.timestamp = System.currentTimeMillis();
    }
}
