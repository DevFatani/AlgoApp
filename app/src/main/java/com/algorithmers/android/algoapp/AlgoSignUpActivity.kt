package com.algorithmers.android.algoapp

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class AlgoSignUpActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_algo_sign_up)
    }

    fun nav(view: View?) {

        this.startActivity(Intent(this, AlgoMainServicesActivity::class.java))

    }
}
