package BookMyShow;
import java.util.*;
public class Theatre {
    private final String id;
    private final String name;
    private final String city;
    private final List<Screen> screens = new ArrayList<>();

    public Theatre(String id, String name, String city){
        this.id = id;
        this.name = name;
        this.city = city;
    }

    public String getId(){
        return id;
    }
    public String getName(){
        return name;
    }
    public String getCity(){
        return city;
    }

    public void addScreen(Screen screen){
        screens.add(screen);
    }
    public List<Screen> getScreens(){
        return Collections.unmodifiableList(screens);
    }
    public Screen findScreen(String screenId){
        for(Screen sc : screens){
            if(sc.getId().equals(screenId)) return sc;
        }
        return null;
    }
}
