package com.example.imac.checkcounter.ui.screen.splash

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.example.imac.checkcounter.R
import com.example.imac.checkcounter.data.AppDatabase
import com.example.imac.checkcounter.ui.router.Router

class SplashActivity : AppCompatActivity() {

    private val router = Router.getInstance(supportFragmentManager)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        AppDatabase.getInstance(applicationContext)
        router.add(Router.CHECK_LIST)
    }
}
