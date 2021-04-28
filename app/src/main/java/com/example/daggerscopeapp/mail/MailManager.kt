package com.example.daggerscopeapp.mail

import com.example.daggerscopeapp.api.ApiService
import com.example.daggerscopeapp.models.Account
import com.example.daggerscopeapp.models.Folder
import com.example.daggerscopeapp.models.Letter

class MailManager(
    private val account: Account,
    private val apiService: ApiService
) {

    fun getFolders(): List<Folder> {
        return apiService.getFolders(account)
    }

    fun getLetters(folder: Folder): List<Letter> {
        return apiService.getLetters(folder)
    }
}