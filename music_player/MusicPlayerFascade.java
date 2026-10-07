package music_player;

import javax.management.RuntimeErrorException;

import music_player.core.AudioEngine;
import music_player.models.Playlist;
import music_player.models.Song;
import music_player.stratagies.PlayStrategy;
import music_player.enums.DeviceType;
import music_player.enums.PlayStrategyType;
import music_player.managers.DeviceManager;
import music_player.managers.PlaylistManager;
import music_player.managers.StrategyManager;
import music_player.device.IAudioOutputDevice;

public class MusicPlayerFascade {
    private static MusicPlayerFascade instance = null;
    private AudioEngine audioEngine;
    private Playlist loadedPlaylist;
    private PlayStrategy playStrategy;

    private MusicPlayerFascade(){
        loadedPlaylist = null;
        playStrategy = null;
        audioEngine = new AudioEngine();
    }

    public static synchronized MusicPlayerFascade getInstance(){
        if(instance == null){
            instance = new MusicPlayerFascade();
        }
        return instance;
    }

    public void connectDevice(DeviceType deviceType){
        DeviceManager.getInstance().connect(deviceType);
    }

    public void setPlayStrategy(PlayStrategyType strategyType){
        playStrategy = StrategyManager.getInstance().getStrategy(strategyType);
    }

    public void loadedPlaylist(String name){
        loadedPlaylist = PlaylistManager.getInstance().getPlayList(name);
        if(playStrategy == null){
            throw new RuntimeException("Play strategy not set before loading");
        }
        playStrategy.setPlaylist(loadedPlaylist);
    }

    public void playSong(Song song){
        if(!DeviceManager.getInstance().hasOutputDevice()){
            throw new RuntimeException("No audio device connected");
        }
        IAudioOutputDevice device = DeviceManager.getInstance().getOutputDevice();
        audioEngine.play(device, song);
    }

    public void pauseSong(Song song){
        if(!audioEngine.getCurrentSongTitle().equals(song.getTitle())){
            throw new RuntimeException("Cannot pause \"" + song.getTitle() + "\"; not currently playing.");
        }
        audioEngine.pause();
    }

    public void playAllTracks(){
        if(loadedPlaylist == null){
            throw new RuntimeException("No playlist loaded.");
        }
        while(playStrategy.hasNext()){
            Song nextSong = playStrategy.next();
            IAudioOutputDevice device = DeviceManager.getInstance().getOutputDevice();
            audioEngine.play(device, nextSong);
        }
        System.out.println("Completed playlist: " + loadedPlaylist.getPlaylistName());
    }

    public void playNextTrack(){
        if(loadedPlaylist == null){
            throw new RuntimeException("No playlist loaded.");
        }
        if(playStrategy.hasNext()){
            Song nextSong = playStrategy.next();
            IAudioOutputDevice device = DeviceManager.getInstance().getOutputDevice();
            audioEngine.play(device, nextSong);
        }else{
            System.out.println("Completed playlist: " + loadedPlaylist.getPlaylistName());
        }
    }

    public void playPreviousTrack(){
        if(loadedPlaylist == null){
            throw new RuntimeException("No playlist loaded.");
        }
        if(playStrategy.hasPrevious()){
            Song prevSong = playStrategy.previous();
            IAudioOutputDevice device = DeviceManager.getInstance().getOutputDevice();
            audioEngine.play(device,prevSong);
        }else{
            System.out.println("Completed playlist: " + loadedPlaylist.getPlaylistName());
        }
    }

    public void enqueueNext(Song song){
        playStrategy.addToNext(song);
    }
}
