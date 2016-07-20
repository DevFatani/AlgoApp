package com.algorithmers.android.algoapp.util;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;

import com.algorithmers.android.algoapp.R;
import com.android.volley.Request;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by DevFatani on 7/18/2016 AD.
 */
public class TokenGenerator {

    private JSONObject userLogin;

    private Activity activity;

    public TokenGenerator(String email, String password, Activity activity) {


        this.activity = activity;

        this.userLogin = new JSONObject();

        try {

            this.userLogin.put("email", email);

            this.userLogin.put("password", password);

        } catch (JSONException e) {
            e.printStackTrace();
        }


        this.connect();

    }

    public TokenGenerator(Activity activity) {

        SharedPreferences sharedPreferences = activity.getSharedPreferences("USER_AUTH", Context.MODE_PRIVATE);


        String email = sharedPreferences.getString("Email", "Empty_Email");

        String password = sharedPreferences.getString("Password", "Empty_Password");


        if (!email.equals("Empty_Email") || !password.equals("Empty_Password")) {


            this.userLogin = new JSONObject();


            try {

                this.userLogin.put("email", email);

                this.userLogin.put("password", password);

            } catch (JSONException e) {

                e.printStackTrace();


            }

            this.activity = activity;

            this.connect();


        } else {


            System.out.println("Not Connected !");

        }


    }

    private void connect() {

        Volley
                .newRequestQueue(this.activity)

                .add(new VolleyJSONObjectHelper(Request.Method.POST, this.activity.getString(R.string.user_login), this.userLogin, this.activity))

                .setRetryPolicy(new VolleyRetryPolicy().set());


    }

}