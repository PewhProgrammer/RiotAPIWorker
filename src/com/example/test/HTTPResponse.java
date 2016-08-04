package com.example.test;

import com.Log.Logger;
import com.api.calls.CurrentMatchCall;
import com.api.calls.ICalls;
import com.api.calls.SummonerCall;
import com.datastructure.CurrentMatch;
import com.datastructure.Summoner;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by Thinh on 19.06.2016.
 */
public class HTTPResponse {


    /**
     * processes the JSON Response
     * @return
     * @throws java.io.IOException
     */
    public static String processHTTP() throws java.io.IOException {

        String $name = "realwasabi";
        String $region = "euw";

        Logger.setLevel(Logger.Level.INFO);
        Logger.info("initializing Player: " + $name +" in region " + $region);

        ICalls summonerCall = new SummonerCall($name,$region) ;
        Summoner player = CallExecutioner.parseSummoner(summonerCall) ;
        ICalls currentMatchCall = new CurrentMatchCall("" + player.getID(), "euw", "EUW1");
        CurrentMatch cMatch = CallExecutioner.parseCurrentMatch(currentMatchCall) ;

        return null ;

    }

    public static JSONObject GETRequest(String param) throws IOException{
        URL url = new URL(param.toString());
        HttpURLConnection connection = (HttpURLConnection)url.openConnection();
        connection.setRequestMethod("GET");
        connection.connect();

        // read the contents using an InputStreamReader
        InputStream stream = connection.getInputStream();
        JSONObject profil = new JSONObject(HTTPResponse.convertStreamToString(stream));

        return profil ;

    }

    /**
     * Little trick with Scanner to convert Stream into String via Scanner as
     * it takes the whole line as a token
     * @param is
     * @return
     */
    public static String convertStreamToString(java.io.InputStream is) {
        java.util.Scanner s = new java.util.Scanner(is).useDelimiter("\\A");
        return s.hasNext() ? s.next() : "";
    }
}