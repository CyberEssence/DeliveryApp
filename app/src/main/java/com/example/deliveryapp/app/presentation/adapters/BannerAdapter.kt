package com.example.deliveryapp.app.presentation.adapters

import android.annotation.SuppressLint
import android.media.Image
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.deliveryapp.R
import com.example.deliveryapp.R.*
import com.example.deliveryapp.domain.model.BannerModel

class BannerAdapter : RecyclerView.Adapter<BannerViewHolder>() {

    private var bannerList = mutableListOf(
        BannerModel(30, "С понедельника по четверг с 10 до 16", R.drawable.pizza1),
        BannerModel(40, "Студентам в будние дни", R.drawable.pizza2)
    )

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BannerViewHolder =
        BannerViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.banner_item, parent, false))

    override fun getItemCount(): Int = bannerList.size

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: BannerViewHolder, position: Int): Unit = holder.itemView.run {
        holder.amount.text = bannerList[position].discount.toString() + " %"
        holder.desc_time.text = bannerList[position].discount_time
        holder.banner.setImageResource(bannerList[position].image)
    }
}

class BannerViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    val amount: TextView = itemView.findViewById(R.id.tv_amount_of_discount)
    val desc_time: TextView = itemView.findViewById(R.id.tv_discount_time)
    val banner: ImageView = itemView.findViewById(R.id.iv_banner)
}