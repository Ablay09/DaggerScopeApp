package com.example.daggerscopeapp.login

import com.example.daggerscopeapp.account.AccountManager
import com.example.daggerscopeapp.api.ApiService
import com.example.daggerscopeapp.scopes.ActivityScope
import dagger.Module
import dagger.Provides

@Module
class LoginActivityModule {

    @ActivityScope
    @Provides
    fun provideAccountManager(apiService: ApiService): AccountManager {
        return AccountManager(apiService)
    }

    @ActivityScope
    @Provides
    fun provideLoginActivityPresenter(accountManager: AccountManager): LoginActivityPresenter {
        return LoginActivityPresenter(accountManager)
    }

}