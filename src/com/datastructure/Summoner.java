package com.datastructure;

import org.json.JSONArray;

/**
 * Created by Thinh on 19.06.2016.
 */
public class Summoner {
        private final String mName;
        private final int mID ;



    public Summoner(String name,int id){
        mName = name ;
        mID = id ;
    }

    public Summoner(String name, int id, int teamId , int spell1 , int spell2, int profilIcon, boolean bot,
                    JSONArray runes, JSONArray masteries){
        mName = name ;
        mID = id ;
    }

    public String getName() {
        return mName;
    }

    public int getID() {
        return mID;
    }

    @Override
    public boolean equals(Object other){
        if(!(other instanceof Summoner)) return false ;
        Summoner sum = (Summoner)other ;

        if(sum.getName().equals(mName) && sum.getID() == mID) return true ;

        return false ;
    }
}
