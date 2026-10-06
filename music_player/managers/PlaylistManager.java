package music_player.managers;
import music_player.models.Playlist;
import music_player.models.Song;

import java.util.HashMap;
import java.util.Map;

import javax.management.RuntimeErrorException;

public class PlaylistManager {
    private static PlaylistManager instance = null;
    private Map<String, Playlist> playlists;

    private PlaylistManager(){
        playlists = new HashMap<>();
    }

    public static synchronized PlaylistManager getInstance(){
        if(instance == null){
            instance = new PlaylistManager();
        }
        return instance;
    }

    public void createPlaylist(String name){
        if(playlists.containsKey(name)){
            throw new RuntimeException("Playlist \"" + name + "\" already exists.");
        }
        playlists.put(name, new Playlist(name));
    }

    public void addSongToPlaylist(String playlistName, Song song){
        if(!playlists.containsKey(playlistName)){
            throw new RuntimeException("Playlist \"" + playlistName + "\" not found.");
        }
        playlists.get(playlistName).addSongToPlayList(song);
    }

    public Playlist getPlayList(String name){
        if(!playlists.containsKey(name)){
            throw new RuntimeException("Playlist \"" + name + "\" not found.");
        }
        return playlists.get(name);
    }
}
