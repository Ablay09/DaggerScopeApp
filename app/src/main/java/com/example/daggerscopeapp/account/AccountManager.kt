package com.example.daggerscopeapp.account

import com.example.daggerscopeapp.api.ApiService
import com.example.daggerscopeapp.models.Account

class AccountManager(private val apiService: ApiService) {

    fun login(userName: String, password: String): Account {
        return apiService.login(userName, password)
    }

}