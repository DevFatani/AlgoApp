package com.algorithmers.android.algoapp;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class AlgoMainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);


        this.setContentView(R.layout.activity_algo_main);


        SharedPreferences sharedPreferences = this.getSharedPreferences("USER_AUTH", MODE_PRIVATE);


        String email = sharedPreferences.getString("Email", "Empty_Email");

        String password = sharedPreferences.getString("Password", "Empty_Password");


        if (!email.equals("Empty_Email") || !password.equals("Empty_Password")) {


            this.startActivity(new Intent(this, AlgoSnippetListActivity.class));

            this.finishAffinity();

        }


    }


    public void navigator(View v) {

        if (v.getId() == R.id.btnActMainSignIn) {


            this.startActivity(new Intent(this, AlgoSignInActivity.class));

        } else {


        }

    }
}
