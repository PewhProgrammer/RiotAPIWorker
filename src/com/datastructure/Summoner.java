package com.datastructure;

import com.Log.Logger;
import org.json.JSONArray;

/**
 * Created by Thinh on 19.06.2016.
 */
public class Summoner {

    private final String mName;
    private final int mID ;

    private final CurrentMatch.GameSide mTeam ;
    private final SpellTable mSpell_1 ;
    private final SpellTable mSpell_2 ;
    private final int mProfilIcon ;
    private final boolean mBot ;



    public Summoner(String name,int id){
        mName = name ;
        mID = id ;

        mTeam = null;
        mSpell_1 = null;
        mSpell_2 = null;
        mProfilIcon = -1 ;
        mBot = false;
    }

    public class Runes{

    }

    public Summoner(String name, int id, int teamId , int spell1 , int spell2, int profilIcon, boolean bot,
                    JSONArray runes, JSONArray masteries){
        mName = name ;
        mID = id ;

        mTeam = teamId == 100 ? CurrentMatch.GameSide.Blue : CurrentMatch.GameSide.Red ;
        mSpell_1 = getSpell(spell1);
        mSpell_2 = getSpell(spell2);

        mProfilIcon = profilIcon ;
        mBot = bot ;

        //TODO: process runes and masteries

        Logger.info(runes.toString());

    }

    private SpellTable getSpell(int i){

        switch(i){
            case 1:
                return SpellTable.Cleanse;
            case 2:
                return SpellTable.Clairvoyance;
            case 3:
                return SpellTable.Exhaust ;
            case 4:
                return SpellTable.Flash ;
            case 6:
                return SpellTable.Ghost;
            case 7:
                return SpellTable.Heal;
            case 11:
                return SpellTable.Smite;
            case 12:
                return SpellTable.Teleport;
            case 13:
                return SpellTable.Clarity;
            case 14:
                return SpellTable.Ignite;
            default:
                Logger.debug("Unresolved Summoner Spell identified: "+ i);
        }

        System.exit(1);
        return null;

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
