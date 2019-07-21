package com.mattdog.coderswag.Adapters

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import com.mattdog.coderswag.Model.Category
import com.mattdog.coderswag.R

class CategoryAdapter(context:Context, categories: List<Category>) :BaseAdapter() {
    //Adapter is used so that the layout file can be automatically modified based on given values, and not manually
    //Base Adapter is the class that other adapters inherit from
    //After inheriting from BaseAdapter, alt+enter on the class name to 'implement members'
    //parameters include context and the class instances to be used in the list

    val context = context
    val categories = categories

    @SuppressLint("ViewHolder")
    override fun getView(position: Int, convert: View?, parent: ViewGroup?): View {
        val categoryView: View
        val holder: ViewHolder

        if (convert == null){
            //if its the first time views are being presented, find by ID and set the view holder's attributes
            categoryView = LayoutInflater.from(context).inflate(R.layout.category_list_item, null)
            //LayoutInflater is an object that takes an XML layout (such as category_list) and turns into a reusable element that can be used in code
            //val categoryImage : ImageView = categoryView.findViewById(R.id.categoryImage)
            holder = ViewHolder()
            holder.categoryImage = categoryView.findViewById(R.id.categoryImage)
            holder.categoryName = categoryView.findViewById(R.id.categoryName)
            //References the UI elements created in the category_list layout file and puts them into variables
            println("I exist for the first time!")
            categoryView.tag = holder
        } else {
            //if the view has already been rendered and should still be visible in the panel after scrolling,
            holder = convert.tag as ViewHolder
            categoryView = convert
            println("recycled view!")
        }



        val category = categories[position]

        //val resourceId = context.resources.getIdentifier(category.image, "drawable", context.packageName)
        val resourceId = context.resources.getIdentifier(category.image, "drawable", context.packageName)
        //code to retrieve the ID of the image
        holder.categoryImage?.setImageResource(resourceId)
        holder.categoryName?.text = category.title

        return categoryView
    }

    override fun getItem(position: Int): Any {
        return categories[position]
    }
    //method to call to retrieve the item associated with the position of the listView

    override fun getItemId(position: Int): Long {
        return 0
    }
    //defines a unique ID per row of the list

    override fun getCount(): Int {
        return categories.count()
    }

    private class ViewHolder {
        var categoryImage: ImageView? = null
        var categoryName: TextView? = null
    }
}