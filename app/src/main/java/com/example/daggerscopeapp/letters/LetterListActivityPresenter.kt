package com.example.daggerscopeapp.letters

import com.example.daggerscopeapp.mail.MailManager
import com.example.daggerscopeapp.models.Folder


class LetterListActivityPresenter(
    private val folder: Folder,
    private val mailManager: MailManager
) {

    private var activity: LetterListActivity? = null

    fun setActivity(activity: LetterListActivity) {
        this.activity = activity
    }

    fun loadLetters() {
        activity?.showLetters(mailManager.getLetters(folder))
    }

    fun destroy() {
        activity = null
    }
}

