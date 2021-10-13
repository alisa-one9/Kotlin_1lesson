package com.example.kotlin_1lesson.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlin_1lesson.databinding.ListItemBinding

class Adapter : RecyclerView.Adapter<Adapter.ViewHolder>() {

    private var list = ArrayList<String>()

    fun setList(list: ArrayList<String>) {
        this.list = list
        notifyDataSetChanged()

    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        return  ViewHolder(ListItemBinding.inflate(LayoutInflater.from(parent.context),parent,false))

    }

    override fun getItemCount(): Int {
        return  list.size

    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(list.get(position))


            }



    class ViewHolder(private val binding: ListItemBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(get: String) {
            binding.itemTextView.text =get

        }


    }

}