package zomato.models;

public class User {
    private int userId;
    private String name;
    private String address;
    private Cart cart;

    public User(int userId, String name, String address){
        this.userId = userId;
        this.name = name;
        this.address = address;
        this.cart = new Cart();
    }

    public String getName(){
        return name;
    }

    public void setName(String s){
        name = s;
    }
    public String getAddress(){
        return address;
    }
    public void setAddress(String s){
        address = s;
    }
    public Cart getCart(){
        return cart;
    }
}
