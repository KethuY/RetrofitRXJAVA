package com.tallrocket.trial.login

import android.content.Context
import com.tallrocket.trial.helpers.Keys
import com.tallrocket.trial.helpers.SharedPrefHelper

/**
 * Created by user on 11/14/17.
 */

 class LoginPresenter(var loginView: LoginView?,var context:Context?) : LoginViewPresenter {


    override fun doLogin(name: String, passwd: String) {

        if(name.equals("")){
            loginView?.enterUserName();

            return;
        }

        if(passwd.equals("")){
            loginView?.enterPassword();
            return;
        }

        SharedPrefHelper(context);

        SharedPrefHelper.putString(Keys.USERNAME,name);
        SharedPrefHelper.putBoolean(Keys.IS_FIRST_TIME_LOGIN,true);

        loginView?.navigateToMainPage();
    }

}
