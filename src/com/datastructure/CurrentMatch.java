package com.datastructure;

import com.Log.Logger;
import org.json.JSONObject;

/**
 * Created by Thinh on 19.06.2016.
 */
public class CurrentMatch {


    /**
     * gameId , gameType , gameStartTime , mapId , platformId , gameLength , gameMode , gameQueueConfigId
     * bannedChampions , participants ,
     */

    public CurrentMatch(JSONObject... obj){
        Logger.info(obj.toString());
    }


}
