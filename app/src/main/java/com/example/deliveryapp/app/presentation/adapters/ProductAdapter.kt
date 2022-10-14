package com.example.deliveryapp.app.presentation.adapters

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.deliveryapp.R
import com.example.deliveryapp.domain.model.Meals
import com.example.deliveryapp.domain.model.ResultModel

class ProductAdapter : RecyclerView.Adapter<ProductAdapter.ProductViewHolder>() {

    private var products = emptyList<Meals>()

    class ProductViewHolder(item: View) : RecyclerView.ViewHolder(item) {
        val name_product: TextView = itemView.findViewById(R.id.tv_name_product)
        val product: ImageView = itemView.findViewById(R.id.iv_product)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder =
        ProductViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.product_item, parent, false))

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int): Unit = holder.itemView.run {

        holder.name_product.text = products[position].strMeal
        Glide.with(this).asBitmap().load(products[position].strMealThumb).into(holder.product)

    }

    override fun getItemCount(): Int {
        return products.size
    }

    @SuppressLint("NotifyDataSetChanged")
    fun setList(list: List<Meals>) {
        products = list
        notifyDataSetChanged()
    }

}