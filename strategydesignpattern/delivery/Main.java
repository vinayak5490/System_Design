
public class Main {
    public static void main(String[] args) {
        double distance = 10;
        DeliverStrategy strategy = new ExpressDelivery();
        DeliveryService service = new DeliveryService(strategy);
        double cost = service.calculateDeliveryCost(distance);

        System.out.println("Delivery cost:" + cost);
    }
}
