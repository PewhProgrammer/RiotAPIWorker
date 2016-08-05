package com.api.calls;

import com.Log.Logger;
import com.example.test.HTTPResponse;
import org.json.JSONObject;

import java.io.IOException;

/**
 * Created by Thinh-Laptop on 05.08.2016.
 */
public class FreeToPlayCall implements ICalls {

    protected final String region ;

    public FreeToPlayCall(String reg){
        region = reg ;
    }

    @Override
    public JSONObject execute() throws IOException {
        StringBuilder param = new StringBuilder() ;

        //https://euw.api.pvp.net/api/lol/euw/v1.2/champion?freeToPlay=true&api_key=303ccbe7-3c57-4d13-a389-d109963f4535

        param.append("https://")
                .append(region)
                .append(".api.pvp.net/api/lol/")
                .append(region)
                .append("/")
                .append("v1.2/champion?freeToPlay=true&api_key=")
                .append(APIKey.API_KEY);


        JSONObject result = null;

        try{
            result = HTTPResponse.GETRequest(param.toString());
        }catch(IOException e){
            Logger.info("Player is not in a game");
            System.exit(1);
        }

        Logger.info(result.toString());
        return result ;
    }

    @Override
    public void assembleData() {

    }
}
