package com.mattdog.coderswag.Adapters

import android.content.Context
import android.media.Image
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.mattdog.coderswag.Model.Category
import com.mattdog.coderswag.R
import kotlinx.android.synthetic.main.category_list_item.view.*

class CategoryRecyclerAdapter(val context: Context, val categories: List<Category>) : RecyclerView.Adapter<CategoryRecyclerAdapter.Holder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val view = LayoutInflater.from(context).inflate(R.layout.category_list_item, parent, false)
        //for the'inflate', choose the one with Attach to Root
        return Holder(view)
    }

    override fun getItemCount(): Int {
        return categories.count()
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        //displays the data at the specified location
        holder?.bindCategory(categories[position], context)
    }

    inner class Holder(itemView: View) : RecyclerView.ViewHolder(itemView){
        //holder sets the UI elements (itemView) to variables
        val categoryImage = itemView?.findViewById<ImageView>(R.id.categoryImage)
        val categoryName = itemView?.findViewById<TextView>(R.id.categoryName)

        fun bindCategory(category: Category, context: Context) {
            val resourceId = context.resources.getIdentifier(category.image,
                "drawable", context.packageName)
            categoryImage?.setImageResource(resourceId)
            categoryName?.text = category.title
        }

    }
}