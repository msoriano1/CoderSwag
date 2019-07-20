package com.mattdog.coderswag.Controller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import com.mattdog.coderswag.Model.Category
import com.mattdog.coderswag.R
import com.mattdog.coderswag.Services.DataService
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    lateinit var adapter : ArrayAdapter<Category>
    //Adapter works as a controller for a list to convert and format into something compatible with the ListView in the layout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        adapter = ArrayAdapter(this,
            android.R.layout.simple_list_item_1,
            DataService.categories)
        //Adapters accept 3 parameters: context, the type of layout/format to be converted to, and the data source)

        categoryListView.adapter = adapter
        //set the adapter of the listView to the adapter created
    }
}
