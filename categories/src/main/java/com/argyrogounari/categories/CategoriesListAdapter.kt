package com.argyrogounari.categories

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.argyrogounari.categories.databinding.TextRowItemBinding
import com.argyrogounari.categories.models.Category

class CategoriesListAdapter(private val categoriesList: ArrayList<Category>) :
    RecyclerView.Adapter<CategoriesListAdapter.CategoriesViewHolder>() {
    
    inner class CategoriesViewHolder(view: View) : RecyclerView.ViewHolder(view)

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): CategoriesViewHolder {
        val view = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.text_row_item, viewGroup, false)

        return CategoriesViewHolder(view)
    }

    override fun onBindViewHolder(viewHolder: CategoriesViewHolder, position: Int) {
        viewHolder.itemView.apply {
            val emoji = categoriesList[position].emoji
            val name = categoriesList[position].name
            val displayText = "$emoji $name"
            val color = categoriesList[position].color
            val co = Color.valueOf(Color.parseColor("#$color"))

            findViewById<TextView>(R.id.chip).apply {
                text = displayText
            }
        }
    }

    override fun getItemCount() = categoriesList.size

}