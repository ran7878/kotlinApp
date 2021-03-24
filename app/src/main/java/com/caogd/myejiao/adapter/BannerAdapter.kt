package com.caogd.myejiao.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.caogd.myejiao.bean.BannerBean
import com.caogd.myejiao.databinding.BannerItemBinding
import com.caogd.myejiao.utils.GlideUtil

class BannerAdapter(var banners:List<BannerBean>) : RecyclerView.Adapter<BannerAdapter.BannerViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BannerViewHolder {
        val binding = BannerItemBinding.inflate(LayoutInflater.from(parent.context),parent,false);
        return BannerViewHolder(binding)
    }

    override fun onBindViewHolder(holder: BannerViewHolder, position: Int) {
        val bannerBean :BannerBean = banners[position]
        holder.bind(bannerBean)
    }

    override fun getItemCount(): Int {
        return banners.size
    }


    class BannerViewHolder(private val binding: BannerItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(banner:BannerBean){
            GlideUtil.loadImg(binding.ivBanner,banner.url)
        }
    }

}