package com.mattdog.coderswag.Adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.mattdog.coderswag.Model.Product
import com.mattdog.coderswag.R

class ProductsAdapter(val context: Context, val products: List<Product>) : RecyclerView.Adapter<ProductsAdapter.ProductHolder>() {
    //Extend RecyclerView.Adapter
    //create view holder class (inner class ProductHolder(itemView: View) : RecyclerView.ViewHolder(itemView))
    //Right-click 'RecyclerView.ViewHolder' in the inner class and select 'add constructor parameters'
    //Insert the ProductHolder into '< >' after 'RecyclerView.Adapter'
    //Alt+enter the adapter class and select 'implement members'. Select all entries.
    //Add '( )' at the end of 'RecyclerView.ViewHolder...' to initialize it
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductHolder {
        //creates the view of the data entry if it is being rendered for the first time
        val view = LayoutInflater.from(context).inflate(R.layout.product_list_item, parent, false)

        return ProductHolder(view)
    }

    override fun getItemCount(): Int {
        return products.count()
    }

    override fun onBindViewHolder(holder: ProductHolder, position: Int) {
        //Links the holder to the array containing the data in DataServices so that data can be extracted
        holder.bindProduct(products[position], context)
    }

    inner class ProductHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        //Finds the UI element in the xml blueprint for the recyclerview and assigns it to variables
        val productImage = itemView?.findViewById<ImageView>(R.id.productImage)
        val productName = itemView?.findViewById<TextView>(R.id.productName)
        val productPrice = itemView?.findViewById<TextView>(R.id.productPrice)

        fun bindProduct(product: Product, context: Context){
            //Finds the specific layout files for each data entry using resource IDs and links/binds it to variables

            val resourceId = context.resources.getIdentifier(product.image, "drawable", context.packageName)

            productImage?.setImageResource(resourceId)
            productName?.text = product.title
            productPrice?.text = product.price
            //Sets the content of the UI elements (productImage, productName, productPrice)
            // to the variables of the specific data entries (product.title, product.price, image resource)

        }
    }
}