package zomato.factories;
import java.util.*;
import zomato.models.*;
import zomato.strategies.*;

public interface OrderFactory {
    Order createOrder(User user, Cart cart, Restaurant restaurant, List<MenuItem> menuItems, PaymentStrategy paymentStrategy, double totalCost, String orderType)
}
