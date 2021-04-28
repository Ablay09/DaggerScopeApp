package com.example.daggerscopeapp.folders.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.daggerscopeapp.R
import com.example.daggerscopeapp.models.Folder

class FolderListAdapter(
    private val onFolderClicked: (Folder) -> Unit
) : ListAdapter<Folder, FolderListAdapter.FolderItemViewHolder>(FolderDiffUtilCallback()) {

    inner class FolderItemViewHolder(view: View): RecyclerView.ViewHolder(view)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FolderItemViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_folder, parent, false)
        return FolderItemViewHolder(view)
    }

    override fun onBindViewHolder(holder: FolderItemViewHolder, position: Int) {
        val name = holder.itemView.findViewById<TextView>(R.id.tvName)
        name.text = getItem(position).name
        holder.itemView.setOnClickListener {
            onFolderClicked.invoke(getItem(position))
        }
    }
}