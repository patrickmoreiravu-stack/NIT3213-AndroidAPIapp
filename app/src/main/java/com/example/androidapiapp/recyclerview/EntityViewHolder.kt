package com.example.androidapiapp.recyclerview

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.androidapiapp.R
import com.example.androidapiapp.data.Entity

class EntityViewHolder(itemView: View, val onClick: (Entity) -> Unit) :
    RecyclerView.ViewHolder(itemView) {
    private val title: TextView = itemView.findViewById(R.id.entityTitle)
    private val subtitle: TextView = itemView.findViewById(R.id.entitySubtitle)
    private var currentEntity: Entity? = null

    init {
        itemView.setOnClickListener {
            currentEntity?.let { onClick(it) }
        }
    }

    fun bind(entity: Entity) {
        currentEntity = entity
        title.text = entity.title ?: "No title"
        subtitle.text = entity.author ?: "Unknown author"
    }
}