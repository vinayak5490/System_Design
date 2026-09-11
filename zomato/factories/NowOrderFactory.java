package zomato.factories;
import java.util.*;
import zomato.models.*;
import zomato.strategies.*;

public class NowOrderFactory implements OrderFactory{
    @Override 
    public Order creatOrder(User user, Cart cart, Restaurant restaurant, List<MenuItem> menuItems, PaymentStrategy paymentStrategy, double totalCost, String orderType)
}
