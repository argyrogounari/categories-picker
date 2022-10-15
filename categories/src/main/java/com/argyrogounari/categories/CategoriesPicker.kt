package com.argyrogounari.categories

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.argyrogounari.categories.models.Category
import kotlinx.android.synthetic.main.recyclerview_layout.*

class CategoriesPicker : Fragment() {
    var categories = ArrayList<Category>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val args = arguments
        if (args != null) {
            categories = args.getParcelableArrayList<Category>("categoriesList") as ArrayList<Category>
        }
    }

    override fun onCreateView(inflater: LayoutInflater, parent: ViewGroup?, savedInstanceState: Bundle?): View {
        return inflater.inflate(R.layout.recyclerview_layout, parent, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val layoutManager = LinearLayoutManager(context)
        categoriesListRecyclerView.layoutManager = layoutManager
        categoriesListRecyclerView.adapter = CategoriesListAdapter(categories)
    }
}