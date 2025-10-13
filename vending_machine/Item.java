package vending_machine;

public class Item {
    private String name;
    private int price;
    private int quantity;

    public Item(String name, int price, int quantity){
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public String getName(){
        return name;
    }
    public int getPrice(){
        return price;
    }
    public int getQuantity(){
        return quantity;
    }

    public void reduceQuantity(){
        if(quantity > 0) quantity--;
    }
    public void refill(int count){
        this.quantity += count;
    }
}
