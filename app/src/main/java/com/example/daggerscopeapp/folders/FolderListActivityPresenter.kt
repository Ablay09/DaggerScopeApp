package com.example.daggerscopeapp.folders

import com.example.daggerscopeapp.mail.MailManager

class FolderListActivityPresenter(
    private val mailManager: MailManager
) {

    private var activity: FolderListActivity? = null

    fun setActivity(activity: FolderListActivity) {
        this.activity = activity
    }

    fun loadFolders() {
        activity?.showFolders(mailManager.getFolders())
    }
    fun destroy() {
        activity = null
    }
}