package com.algorithmers.android.algoapp.util;

import android.util.Log;

import com.android.volley.AuthFailureError;
import com.android.volley.NetworkError;
import com.android.volley.NoConnectionError;
import com.android.volley.ParseError;
import com.android.volley.Response;
import com.android.volley.ServerError;
import com.android.volley.TimeoutError;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.Volley;

/**
 * Created by DevFatani on 7/18/2016 AD.
 */
public class VolleyExceptionHandler {

    public static void run(String clazz, VolleyError error) {


        if (error instanceof NetworkError) {

            error.printStackTrace();

            Log.e(clazz, " Network Error");

        } else if (error instanceof ServerError) {


            error.printStackTrace();

            Log.e(clazz, "Server Error");


        } else if (error instanceof ParseError) {

            error.printStackTrace();

            Log.e(clazz, "Parse Error");


        } else if (error instanceof AuthFailureError) {

            error.printStackTrace();

            Log.e(clazz, "AuthFailure Error");


        } else if (error instanceof TimeoutError) {

            error.printStackTrace();

            Log.e(clazz, "Timeout Error");

        }

    }

}
