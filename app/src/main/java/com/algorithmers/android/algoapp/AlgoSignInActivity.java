package com.algorithmers.android.algoapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class AlgoSignInActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_algo_sign_in);


    }


    public void navigator(View v){

        if(v.getId() == R.id.btnActSignInEnter){


            this.startActivity(new Intent(this, AlgoSnippetListActivity.class));

        }else{



        }

    }
}
