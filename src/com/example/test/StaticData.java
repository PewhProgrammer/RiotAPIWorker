package com.example.test;

/**
 * Created by Thinh-Laptop on 05.08.2016.
 */
public class StaticData {

    // whitespaces are replaced by %20
    protected final static String __NAME__ = "Sebekx";
    protected final static String __REGION__ = "euw" ;

    protected final static Task task = Task.FreeToPlay ;

    protected enum Task{
        FreeToPlay,
        CurrentMatch,
        AnalyseRecentMatches,
    }
}
