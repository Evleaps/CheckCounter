package com.example.imac.checkcounter.ui.splash

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.example.imac.checkcounter.R

class SplashActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        this.finish()
    }
}
