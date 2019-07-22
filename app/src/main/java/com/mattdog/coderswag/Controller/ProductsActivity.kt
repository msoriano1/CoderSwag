package com.mattdog.coderswag.Controller

import android.content.res.Configuration
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import com.mattdog.coderswag.Adapters.ProductsAdapter
import com.mattdog.coderswag.R
import com.mattdog.coderswag.Services.DataService
import com.mattdog.coderswag.Utilities.EXTRA_CATEGORY
import kotlinx.android.synthetic.main.activity_products.*

class ProductsActivity : AppCompatActivity() {

    lateinit var adapter : ProductsAdapter
    //sets the 'ProductsAdapter' created as the adapter to be used for this activity

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_products)

        val categoryType = intent.getStringExtra(EXTRA_CATEGORY)

        adapter = ProductsAdapter(this, DataService.getProducts(categoryType))
        //Initializes the 'ProductsAdapter' created in the 'Adapter' folder by passing on the necessary parameters
        //'DataService.getProducts' uses the function created in DataService to return the appropriate data set as a parameter for the adapter

        var spanCount = 2
        val orientation = resources.configuration.orientation
        //returns integer value: 1 is for portrait, 2 is for landscape

        if (orientation == Configuration.ORIENTATION_LANDSCAPE){
            spanCount = 3
        }

        val screenSize = resources.configuration.screenWidthDp
        //returns dp value of screen size

        if (screenSize > 720){
            spanCount = 3
        }



        val layoutManager = GridLayoutManager(this, spanCount)
        //spanCount is the number of columns to be used in the grid
        productsListView.layoutManager = layoutManager
        //setting the layout manager of the list view in the xml file
        productsListView.adapter = adapter
        // setting the adapter of the list view in the xml file to the adapter created

    }
}
