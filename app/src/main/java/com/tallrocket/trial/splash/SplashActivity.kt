package com.tallrocket.trial.splash

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.Window
import android.view.WindowManager
import com.tallrocket.trial.R
import com.tallrocket.trial.login.LoginActivity
import com.tallrocket.trial.main.MainActivity
import android.view.animation.AnimationUtils
import android.view.animation.Animation
import android.widget.ImageView


class SplashActivity : AppCompatActivity(), SplashView {


    var mSplashViewPresenter: SplashViewPresenter? = null;
    var mSplashView: SplashView? = null;


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        setUp();
    }

    private fun setUp() {
        mSplashView = this
        mSplashViewPresenter = SplashPresenter(mSplashView, this)
        mSplashViewPresenter?.fadeTheLogo();
        mSplashViewPresenter?.sleepForTwoSeconds();
    }

    override fun fadeTheLogo() {
        val image = findViewById<ImageView>(R.id.imageview)
        val animation = AnimationUtils.loadAnimation(applicationContext, R.anim.fade)
        image.startAnimation(animation)
    }

    override fun navigateToMainPage() {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
        finish()

    }

    override fun navigateToLoginPage() {
        val intent = Intent(this, LoginActivity::class.java)
        startActivity(intent)
        finish()
    }

}
