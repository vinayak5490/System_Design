public class Song {
    private string title;
    private string artist;
    private string filePath;

    public Song(String title, String artist, String filePath){
        this.title = title;
        this.artist = artist;
        this.filePath = filePath;
    }

    public String getTitle(){
        return title;
    }
    public String getArtist(){
        return artist;
    }
    public String getFilePath(){
        return filePath;
    }
}
