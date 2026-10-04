package music_player.device;
import music_player.models.Song;
import music_player.external.BluetoothSpeakerAPI;
public class BluetoothSpeakerAdapter implements IAudioOutputDevice{
    private BluetoothSpeakerAPI bluetoothSpeakerAPI;

    public BluetoothSpeakerAdapter(BluetoothSpeakerAPI api){
        this.bluetoothSpeakerAPI = api;
    }

    @Override
    public void playAudio(Song song){
        String payload = song.getTitle() + " by " + song.getArtist();
        bluetoothSpeakerAPI.playSoundViaBluetooth(payload);
    }
}
