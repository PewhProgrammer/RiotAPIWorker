package com.api.calls;

import com.example.test.Domain;
import com.example.test.HTTPResponse;
import org.json.JSONObject;

import java.io.IOException;
import java.util.logging.Logger;

/**
 * Created by Thinh on 19.06.2016.
 */
public class SummonerCall implements ICalls {
    private final static Logger log = Logger.getLogger(Domain.class.getName());
    private final String name ;
    private final String region ;

    public SummonerCall(String name,String region) {
        this.name = name ;
        this.region = region ;
    }

    @Override
    public JSONObject execute() throws IOException{

        StringBuilder param = new StringBuilder() ;

        param.append("https://")
                .append(region)
                .append(".api.pvp.net/api/lol/")
                .append(region)
                .append("/v1.4/summoner/by-name/")
                .append(name)
                .append("?api_key=")
                .append(APIKey.API_KEY);


        return HTTPResponse.GETRequest(param.toString());
    }


    @Override
    public void assembleData() {

    }
}
