package Atm_machine;

public class ATMDemo {
   public static void main(String[] args) {
       BankService bankService = new BankService();

       Account acc = new Account("ACC123", 10000);
       Card card = new Card("CARD123", "ACC123", 1234);

       bankService.addAccount(acc);
       bankService.addCard(card);

       ATMService atm = new ATMService(bankService);

       if (atm.authenticate("CARD123", 1234)) {
           System.out.println("Balance: " + atm.checkBalance());
           atm.withdraw(2000);
           atm.deposit(500);
           System.out.println("Balance: " + atm.checkBalance());
           atm.exit();
       } else {
           System.out.println("Authentication Failed");
       }
   }
}
