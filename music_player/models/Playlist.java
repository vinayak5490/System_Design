
import java.util.*;

import javax.management.RuntimeErrorException;
public class Playlist {
    private String playListName;
    private List<Song> songList;

    public Playlist(String name){
        this.playListName = name;
        this.songList = new ArrayList<>();
    }

    public String getPlaylistName(){
        return playListName;
    }

    public List<Song> getSongs(){
        return songList;
    }

    public int getSize(){
        return songList.size();
    }

    public void addSongToPlayList(Song song){
        if(song == null){
            throw new RuntimeException("cannot add null song to playlist");
        }
        songList.add(song);
    }
}
