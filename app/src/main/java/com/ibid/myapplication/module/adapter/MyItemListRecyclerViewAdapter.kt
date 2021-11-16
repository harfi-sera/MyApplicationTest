package com.ibid.myapplication.module.adapter

import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import com.ibid.myapplication.databinding.FragmentItemBinding
import com.ibid.myapplication.module.service.Data

/**
 * [RecyclerView.Adapter] that can display a [ItemList].
 * TODO: Replace the implementation with code for your data type.
 */
class MyItemListRecyclerViewAdapter(
    private val values: List<Data>
) : RecyclerView.Adapter<MyItemListRecyclerViewAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        return ViewHolder(
            FragmentItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )

    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = values[position]
        holder.idView.text = item.email
        holder.contentView.text = item.first_name + " " + item.last_name
    }

    override fun getItemCount(): Int = values.size

    inner class ViewHolder(binding: FragmentItemBinding) : RecyclerView.ViewHolder(binding.root) {
        val idView: TextView = binding.itemNumber
        val contentView: TextView = binding.content

        override fun toString(): String {
            return super.toString() + " '" + contentView.text + "'"
        }
    }

}