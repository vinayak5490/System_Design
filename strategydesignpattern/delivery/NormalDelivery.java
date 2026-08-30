// package strategydesignpattern.delivery;
public class NormalDelivery implements DeliverStrategy{
    @Override
    public double calculateCost(double distance){
        return distance * 5;
    }
}