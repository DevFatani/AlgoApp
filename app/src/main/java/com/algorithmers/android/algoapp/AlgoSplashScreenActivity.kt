package com.algorithmers.android.algoapp

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler

class AlgoSplashScreenActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        this.setContentView(R.layout.activity_algo_splash_screen)
        Handler().postDelayed({
            kotlin.run {
                nav()
            }
        }, 1000)
    }

    private fun nav() {
        this.startActivity(Intent(this, AlgoMainActivity::class.java))
        this.finishAffinity()
    }
}
