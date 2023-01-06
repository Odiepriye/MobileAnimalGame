package com.odiepriye.mymobilegame

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.odiepriye.mymobilegame.databinding.LevelViewBinding

class ListAdapter(val level:ArrayList<Levels>) :
    RecyclerView.Adapter<ListAdapter.ViewHolder>() {
    inner class ViewHolder(var itemBinding : LevelViewBinding):
            RecyclerView.ViewHolder(itemBinding.root){
            }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListAdapter.ViewHolder {
        val itemBinding = LevelViewBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ViewHolder(itemBinding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val levels = level[position]
        holder.itemBinding.textView.text=levels.name
        holder.itemBinding.ratingBar.rating=levels.rating
    }

    override fun getItemCount(): Int {
        return level.size
    }
}