package com.example.daggerscopeapp.folders

import com.example.daggerscopeapp.mail.MailManager
import com.example.daggerscopeapp.scopes.ActivityScope
import dagger.Module
import dagger.Provides

@Module
class FolderListActivityModule {

    @ActivityScope
    @Provides
    fun provideFolderListActivityPresenter(mailManager: MailManager): FolderListActivityPresenter {
        return FolderListActivityPresenter(mailManager)
    }
}