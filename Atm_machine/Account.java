package Atm_machine;

public class Account {
    private final String accountNumber;
    private double balance;

    public Account(String accountNumber, double balance){
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    public String getAccountNumber(){
        return accountNumber;
    }

    public double getBalance(){
        return balance;
    }

    public void deposit(double amount){
        balance += amount;
    }

    public boolean withdraw(double amount){
        if(balance >= amount){
            balance -= amount;
            return true;
        }
        return false;
    }
}
