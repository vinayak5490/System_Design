package zomato.models;
import java.util.*;
public class Cart {
    private Restaurent restaurent;
    private List<MenuItem> items = new ArrayList<>();

    public Cart(){
        restaurent = null;
    }

    public void addItem(MenuItem item){
        if(restaurent == null){
            System.err.println("Cart: Set a restaurent before adding items.");
            return;
        }
        items.add(item);
    }


    public double getTotalCost(){
        double sum = 0;
        for(MenuItem it : items){
            sum += it.getPrice();
        }
        return sum;
    }

    public void clear(){
        items.clear();
        restaurent == null;
    }

    public void setRestaurent(Restaurent r){
        restaurent = r;
    }
    public Retaurent getRestaurent(){
        return restaurent;
    }
    public List<MenuItem> getItem(){
        return items;
    }
}
