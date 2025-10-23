package BookMyShow;
import java.util.*;
public class Screen {
    private final String id;
    private final String name;
    private final List<Show> shows = new ArrayList<>();

    public Screen(String id, String name){
        this.id = id;
        this.name = name;
    }

    public String getId(){
        return id;
    }
    public String getName(){
        return name;
    }
    public void addShow(Show show){
        shows.add(show);
    }
    public List<Show> getShows(){
        return Collections.unmodifiableList(shows);
    }
    public Show findShow(String showId){
        for(Show s : shows){
            if(s.getId().equals(showId)) return s;
        }
        return null;
    }
}
