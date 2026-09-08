package zomato.managers;
import zomato.models.*;
import java.util.*;

//Singleton
public class RestaurantManager {
    private List<Restaurant> restaurants = new ArrayList<>();
    private static RestaurantManager instance = null;

    private RestaurantManager(){
        //private constructor
    }

    public static RestaurantManager getInstance(){
        if(instance == null){
            instance = new RestaurantManager();
        }
        return instance;
    }

    public void addRestaurant(Restaurant r){
        restaurants.add(r);
    }

    public List<Restaurant> searchByLocation(String loc){
        List<Restaurant> result= new ArrayList<>();
        loc = loc.toLowerCase();
        for(Restaurant r : restaurants){
            String r1 = r.getLocation().toLowerCase();
            if(r1.equals(loc)){
                result.add(r);
            }
        }

        return result;
    }
}
