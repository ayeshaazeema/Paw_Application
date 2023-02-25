package com.bisha.paw.presentation.splash

import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity
import com.bisha.paw.R
import com.bisha.paw.presentation.main.MainActivity
import com.bisha.paw.presentation.authentication.SignInActivity
import com.bisha.paw.presentation.onboarding.OnboardingActivity
import com.bisha.paw.utils.SessionManager

class SplashActivity : AppCompatActivity() {

    private val sessionManager: SessionManager by lazy {
        return@lazy SessionManager(this)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        supportActionBar?.hide()

        Handler().postDelayed({
            if (sessionManager.isOnBoarded()) {
                SignInActivity.start(this@SplashActivity)
            } else if (sessionManager.isLoggedIn()) {
                MainActivity.start(this@SplashActivity)
            } else {
                OnboardingActivity.start(this@SplashActivity)
            }
            finish()
        }, 4000)
    }
}