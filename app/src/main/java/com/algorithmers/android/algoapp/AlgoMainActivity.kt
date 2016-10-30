package com.algorithmers.android.algoapp

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.View

class AlgoMainActivity : Activity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        this.setContentView(R.layout.activity_algo_main)
    }

    fun nav(view: View?) {
        val viewId = view!!.id
        if (viewId == R.id.btnActMainSignIn) {
            this.startActivity(Intent(this, AlgoMainServicesActivity::class.java))
            this.finishAffinity()
        } else if (viewId == R.id.btnActMainForgetPassword) {

        } else if (viewId == R.id.btnActMainSignUp) {
            this.startActivity(Intent(this, AlgoSignUpActivity::class.java))
        }
    }
}
