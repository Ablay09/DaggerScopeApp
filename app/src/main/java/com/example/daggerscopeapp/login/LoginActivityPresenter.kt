package com.example.daggerscopeapp.login

import com.example.daggerscopeapp.account.AccountManager
import com.example.daggerscopeapp.models.Account

class LoginActivityPresenter(
    private val accountManager: AccountManager
) {

    private var activity: LoginActivity? = null

    fun setActivity(activity: LoginActivity) {
        this.activity = activity
    }

    fun login(userName: String, password: String) {
        val account: Account = accountManager.login(userName, password)
        activity?.showMailForAccount(account)
    }

    fun destroy() {
        activity = null
    }

}