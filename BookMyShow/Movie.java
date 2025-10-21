package BookMyShow;

public class Movie {
    private final String id;
    private final String title;
    private final int durationMinutes;
    private final String language;

    public Movie(String id, String title, int durationMinutes, String language){
        this.id = id;
        this.title = title;
        this.durationMinutes = durationMinutes;
        this.language = language;
    }
    public String getId(){
        return id;
    }
    public String getTitle(){
        return title;
    }
    public int getDurationMinutes(){
        return durationMinutes;
    }
    public String getLanguage(){
        return language;
    }
    @Override
    public String toString(){
        return title + "(" + language + ", " + durationMinutes + "m)";
    }
}
