// package strategydesignpattern.delivery;

public class DeliveryService {
    private DeliverStrategy strategy;

    public DeliveryService(DeliverStrategy strategy){
        this.strategy = strategy;
    }

    public double calculateDeliveryCost(double distance){
        return strategy.calculateCost(distance);
    }
}
