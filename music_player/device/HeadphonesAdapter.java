package music_player.device;
import music_player.models.Song;
import music_player.external.HeadphonesAPI;
public class HeadphonesAdapter {
    private HeadphonesAPI headphonesAPI;

    public HeadphonesAdapter(HeadphonesAPI api){
        this.headphonesAPI = api;
    }

    @Override 
    public void playAudio(Song song){
        String payload = song.getTitle() + " by " + song.getArtist();
        headphonesAPI.playSoundViaJack(payload);
    }
}
