package com.algorithmers.android.algoapp.util;

import android.app.Activity;
import android.app.ProgressDialog;

import com.algorithmers.android.algoapp.R;

/**
 * Created by DevFatani on 7/20/2016 AD.
 */
public class Progress {


    private ProgressDialog mProgressDialog;


    public Progress(Activity activity) {

        this.mProgressDialog = new ProgressDialog(activity);

        this.mProgressDialog.setTitle(activity.getString(R.string.progress_title));

        this.mProgressDialog.setMessage(activity.getString(R.string.progress_msg));

        this.mProgressDialog.setIndeterminate(false);


    }


    public Progress(Activity activity, String title, String message) {

        this.mProgressDialog = new ProgressDialog(activity);

        this.mProgressDialog.setTitle(title);

        this.mProgressDialog.setMessage(message);


        this.mProgressDialog.setIndeterminate(false);


    }


    public void show() {

        this.mProgressDialog.show();

    }

    public void stop() {

        this.mProgressDialog.hide();
    }

}
