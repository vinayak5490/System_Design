package zomato.strategies;

public class CreditCardPaymentStrategy implements PaymentStrategy{
    private String cardNumber;
    public CreditCardPaymentStrategy(String card){
        this.cardNumber = card;
    }

    @Override 
    public void pay(double amount){
        System.out.println("Paid ₹" + amount + " using credit card (" + cardNumber + ")");
    }
}
