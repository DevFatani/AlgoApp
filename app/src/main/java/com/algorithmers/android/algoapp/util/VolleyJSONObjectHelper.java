package com.algorithmers.android.algoapp.util;

import android.app.Activity;

import com.algorithmers.android.algoapp.R;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;

import org.json.JSONObject;

/**
 * Created by DevFatani on 7/18/2016 AD.
 */
public class VolleyJSONObjectHelper extends JsonObjectRequest {

    private JSONObjectProgress mJsonObjectProgress;


    public VolleyJSONObjectHelper(int method, String url, JSONObject requestBody, Activity activity) {

        super(method, (activity.getString(R.string.main_url) + url), requestBody, null, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {


                VolleyExceptionHandler.run("VolleyJSONObjectHelper", error);

            }
        });


        this.mJsonObjectProgress = (JSONObjectProgress) activity;
    }


    @Override
    protected void deliverResponse(JSONObject response) {

        super.deliverResponse(response);

        this.mJsonObjectProgress.onDownloadJSONObjectSucceed(response);
    }

    @Override
    public void deliverError(VolleyError error) {

        super.deliverError(error);

        this.mJsonObjectProgress.onDownloadJSONObjectFailure(error);

    }


    public interface JSONObjectProgress {

        void onDownloadJSONObjectSucceed(JSONObject jsonObject);


        void onDownloadJSONObjectFailure(VolleyError error);

    }
}
