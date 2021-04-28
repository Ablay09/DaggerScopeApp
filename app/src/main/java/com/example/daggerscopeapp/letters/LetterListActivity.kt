package com.example.daggerscopeapp.letters

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.daggerscopeapp.App
import com.example.daggerscopeapp.R
import com.example.daggerscopeapp.letters.adapter.LetterListAdapter
import com.example.daggerscopeapp.models.Folder
import com.example.daggerscopeapp.models.Letter
import java.lang.IllegalArgumentException
import javax.inject.Inject

class LetterListActivity : AppCompatActivity() {

    @set:Inject
    internal var presenter: LetterListActivityPresenter? = null

    @Inject
    fun setActivity() {
        presenter?.setActivity(this)
    }

    private val adapter: LetterListAdapter by lazy {
        LetterListAdapter(::handleOnLetterClickEvent)
    }
    private lateinit var rvLetter: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_letter_list)
        initRecyclerView()
        injectActivity()
        presenter?.loadLetters()
    }

    fun showLetters(letterList: List<Letter>) {
        adapter.submitList(letterList)
    }

    private fun injectActivity() {
        val folder = intent.getParcelableExtra<Folder>("folder")
            ?: throw IllegalArgumentException("Folder is required in ${this::class.simpleName} bundle")
        App.getInstance().getMailComponent()?.createLetterListActivityComponent(
            LetterListActivityModule(folder)
        )?.injectLetterListActivity(this)
    }

    private fun initRecyclerView() {
        rvLetter = findViewById(R.id.rvLetters)
        rvLetter.adapter = adapter
    }

    private fun handleOnLetterClickEvent(letter: Letter) {
        Toast.makeText(this, "${letter.subject} is clicked", Toast.LENGTH_SHORT).show()
    }

    override fun onDestroy() {
        presenter?.destroy()
        super.onDestroy()
    }
}