package com.argyrogounari.categories

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.argyrogounari.categories.models.Category
import com.argyrogounari.categories.databinding.RecyclerviewLayoutBinding

class CategoriesPicker : Fragment() {
    var categories = ArrayList<Category>()
    private var _binding: RecyclerviewLayoutBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val args = arguments
        if (args != null) {
            categories = args.getParcelableArrayList<Category>("categoriesList") as ArrayList<Category>
        }
    }

    override fun onCreateView(inflater: LayoutInflater, parent: ViewGroup?, savedInstanceState: Bundle?): View {
        _binding = RecyclerviewLayoutBinding.inflate(inflater, parent, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val layoutManager = LinearLayoutManager(context)
        binding.categoriesListRecyclerView.layoutManager = layoutManager
        binding.categoriesListRecyclerView.adapter = CategoriesListAdapter(categories)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}