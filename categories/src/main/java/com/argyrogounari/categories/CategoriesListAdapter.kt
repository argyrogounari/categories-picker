package com.argyrogounari.categories

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.argyrogounari.categories.models.Category
import kotlinx.android.synthetic.main.text_row_item.view.*

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
            chip.text = categoriesList[position].name
        }
    }

    override fun getItemCount() = categoriesList.size

}