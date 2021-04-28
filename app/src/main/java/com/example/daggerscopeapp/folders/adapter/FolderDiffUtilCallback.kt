package com.example.daggerscopeapp.folders.adapter

import androidx.recyclerview.widget.DiffUtil
import com.example.daggerscopeapp.models.Folder

class FolderDiffUtilCallback : DiffUtil.ItemCallback<Folder>() {

    override fun areItemsTheSame(oldItem: Folder, newItem: Folder): Boolean {
        return oldItem.name == newItem.name
    }

    override fun areContentsTheSame(oldItem: Folder, newItem: Folder): Boolean {
        return oldItem == newItem
    }

}