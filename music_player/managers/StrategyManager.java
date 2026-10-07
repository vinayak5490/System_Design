package music_player.managers;

import music_player.stratagies.SequentialPlayStrategy;
import music_player.stratagies.RandomPlayStrategy;
import music_player.stratagies.CustomQueueStrategy;
import music_player.stratagies.PlayStrategy;
import music_player.enums.PlayStrategyType;

public class StrategyManager {
    private static StrategyManager instance = null;
    private SequentialPlayStrategy sequentialPlayStrategy;
    private RandomPlayStrategy RandomPlayStrategy;
    private CustomQueueStrategy CustomQueueStrategy;

    private StategyManager(){
        sequentialPlayStrategy = new SequentialPlayStrategy();
        RandomPlayStrategy = new RandomPlayStrategy();
        CustomQueueStrategy = new CustomQueueStrategy();
    }

    public static synchronized StrategyManager getInstance(){
        if(instance == null){
            instance = new StrategyManager();
        }
        return instance;
    }

    public PlayStrategy getStrategy(PlayStrategyType type){
        if(type == PlayStrategyType.SEQUENTIAL){
            return sequentialPlayStrategy;
        }else if(type == PlayStrategyType.RANDOM){
            return RandomPlayStrategy;
        }else{
            return CustomQueueStrategy;
        }
    }
}
