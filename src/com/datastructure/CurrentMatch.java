package com.datastructure;

import com.Log.Logger;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.*;

/**
 * Created by Thinh on 19.06.2016.
 */
public class CurrentMatch {

    private final int mGameID  ;
    private final int mGameStartTime ;
    private final int mMapID ;
    private final int mGameLength ;
    private final int mGameQueueConfigId ;

    private final String mGameType ;
    private final String mGameMode ;

    private final Set<Summoner> mSummoners ;


    /**
     * gameId , gameType , gameStartTime , mapId , platformId , gameLength , gameMode , gameQueueConfigId
     * bannedChampions , participants ,
     */

    public CurrentMatch(JSONArray players, List<Integer> argV, String... game ){

        Iterator<Integer> it = argV.iterator() ;

        mGameID = it.next();
        mGameStartTime = it.next() ;
        mMapID = it.next() ;
        mGameLength = it.next() ;
        mGameQueueConfigId = it.next() ;

        mGameType = game[0] ;
        mGameMode = game[1] ;

        Set<Summoner> summoners = new HashSet<>();

        Iterator<Object> itPlayers = players.iterator() ;
        while(itPlayers.hasNext()){
            JSONObject JSONPlayer_ = (JSONObject)itPlayers.next() ;
            Logger.info(JSONPlayer_.toString());
            summoners.add(newSummoner(JSONPlayer_,"summonerName","teamId","summonerId","spell1Id","spell2Id",
            "profileIconId","runes","bot","masteries"));
        }

        summoners.forEach(sum -> Logger.info(""+sum.getName()));
        // championID , profilIconID , runes , bot , teamId , summonerName ,spell1,summonerid , spell2 , masteries

        mSummoners = new HashSet<>(summoners);

    }

    private Summoner newSummoner(JSONObject JSONPlayer_ , String keys, String id,
                                 String teamId ,String spell1, String spell2, String profilIcon,
                                 String runes, String bot, String masteries){
        return new Summoner(JSONPlayer_.getString(keys),JSONPlayer_.getInt(id),JSONPlayer_.getInt(teamId),JSONPlayer_.getInt(spell1),
                JSONPlayer_.getInt(spell2),JSONPlayer_.getInt(profilIcon),JSONPlayer_.getBoolean(bot),JSONPlayer_.getJSONArray(runes),
                JSONPlayer_.getJSONArray(masteries));
    }


    public enum GameSide{
        Red("Team Blue"),
        Blue("Team Red");

        private final String id ;

        GameSide(String s){
            id = s ;
        }

        @Override
        public String toString(){
            return id ;
        }
    }


}
