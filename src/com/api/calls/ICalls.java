package com.api.calls;


import com.datastructure.Summoner;
import org.json.JSONObject;

import java.io.IOException;

/**
 * Created by Thinh on 19.06.2016.
 */
public interface  ICalls {

    JSONObject execute() throws IOException;
    void assembleData();
    String toString();
}
