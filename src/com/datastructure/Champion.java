package com.datastructure;

import com.Log.Logger;

/**
 * Created by Thinh-Laptop on 05.08.2016.
 */
public class Champion {

    private final Name mName ;
    private final boolean mFreeToPlay ;

    public Champion(int id,boolean freeToPlay){
        mName = getChampionName(id) ;
        mFreeToPlay = freeToPlay ;
    }

    private Name getChampionName(int i){

        switch(i){

            default:
                Logger.debug("New Champion found in Champion.java !!");
        }

        return null ;
    }

    public enum Name{
        Aatrox ,


    }

    @Override
    public String toString(){
        return mName.toString() ;
    }
}
