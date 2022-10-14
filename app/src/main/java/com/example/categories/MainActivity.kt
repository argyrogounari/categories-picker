package com.example.categories

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.argyrogounari.categories.CategoriesPicker
import com.argyrogounari.categories.models.Category
import java.io.IOException

class MainActivity : AppCompatActivity() {
    var dbHeplper: DatabaseHelper? = null
    var categoriesList = ArrayList<Category>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        dbHeplper = DatabaseHelper(applicationContext)
        try {
            dbHeplper!!.createDataBase()
            categoriesList = dbHeplper!!.getActivities()
        } catch (e: IOException) {
            e.printStackTrace()
        }

        val categoriesPicker = CategoriesPicker.newInstance(categoriesList)
        categoriesPicker.s(this.applicationContext, "Heya!!!!!!")
    }
}