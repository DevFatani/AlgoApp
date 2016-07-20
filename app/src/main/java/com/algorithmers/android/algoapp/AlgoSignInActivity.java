package com.algorithmers.android.algoapp;


import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.algorithmers.android.algoapp.util.Progress;
import com.algorithmers.android.algoapp.util.TokenGenerator;
import com.algorithmers.android.algoapp.util.TokenParser;
import com.algorithmers.android.algoapp.util.VolleyJSONObjectHelper;
import com.android.volley.VolleyError;

import org.json.JSONException;
import org.json.JSONObject;

public class AlgoSignInActivity extends AppCompatActivity implements VolleyJSONObjectHelper.JSONObjectProgress {


    private EditText etActSignEmail, etActSignPassword;

    private Progress mProgress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        this.setContentView(R.layout.activity_algo_sign_in);


        this.etActSignEmail = (EditText) this.findViewById(R.id.etActSignEmail);

        this.etActSignPassword = (EditText) this.findViewById(R.id.etActSignPassword);


    }


    public void navigator(View v) {

        String email = this.etActSignEmail.getText().toString().trim();

        String password = this.etActSignPassword.getText().toString().trim();


        //Email and Password validation !

        if (!email.isEmpty() && !password.isEmpty()) {

            this.mProgress = new Progress(this);

            this.mProgress.show();

            SharedPreferences.Editor editor = this.getSharedPreferences("USER_AUTH", MODE_PRIVATE).edit();

            editor.putString("Email", email);
            editor.putString("Password", password);

            editor.apply();


            System.out.println("ok");


            new TokenGenerator(email, password, this);


        } else if (email.isEmpty() && password.isEmpty()) {


            this.etActSignEmail.setError(this.getString(R.string.email_validation_error));


            this.etActSignPassword.setError(this.getString(R.string.password_validation_error));


        } else if (email.isEmpty()) {


            this.etActSignEmail.setError(this.getString(R.string.email_validation_error));


        } else if (password.isEmpty()) {


            this.etActSignPassword.setError(this.getString(R.string.password_validation_error));


        }


    }

    @Override
    public void onDownloadJSONObjectSucceed(JSONObject jsonObject) {


        try {


            String token = TokenParser.parseAndStore(this, jsonObject);


            System.out.println(token);

            if (token.equals("error") || token.equals("unknown error")) {

                this.etActSignEmail.setError(this.getString(R.string.email_error_response));

                this.etActSignPassword.setError(this.getString(R.string.password_error_response));


            } else {


                this.mProgress.stop();

                this.startActivity(new Intent(this, AlgoSnippetListActivity.class));

                this.finishAffinity();

            }

        } catch (JSONException e) {

            e.printStackTrace();


        }


    }

    @Override
    public void onDownloadJSONObjectFailure(VolleyError error) {

        this.etActSignEmail.setError(this.getString(R.string.email_error_response));

        this.etActSignPassword.setError(this.getString(R.string.password_error_response));

    }


}