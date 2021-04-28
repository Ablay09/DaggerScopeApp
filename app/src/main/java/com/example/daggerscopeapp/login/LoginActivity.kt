package com.example.daggerscopeapp.login

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import com.example.daggerscopeapp.App
import com.example.daggerscopeapp.R
import com.example.daggerscopeapp.folders.FolderListActivity
import com.example.daggerscopeapp.models.Account
import javax.inject.Inject

class LoginActivity : AppCompatActivity() {

    @set:Inject
    internal var presenter: LoginActivityPresenter? = null

    @Inject
    fun setActivity() {
        presenter?.setActivity(this)
    }

    private lateinit var usernameEditText: EditText
    private lateinit var passwordEditText: EditText
    private lateinit var loginButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val loginActivityComponent = App.getInstance().getAppComponent().createLoginComponent()
        loginActivityComponent.injectLoginActivity(this)

        usernameEditText = findViewById(R.id.etUsername)
        passwordEditText = findViewById(R.id.etPassword)
        loginButton = findViewById(R.id.btnLogin)
    }

    override fun onResume() {
        super.onResume()
        setListeners()
    }

    private fun setListeners() {
        loginButton.setOnClickListener {
            presenter?.login(
                userName = usernameEditText.text.toString(),
                password = passwordEditText.text.toString()
            )
        }
    }

    fun showMailForAccount(account: Account) {
        App.getInstance().createMailComponent(account)
        startActivity(
            Intent(this, FolderListActivity::class.java)
        )
    }

    override fun onDestroy() {
        presenter?.destroy()
        super.onDestroy()
    }
}