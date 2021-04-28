package com.example.daggerscopeapp.folders

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.daggerscopeapp.App
import com.example.daggerscopeapp.R
import com.example.daggerscopeapp.folders.adapter.FolderListAdapter
import com.example.daggerscopeapp.letters.LetterListActivity
import com.example.daggerscopeapp.models.Folder
import javax.inject.Inject

class FolderListActivity : AppCompatActivity() {

    @set:Inject
    internal var presenter: FolderListActivityPresenter? = null

    @Inject
    fun setActivity() {
        presenter?.setActivity(this)
    }

    private lateinit var rvFolders: RecyclerView
    private val adapter: FolderListAdapter by lazy {
        FolderListAdapter(::handleFolderClickEvent)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_folder_list)
        injectActivity()
        initRecycler()
        presenter?.loadFolders()
    }

    fun showFolders(folderList: List<Folder>) {
        adapter.submitList(folderList)
    }

    private fun injectActivity() {
        App.getInstance().getMailComponent()?.createFoldersListActivityComponent()
            ?.injectFolderListActivity(this)
    }

    private fun initRecycler() {
        rvFolders = findViewById(R.id.rvFolders)
        rvFolders.adapter = adapter
    }

    private fun handleFolderClickEvent(folder: Folder) {
        openFolder(folder)
    }

    private fun openFolder(folder: Folder) {
        val intent = Intent(this, LetterListActivity::class.java)
        intent.putExtra("folder", folder)
        startActivity(intent)
    }

    override fun onDestroy() {
        presenter?.destroy()
        App.getInstance().releaseMailComponent()
        super.onDestroy()
    }
}