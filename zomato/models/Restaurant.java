package zomato.models;
import java.util.*;
public class Restaurant {
    private static int nextRestaurentId = 0;
    private int restaurentId;
    private String name;
    private String location;
    private List<MenuItem> menu = new ArrayList<>();

    public Restaurant(String name, String location){
        this.name = name;
        this.location = location;
        this.restaurentId = ++nextRestaurentId;
    }

    public String getName(){
        return name;
    }
    public String getLocation(){
        return location;
    }
    public void setLocation(String loc){
        location = loc;
    }
    public void addMenuItem(MenuItem item){
        menu.add(item);
    }
    public List<MenuItem> getMenu(){
        return menu;
    }
}

