package com.tallrocket.trial.splash

import android.content.Context
import android.os.Handler
import com.tallrocket.trial.helpers.Keys.Companion.IS_FIRST_TIME_LOGIN
import com.tallrocket.trial.helpers.SharedPrefHelper

/**
 * Created by user on 11/15/17.
 */

class SplashPresenter(var splashView: SplashView?, var context: Context?) : SplashViewPresenter {

    override fun fadeTheLogo() {
        splashView?.fadeTheLogo()
    }

    override fun sleepForTwoSeconds() {

        Handler().postDelayed(
                {
                    SharedPrefHelper(context)

                    val isAlreadyLogin = SharedPrefHelper.getBoolean(IS_FIRST_TIME_LOGIN)

                    if (isAlreadyLogin) {
                        splashView?.navigateToMainPage();
                    } else {
                        splashView?.navigateToLoginPage()
                    }

                }, SPLASH_TIME_OUT.toLong())
    }



    companion object {
        private val SPLASH_TIME_OUT = 2000
    }
}
