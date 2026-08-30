// package strategydesignpattern.delivery;

public class ExpressDelivery implements DeliverStrategy {
    @Override
    public double calculateCost(double distance){
        return distance * 10;
    }
}
