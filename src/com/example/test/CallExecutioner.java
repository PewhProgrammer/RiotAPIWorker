package com.example.test;

import com.Log.Logger;
import com.api.calls.ICalls;
import com.datastructure.CurrentMatch;
import com.datastructure.Summoner;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Set;

/**
 * Created by Thinh on 19.06.2016.
 */
public class CallExecutioner {

    public static Summoner parseSummoner(ICalls call){
        try {
            JSONObject profil = call.execute();
            String name = profil.keys().next() ;
            JSONObject data = profil.getJSONObject(name) ;

            Summoner player = new Summoner(name,data.getInt("id"));

            return player ;
        }catch(IOException e){
            Logger.debug("Didnt find the summoner");
            System.exit(1);
        }

        return null ;
    }

    public static CurrentMatch parseCurrentMatch(ICalls call){
        JSONObject profil = null ;
        try {
            profil = call.execute();
        }catch(IOException e){
            Logger.debug("Summoner is not in a game");
        }

        Set<String> keys = profil.keySet() ;

        /**
         * gameId , gameType , gameStartTime , mapId , platformId , gameLength , gameMode , gameQueueConfigId
         * bannedChampions , participants ,
         */

        ArrayList<Integer> list = new ArrayList<>() ;
        list.add(profil.getInt("gameId"));
        list.add(profil.getInt("gameStartTime"));
        list.add(profil.getInt("mapId"));
        list.add(profil.getInt("gameLength"));
        list.add(profil.getInt("gameQueueConfigId"));

        CurrentMatch returnValue = new CurrentMatch(profil.getJSONArray("participants"),list , profil.getString("gameType"),
                profil.getString("gameMode")
                );


        return returnValue;
    }


}
