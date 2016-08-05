package com.api.calls;

import com.example.test.HTTPResponse;
import org.json.JSONObject;
import com.Log.Logger;

import java.io.IOException;

/**
 * Created by Thinh on 19.06.2016.
 */
public class CurrentMatchCall implements ICalls {

    private final String id ;
    private final String region ;
    private final String platform ;

    public CurrentMatchCall(String id, String region,String platform) {
        this.id = id ;
        this.region = region ;
        this.platform = platform ;
    }


    @Override
    public JSONObject execute() throws IOException {

        StringBuilder param = new StringBuilder() ;

        param.append("https://")
                .append(region)
                .append(".api.pvp.net/observer-mode/rest/consumer/getSpectatorGameInfo/")
                .append(platform)
                .append("/")
                .append(id)
                .append("?api_key=")
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

    @Override
    public String toString() {
        return "CurrentMatchCall{" +
                "id='" + id + '\'' +
                ", region='" + region + '\'' +
                ", platform='" + platform + '\'' +
                '}';
    }
}
