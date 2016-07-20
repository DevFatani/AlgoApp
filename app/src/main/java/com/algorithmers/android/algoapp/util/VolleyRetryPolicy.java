package com.algorithmers.android.algoapp.util;

import com.android.volley.DefaultRetryPolicy;

/**
 * Created by DevFatani on 7/18/2016 AD.
 */
public class VolleyRetryPolicy {


    public static DefaultRetryPolicy set() {
        return new DefaultRetryPolicy(100000, DefaultRetryPolicy.DEFAULT_MAX_RETRIES, DefaultRetryPolicy.DEFAULT_BACKOFF_MULT);
    }

}
