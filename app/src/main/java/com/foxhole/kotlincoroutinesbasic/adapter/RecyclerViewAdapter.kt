package com.foxhole.kotlincoroutinesbasic.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.api.load
import com.foxhole.kotlincoroutinesbasic.R
import com.foxhole.kotlincoroutinesbasic.model.Photo
import kotlinx.android.synthetic.main.layout_item.view.*

/**
 * Created by Musfick Jamil on 4/19/2020$.
 */

class RecyclerViewAdapter(private val photoList: MutableList<Photo>) : RecyclerView.Adapter<RecyclerViewAdapter.ItemViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.layout_item, parent, false)
        return ItemViewHolder(view)
    }

    override fun getItemCount(): Int {
        return photoList.size
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val photo = photoList[position]
        holder.title.text = photo.title
        holder.imageView.load(photo.url)
    }

    class ItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val title = itemView.title
        val imageView = itemView.image_view
    }
}