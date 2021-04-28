package com.example.daggerscopeapp

import com.example.daggerscopeapp.api.ApiModule
import com.example.daggerscopeapp.login.LoginActivityComponent
import com.example.daggerscopeapp.mail.MailComponent
import com.example.daggerscopeapp.mail.MailModule
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [ApiModule::class])
interface AppComponent {

    fun createLoginComponent(): LoginActivityComponent

    fun createMailComponent(mailModule: MailModule): MailComponent
}