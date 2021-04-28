package com.example.daggerscopeapp.letters

import com.example.daggerscopeapp.scopes.ActivityScope
import dagger.Subcomponent
import javax.inject.Singleton

@ActivityScope
@Subcomponent(modules = [LetterListActivityModule::class])
interface LetterListActivityComponent {

    fun injectLetterListActivity(activity: LetterListActivity)
}