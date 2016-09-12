package com.api.calls;

import com.Log.Logger;
import com.example.test.HTTPResponse;
import org.json.JSONObject;

import java.io.IOException;

/**
 * Created by Thinh-Laptop on 05.08.2016.
 */
public class RecentGamesCall implements ICalls{

    private final String region ;
    private final int id ;

    public RecentGamesCall(String r,int i){
        region = r ;
        id = i ;
    }

    @Override
    public JSONObject execute() {

        //https://euw.api.pvp.net/api/lol/euw/v1.3/game/by-summoner/83009291/recent?api_key=303ccbe7-3c57-4d13-a389-d109963f4535

        StringBuilder param = new StringBuilder() ;

        param.append("https://")
                .append(region)
                .append(".api.pvp.net/api/lol/")
                .append(region)
                .append("/v1.3/game/by-summoner/")
                .append(id)
                .append("/recent?api_key=")
                .append(APIKey.API_KEY);


        JSONObject result = null;

        try{
            result = HTTPResponse.GETRequest(param.toString());
        }catch(IOException e){
            Logger.info("Couldn't retrieve recent matches information from "+ id);
            System.exit(1);
        }

        return result ;
    }

    @Override
    public void assembleData() {

    }
}
