package com.example.deliveryapp.app.presentation.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.deliveryapp.R
import com.example.deliveryapp.databinding.CategoryItemBinding
import com.example.deliveryapp.domain.model.CategoryModel

class CategoryAdapter(val listener: Listener) : RecyclerView.Adapter<CategoryAdapter.CategoryViewHolder>() {

    var categoryList = mutableListOf(
        CategoryModel("Пицца", true),
        CategoryModel("Комбо"),
        CategoryModel("Десерты"),
        CategoryModel("Напитки")
    )

    class CategoryViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val binding = CategoryItemBinding.bind(itemView)

        fun bind(category: CategoryModel, listener: Listener) {
            binding.tvCategoryName.text = category.categoryName
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryViewHolder {

        val view = LayoutInflater.from(parent.context).inflate(R.layout.category_item, parent, false)
        return CategoryViewHolder(view)

    }

    override fun onBindViewHolder(holder: CategoryViewHolder, position: Int) {
        holder.bind(categoryList[position], listener)

        val category = categoryList[position]

        if (category.isSelected) listener.onClickCategory(holder.itemView)
        else listener.unClickCategory(holder.itemView)

        holder.itemView.setOnClickListener {
            for (i in 0 until categoryList.size) {
                categoryList[i].isSelected = false
            }
            category.isSelected = true
            notifyDataSetChanged()
        }

    }

    override fun getItemCount(): Int {
        return categoryList.size
    }

    interface Listener {
        fun onClickCategory(category: View)
        fun unClickCategory(category: View)
    }

}