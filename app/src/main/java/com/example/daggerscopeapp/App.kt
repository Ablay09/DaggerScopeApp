package com.example.daggerscopeapp

import android.app.Application
import com.example.daggerscopeapp.mail.MailComponent
import com.example.daggerscopeapp.mail.MailModule
import com.example.daggerscopeapp.models.Account

class App : Application() {

    companion object {
        private lateinit var instance: App

        fun getInstance(): App {
            return instance
        }
    }

    private lateinit var appComponent: AppComponent
    private var mailComponent: MailComponent? = null

    override fun onCreate() {
        super.onCreate()
        instance = this
        appComponent = DaggerAppComponent.create()
    }

    fun getAppComponent(): AppComponent {
        return appComponent
    }

    fun createMailComponent(account: Account) {
        mailComponent = appComponent.createMailComponent(MailModule(account))
    }

    fun getMailComponent(): MailComponent? {
        return mailComponent
    }

    fun releaseMailComponent() {
        mailComponent = null
    }
}