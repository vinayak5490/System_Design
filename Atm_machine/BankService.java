package Atm_machine;
import java.util.*;
public class BankService {
    private final Map<String, Account> accounts = new HashMap<>();
    private final Map<String, Card> cards = new HashMap<>();

    public void addAccount(Account account){
        accounts.put(account.getAccountNumber(), account);
    }

    public void addCard(Card card){
        cards.put(card.getCardNumber(), card);
    }

    public Card getCard(String cardNumber){
        return cards.get(cardNumber);
    }

    public Account getAccount(String accountNumber){
        return accounts.get(accountNumber);
    }
}
