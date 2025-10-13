package vending_machine;
import java.util.*;
public class Inventory {
    private Map<String, Item> items = new HashMap<>();

    public void addItem(Item item){
        items.put(item.getName(), item);
    }
    public Item getItem(String name){
        return items.get(name);
    }
    public boolean hasItem(String name){
        Item item = items.get(name);
        return item != null && item.getQuantity() > 0;
    }
    public void refill(String name, int qty){
        Item item = items.get(name);
        if(item != null) item.refill(qty);
    }

    public void showInventory(){
        System.out.println("\n --- Inventory ---");
        for(Item item : items.values()){
            System.out.println(item.getName() + " - ₹" + item.getPrice() + " (" + item.getQuantity() + " left)");
        }
    }
}
