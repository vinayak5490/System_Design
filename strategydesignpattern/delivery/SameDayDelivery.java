// package strategydesignpattern.delivery;

public class SameDayDelivery implements DeliverStrategy {
    @Override
    public double calculateCost(double distance){
        return distance * 20;
    }
}
