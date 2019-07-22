package com.mattdog.coderswag.Controller

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.mattdog.coderswag.Adapters.CategoryAdapter
import com.mattdog.coderswag.Adapters.CategoryRecyclerAdapter
import com.mattdog.coderswag.Model.Category
import com.mattdog.coderswag.R
import com.mattdog.coderswag.Services.DataService
import com.mattdog.coderswag.Utilities.EXTRA_CATEGORY
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    //lateinit var adapter : ArrayAdapter<Category>
    //Adapter works as a controller for a list to convert and format into something compatible with the ListView in the layout

    lateinit var adapter : CategoryRecyclerAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

       // adapter = ArrayAdapter(this,
        //    android.R.layout.simple_list_item_1,
        //    DataService.categories)
        //Adapters accept 3 parameters: context, the type of layout/format to be converted to, and the data source)

        adapter = CategoryRecyclerAdapter(this, DataService.categories) {category ->
            val productIntent = Intent(this, ProductsActivity::class.java)
            productIntent.putExtra(EXTRA_CATEGORY, category.title)
            startActivity(productIntent)
            println(category.title)
        }

        categoryListView.adapter = adapter
        //set the adapter of the listView to the adapter created

        val layoutManager = LinearLayoutManager(this)
        categoryListView.layoutManager = layoutManager
        categoryListView.setHasFixedSize(true)

        //Layout Manager: positions item views inside the RecyclerView and determines when to reuse items that are no longer
        //visible to the user . Layout manager interfaces with the Recycler Adapter to replace contents with a different element
        //from the data set
    }
}
