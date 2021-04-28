package com.example.daggerscopeapp.mail

import com.example.daggerscopeapp.folders.FolderListActivityComponent
import com.example.daggerscopeapp.letters.LetterListActivityComponent
import com.example.daggerscopeapp.letters.LetterListActivityModule
import dagger.Subcomponent

@MailScope
@Subcomponent(modules = [MailModule::class])
interface MailComponent {

    fun createFoldersListActivityComponent(): FolderListActivityComponent

    fun createLetterListActivityComponent(letterListActivityModule: LetterListActivityModule): LetterListActivityComponent

}