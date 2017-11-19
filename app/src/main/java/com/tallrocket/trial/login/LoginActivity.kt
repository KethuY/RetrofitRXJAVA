package com.tallrocket.trial.login

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import butterknife.ButterKnife
import butterknife.BindView
import butterknife.OnClick
import com.tallrocket.trial.R
import com.tallrocket.trial.main.MainActivity


class LoginActivity : AppCompatActivity(), LoginView {
   // DestinationActivity::class.java


    var username: EditText? = null
    var password: EditText? = null
    var login:Button?=null


    private var mLoginViewPresenter: LoginViewPresenter? = null
    private var mLoginView: LoginView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        mLoginView = this;
        mLoginViewPresenter = LoginPresenter(mLoginView,this)
        login = findViewById<Button>(R.id.login)
        username=findViewById<EditText>(R.id.username)
        password=findViewById<EditText>(R.id.password)

        login?.setOnClickListener {
            mLoginViewPresenter?.doLogin(username?.text.toString(), password?.text.toString())
        }

    }


    override fun enterUserName() {
        Toast.makeText(this, "Enter Username", Toast.LENGTH_SHORT).show()
    }

    override fun setUserNameError() {

    }

    override fun enterPassword() {
        Toast.makeText(this, "Enter Password", Toast.LENGTH_SHORT).show()
    }

    override fun navigateToMainPage() {
        startActivity(Intent(this,MainActivity::class.java))
    }
}
