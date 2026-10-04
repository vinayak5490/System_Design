package music_player.device;
import music_player.models.Song;
public interface IAudioOutputDevice {
    void playAudio(Song song);
}
