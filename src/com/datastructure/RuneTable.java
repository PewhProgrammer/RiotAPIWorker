package com.datastructure;

/**
 * Created by Thinh-Laptop on 05.08.2016.
 */
public enum RuneTable {


    // TODO

    Ability_Power(5235,"+3.85 ability power",true,2),
    Scaling_Cooldown_Reduction(5234,"-0.21% cooldowns per level (-3.9% at champion level 18)",true,2);




    public final int ID ;
    public final String Value ;
    public final boolean Quint ;
    public final int Tier ;

    RuneTable(int id , String value, boolean quint,int tier){
        ID = id ;
        Value = value ;
        Quint = quint ;
        Tier = tier ;
    }
}
