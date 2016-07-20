package com.algorithmers.android.algoapp.util;

import android.app.Activity;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;

import org.json.JSONArray;

/**
 * Created by DevFatani on 7/18/2016 AD.
 */
public class VolleyJSONArrayHelper extends JsonArrayRequest {


    private JSONArrayProgress mJsonArrayProgress;

    public VolleyJSONArrayHelper(int method, String url, String requestBody, Activity activity) {

        super(method, url, requestBody, null, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {


                VolleyExceptionHandler.run("VolleyJSONArrayHelper", error);

            }
        });


        this.mJsonArrayProgress = (JSONArrayProgress) activity;
    }


    @Override
    protected void deliverResponse(JSONArray response) {

        super.deliverResponse(response);


        this.mJsonArrayProgress.onDownloadJSONArraySucceed(response);

    }

    @Override
    public void deliverError(VolleyError error) {

        super.deliverError(error);

        this.mJsonArrayProgress.onDownloadJSONArrayFailure(error);

    }


    public interface JSONArrayProgress {


        void onDownloadJSONArraySucceed(JSONArray jsonArray);


        void onDownloadJSONArrayFailure(VolleyError error);


    }
}
