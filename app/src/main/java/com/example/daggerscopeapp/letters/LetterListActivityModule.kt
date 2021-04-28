package com.example.daggerscopeapp.letters

import com.example.daggerscopeapp.mail.MailManager
import com.example.daggerscopeapp.models.Folder
import com.example.daggerscopeapp.scopes.ActivityScope
import dagger.Module
import dagger.Provides

@Module
class LetterListActivityModule(
    private val folder: Folder
) {

    @ActivityScope
    @Provides
    fun provideFolder(): Folder {
        return folder
    }

    @ActivityScope
    @Provides
    fun provideLetterListActivityPresenter(
        folder: Folder,
        mailManager: MailManager
    ): LetterListActivityPresenter {
        return LetterListActivityPresenter(folder, mailManager)
    }
}

