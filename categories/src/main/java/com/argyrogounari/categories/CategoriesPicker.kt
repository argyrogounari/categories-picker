package com.argyrogounari.categories

import android.content.Context
import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.argyrogounari.categories.models.Category

class CategoriesPicker : Fragment() {
    var categories = ArrayList<Category>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val args = arguments
        if (args != null) {
            categories = args.getParcelableArrayList<Category>("categoriesList") as ArrayList<Category>
            println("categories: $categories")
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        parent: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var recyclerview = inflater.inflate(R.layout.recyclerview, parent, false)
        recyclerview.setBackgroundColor(Color.RED)
        return recyclerview
    }

    fun s(c: Context?, message: String?) {
        Toast.makeText(c, message, Toast.LENGTH_SHORT).show()
    }
}