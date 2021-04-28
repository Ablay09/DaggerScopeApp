package com.example.daggerscopeapp.api

import com.example.daggerscopeapp.models.Account
import com.example.daggerscopeapp.models.Folder
import com.example.daggerscopeapp.models.Letter

class ApiService {

    fun login(userName: String, password: String): Account {
        return generateFakeAccount()
    }

    fun getFolders(account: Account): List<Folder> {
        return generateFakeFolders()
    }

    fun getLetters(folder: Folder): List<Letter> {
        return generateFakeLetters()
    }

    private fun generateFakeAccount(): Account {
        return Account()
    }

    private fun generateFakeFolders(): List<Folder> {
        val folders = mutableListOf<Folder>()
        folders.add(Folder("Inbox"))
        folders.add(Folder("Sent"))
        folders.add(Folder("Starred"))
        folders.add(Folder("Drafts"))
        return folders
    }

    private fun generateFakeLetters(): List<Letter> {
        val letters = mutableListOf<Letter>()
        letters.add(Letter("Subject 1"))
        letters.add(Letter("Subject 2"))
        letters.add(Letter("Subject 3"))
        letters.add(Letter("Subject 4"))
        return letters
    }
}