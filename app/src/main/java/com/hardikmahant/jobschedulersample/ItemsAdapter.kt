package com.hardikmahant.jobschedulersample

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_sample.view.*

class ItemsAdapter(
    private val items: List<String>
) : RecyclerView.Adapter<ItemsAdapter.ItemsViewHolder>() {

    inner class ItemsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemsViewHolder {
        return ItemsViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(
                    R.layout.item_sample,
                    parent,
                    false
                )
        )
    }

    override fun onBindViewHolder(holder: ItemsViewHolder, position: Int) {
        holder.itemView.tvTitle.text = items[position]
        holder.itemView.setOnClickListener {
            onItemClickListener?.let {
                it(items[position], position)
            }
        }
    }

    override fun getItemCount(): Int {
        return items.size
    }

    private var onItemClickListener: ((String, Int) -> Unit)? = null

    fun setOnItemClickListener(listener: ((String, Int) -> Unit)?){
        this.onItemClickListener = listener
    }
}