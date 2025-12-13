package Atm_machine;

public class ATMService {
    private final BankService bankService;
    private Account currentAccount;

    public ATMService(BankService bankService){
        this.bankService = bankService;
    }

    public boolean authenticate(String cardNumber, int pin){
        Card card = bankService.getCard(cardNumber);
        if(card != null && card.validatePin(pin)){
            currentAccount = bankService.getAccount(card.getAccountNumber());
            return true;
        }
        return false;
    }

    public double checkBalance(){
        return currentAccount.getBalance();
    }
    public boolean withdraw(double amount){
        return currentAccount.withdraw(amount);
    }
    public void deposit(int amount){
         currentAccount.deposit(amount);
    }
    public void exit(){
        currentAccount = null;
    }
}
