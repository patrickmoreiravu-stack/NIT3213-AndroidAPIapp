package com.example.androidapiapp.recyclerview

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.example.androidapiapp.R
import com.example.androidapiapp.data.Entity

class EntityAdapter(private val onClick: (Entity) -> Unit) :
    ListAdapter<Entity, EntityViewHolder>(DiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EntityViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_entity, parent, false)
        return EntityViewHolder(view, onClick)
    }

    override fun onBindViewHolder(holder: EntityViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    class DiffCallback : DiffUtil.ItemCallback<Entity>() {
        override fun areItemsTheSame(oldItem: Entity, newItem: Entity): Boolean {
            return oldItem.title == newItem.title
        }

        override fun areContentsTheSame(oldItem: Entity, newItem: Entity): Boolean {
            return oldItem == newItem
        }
    }
}