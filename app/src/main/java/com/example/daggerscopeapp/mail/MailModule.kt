package com.example.daggerscopeapp.mail

import com.example.daggerscopeapp.api.ApiService
import com.example.daggerscopeapp.models.Account
import dagger.Module
import dagger.Provides

@Module
class MailModule(private val account: Account) {

    @Provides
    fun provideAccount(): Account {
        return account
    }

    @Provides
    @MailScope
    fun provideMailManager(account: Account, apiService: ApiService): MailManager {
        return MailManager(account, apiService)
    }
}