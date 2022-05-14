package com.x18392911.final.advocate.freerecommendations

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.adamc.advocate.R

class FamilyAdapter(private val items: Array<String>, val context: Context): RecyclerView.Adapter<ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.row, parent, false)
        return  ViewHolder(v)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindTextValue!!.text = items[position]
    }

    override fun getItemCount(): Int {
        return items.size
    }

}

class ViewHolder1(itemView: View): RecyclerView.ViewHolder(itemView) {
    val bindTextValue: TextView? = itemView.findViewById(R.id.titleTextView)
}