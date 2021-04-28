package com.example.daggerscopeapp.folders

import com.example.daggerscopeapp.scopes.ActivityScope
import dagger.Subcomponent

@ActivityScope
@Subcomponent(modules = [FolderListActivityModule::class])
interface FolderListActivityComponent {

    fun injectFolderListActivity(activity: FolderListActivity)
}