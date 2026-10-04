package music_player.device;
import music_player.models.song;
import music_player.external.WiredSpeakerAPI;
public class WiredSpeakerAdapter {
    private WiredSpeakerAPI wiredApi;

    public WiredSpeakerAdapter(WiredSpeakerAPI api){
        this.wiredApi = api;
    }


    @Override 
    public void playAudio(Song song){
        String payload = song.getTitle() + " by " + song.getArtist();
        wiredApi.playSoundViaCable(payload);
    }

}
