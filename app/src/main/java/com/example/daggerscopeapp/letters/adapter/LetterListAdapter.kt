package com.example.daggerscopeapp.letters.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.daggerscopeapp.R
import com.example.daggerscopeapp.models.Letter

class LetterListAdapter(
    private val onLetterClicked: (Letter) -> Unit
) : ListAdapter<Letter, LetterListAdapter.LetterItemViewHolder>(LetterDiffUtilCallback()) {

    inner class LetterItemViewHolder(view: View) : RecyclerView.ViewHolder(view)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LetterItemViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_letter, parent, false)
        return LetterItemViewHolder(view)
    }

    override fun onBindViewHolder(holder: LetterItemViewHolder, position: Int) {
        val tvName = holder.itemView.findViewById<TextView>(R.id.tvName)
        val item = getItem(position)
        tvName.text = item.subject
        holder.itemView.setOnClickListener {
            onLetterClicked.invoke(item)
        }
    }
}