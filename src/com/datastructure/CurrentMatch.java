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
            summoners.add(newSummoner(JSONPlayer_,"summonerName","summonerId","championId","teamId","spell1Id","spell2Id",
            "profileIconId","runes","bot","masteries"));
        }

        //each player
        //Logger.info("SummonerList : " + summoners.toString());
        // championID , profilIconID , runes , bot , teamId , summonerName ,spell1,summonerid , spell2 , masteries

        mSummoners = new HashSet<>(summoners);

    }

    private Summoner newSummoner(JSONObject JSONPlayer_ , String keys, String id,String championId,
                                 String teamId ,String spell1, String spell2, String profilIcon,
                                 String runes, String bot, String masteries){
        return new Summoner(JSONPlayer_.getString(keys),JSONPlayer_.getInt(id),JSONPlayer_.getInt(championId),JSONPlayer_.getInt(teamId),JSONPlayer_.getInt(spell1),
                JSONPlayer_.getInt(spell2),JSONPlayer_.getInt(profilIcon),JSONPlayer_.getBoolean(bot),JSONPlayer_.getJSONArray(runes),
                JSONPlayer_.getJSONArray(masteries));
    }

    public int getmGameID() {
        return mGameID;
    }

    public int getmGameStartTime() {
        return mGameStartTime;
    }

    public int getmMapID() {
        return mMapID;
    }

    public int getmGameLength() {
        return mGameLength;
    }

    public int getmGameQueueConfigId() {
        return mGameQueueConfigId;
    }

    public String getmGameType() {
        return mGameType;
    }

    public String getmGameMode() {
        return mGameMode;
    }

    public Set<Summoner> getmSummoners() {
        return mSummoners;
    }

    public enum GameSide{
        Red("Team Blue",0),
        Blue("Team Red",1);

        private final String display ;
        public final int Id ;

        GameSide(String s,int id){
            display = s ;
            Id = id ;
        }

        @Override
        public String toString(){
            return display ;
        }
    }


}
