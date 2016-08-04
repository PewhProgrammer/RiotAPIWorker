package com.example.test;

import com.api.calls.ICalls;
import com.datastructure.CurrentMatch;
import com.datastructure.Summoner;
import org.json.JSONObject;

import java.io.IOException;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by Thinh on 19.06.2016.
 */
public class CallExecutioner {

    private final static Logger log = Logger.getLogger(Domain.class.getName());

    public static Summoner parseSummoner(ICalls call){
        try {
            JSONObject profil = call.execute();
            String name = profil.keys().next() ;
            JSONObject data = profil.getJSONObject(name) ;

            Summoner player = new Summoner();
            player.setName(name);
            player.setID(data.getInt("id"));

            return player ;
        }catch(IOException e){
            log.log(Level.SEVERE,call.toString(),e);
        }

        return null ;
    }

    public static CurrentMatch parseCurrentMatch(ICalls call){
        JSONObject profil = null ;
        try {
            profil = call.execute();
        }catch(IOException e){
            log.log(Level.SEVERE,call.toString() , e);
        }

        Set<String> keys = profil.keySet() ;

        /**
         * gameId , gameType , gameStartTime , mapId , platformId , gameLength , gameMode , gameQueueConfigId
         * bannedChampions , participants ,
         */
        CurrentMatch returnValue = new CurrentMatch(profil.getJSONObject("gameId"),profil.getJSONObject("gameType"));


        return null;
    }


}
