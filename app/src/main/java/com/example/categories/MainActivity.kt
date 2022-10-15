package com.example.categories

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.add
import androidx.fragment.app.commit
import com.argyrogounari.categories.CategoriesPicker
import com.argyrogounari.categories.models.Category
import java.io.IOException

class MainActivity : AppCompatActivity() {
    var dbHeplper: DatabaseHelper? = null
    var categoriesList = ArrayList<Category>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)

        dbHeplper = DatabaseHelper(applicationContext)
        try {
            dbHeplper!!.createDataBase()
            categoriesList = dbHeplper!!.getActivities()
        } catch (e: IOException) {
            e.printStackTrace()
        }

        if (savedInstanceState == null) {
            val bundle = Bundle()
            bundle.putParcelableArrayList("categoriesList", categoriesList)
            supportFragmentManager.commit {
                setReorderingAllowed(true)
                add<CategoriesPicker>(R.id.fragment_container_view, "CategoriesPickerFragment", args = bundle)
            }
        }
    }
}