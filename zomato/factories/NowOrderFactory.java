package zomato.factories;
import java.util.*;
import zomato.models.*;
import zomato.strategies.*;

public class NowOrderFactory implements OrderFactory{
    @Override 
    public Order creatOrder(User user, Cart cart, Restaurant restaurant, List<MenuItem> menuItems, PaymentStrategy paymentStrategy, double totalCost, String orderType){
        Order order = null;
        if(orderType.equals("Delivery")){
            DeliveryOrder deliveryOrder = new DeliveryOrder();
            deliveryOrder.setUserAddress(user.getAddress());
            order = deliveryOrder;
        }else{
            PickupOrder pickupOrder = new PickupOrder();
            pickupOrder.setRestaurant(restaurant.getLocation());
            order = pickupOrder;
        }

        order.setUser(user);
        order.setRestaurant(restaurant);
        order.setItems(menuItems);
        order.setSchedule(TimeUtils.getCurrentTime());
        order.setTotal(totalCost);
        order.setPaymentStrategy(totalCost);
        return order;
    }
}
