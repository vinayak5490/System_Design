package strategydesignpattern2;
interface PaymentStrategy{
    void pay(double amount);
}

class UPIPaymentStrategy implements PaymentStrategy{
    @Override
    public void pay(double amount){
        System.out.println("Processing UPI payment of inr:" + amount);
    }
}

class CardPaymentStrategy implements PaymentStrategy{
    @Override
    public void pay(double amount){
        System.out.println("Processing card payment of inr:" + amount);
    }
}
class payPalPaymentStrategy implements PaymentStrategy{
    @Override
    public void pay(double amount){
        System.out.println("Processing paypal payment of inr" + amount);
    }
}

class PaymentService{
    private PaymentStrategy strategy;

    public PaymentService(PaymentStrategy strategy){
        this.strategy = strategy;
    }

    public void pay(double amount){
        strategy.pay(amount);
    }
}
public class strategydesignpattern {
    public static void main(String[] args) {
        PaymentStrategy upi = new UPIPaymentStrategy();
        PaymentService  service = new PaymentService(upi);

        service.pay(500);
    }
}
