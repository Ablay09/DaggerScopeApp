package com.example.daggerscopeapp.login

import com.example.daggerscopeapp.scopes.ActivityScope
import dagger.Subcomponent

@ActivityScope
@Subcomponent(modules = [LoginActivityModule::class])
interface LoginActivityComponent {

    fun injectLoginActivity(loginActivity: LoginActivity)
}