package com.tallrocket.trial.login

/**
 * Created by kethu on 11/14/17.
 */

interface LoginView {
    fun enterUserName()
    fun setUserNameError();
    fun enterPassword();
    fun navigateToMainPage();
}
