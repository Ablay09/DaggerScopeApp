package com.example.daggerscopeapp.letters.adapter

import androidx.recyclerview.widget.DiffUtil
import com.example.daggerscopeapp.models.Letter

class LetterDiffUtilCallback : DiffUtil.ItemCallback<Letter>() {
    override fun areItemsTheSame(oldItem: Letter, newItem: Letter): Boolean {
        return oldItem.subject == newItem.subject
    }

    override fun areContentsTheSame(oldItem: Letter, newItem: Letter): Boolean {
        return oldItem == newItem
    }
}