package com.example.testmvvm

import android.content.Context
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.test_item.view.*
import android.view.LayoutInflater


class TestRVAdapter(val list: ArrayList<CustomObject>, val context: Context) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private val inflater = LayoutInflater.from(context)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder =
        CustomViewHolder(inflater.inflate(R.layout.test_item, parent, false))

    override fun getItemCount() = list.size

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as CustomViewHolder).bind(list[position])
    }

    fun updateList(list:List<CustomObject>){
        this.list.clear()
        this.list.addAll(list)
        notifyDataSetChanged()
    }

    private inner class CustomViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        fun bind(item: CustomObject) {
            itemView.text.text = item.text
        }
    }
}