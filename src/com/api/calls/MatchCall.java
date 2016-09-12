package com.api.calls;

import com.Log.Logger;
import com.example.test.HTTPResponse;
import org.json.JSONObject;

import java.io.IOException;

/**
 * Created by Thinh-Laptop on 05.08.2016.
 */
public class MatchCall implements ICalls{

    private final String region;
    private final long matchID;

    public MatchCall(String reg , long matchId){
        region = reg ;
        matchID = matchId ;
    }
    @Override
    public JSONObject execute() {

            //https://euw.api.pvp.net/api/lol/euw/v2.2/match/2785087212?api_key=303ccbe7-3c57-4d13-a389-d109963f4535

        StringBuilder param = new StringBuilder() ;

        param.append("https://")
                .append(region)
                .append(".api.pvp.net/api/lol/")
                .append(region)
                .append("/v2.2/match/")
                .append(matchID)
                .append("?api_key=")
                .append(APIKey.API_KEY);


        JSONObject result = null;

        try{
            result = HTTPResponse.GETRequest(param.toString());
        }catch(IOException e){
            Logger.info("Couldn't retrieve match information from "+ matchID);
            System.exit(1);
        }

        return result ;
    }

    @Override
    public void assembleData() {

    }
}
