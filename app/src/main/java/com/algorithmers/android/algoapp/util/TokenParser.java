package com.algorithmers.android.algoapp.util;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by DevFatani on 7/19/2016 AD.
 */
public class TokenParser {


    public static String parseAndStore(Activity activity, JSONObject jsonObject) throws JSONException {


        String token;


        if (jsonObject.has("error")) {

            token = "error";

        } else if (jsonObject.has("token")) {


            token = jsonObject.getString("token");


            SharedPreferences.Editor editor = activity.getSharedPreferences("USER_TOKEN", Context.MODE_PRIVATE).edit();


            editor.putString("TOKEN", token);


            editor.apply();


        } else {

            token = "unknown error";

        }

        return token;

    }

}
