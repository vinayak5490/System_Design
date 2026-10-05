package music_player.stratagies;
import music_player.models.Playlist;
import music_player.models.Song;

public interface PlayStrategy {
    void setPlaylist(Playlist playlist);
    Song next();
    boolean hasNext();
    Song previous();
    boolean hasPrevious();
    default void addToNext(Song song){}
}
