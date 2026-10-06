package music_player.factories;

import music_player.device.BluetoothSpeakerAdapter;
import music_player.device.IAudioOutputDevice;
import music_player.enums.DeviceType;
import music_player.external.BluetoothSpeakerAPI;
import music_player.external.HeadphonesAPI;
import music_player.external.WiredSpeakerAPI;;
import music_player.device.WiredSpeakerAdapter;;

public class DeviceFactory {
    public static IAudioOutputDevice createDevice(DeviceType deviceType){
        switch(deviceType){
            case BLUETOOTH:
                return new BluetoothSpeakerAdapter(new BluetoothSpeakerAPI());
            case WIRED:
                return new WiredSpeakerAdapter(new WiredSpeakerAPI());
            case HEADPHONES:
            default:
                return new HeadphonesAdapter(new HeadphonesAPI());
        }
    }
}
