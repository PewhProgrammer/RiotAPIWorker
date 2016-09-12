package com.api.calls;

import com.Log.Logger;
import com.example.test.HTTPResponse;
import org.json.JSONObject;

import java.io.IOException;

/**
 * Created by Thinh on 19.06.2016.
 */
public class SummonerCall implements ICalls {

    private final String name ;
    private final String region ;

    public SummonerCall(String name,String region) {
        this.name = name ;
        this.region = region ;
    }

    @Override
    public JSONObject execute(){

        StringBuilder param = new StringBuilder() ;

        param.append("https://")
                .append(region)
                .append(".api.pvp.net/api/lol/")
                .append(region)
                .append("/v1.4/summoner/by-name/")
                .append(name)
                .append("?api_key=")
                .append(APIKey.API_KEY);


        try {
            return HTTPResponse.GETRequest(param.toString());
        }catch(IOException e){
            Logger.debug("Could not find Summoner "+ name);
            System.exit(1);
            return null;
        }
    }


    @Override
    public void assembleData() {

    }
}
