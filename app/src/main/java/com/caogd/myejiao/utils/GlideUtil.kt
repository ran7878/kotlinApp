package com.caogd.myejiao.utils

import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions

object GlideUtil {
    /**
     * 加载图片
     */
    fun loadImg(imgView:ImageView,url:String){
        Glide.with(imgView.context).load(url)
            .transition(DrawableTransitionOptions.withCrossFade())
            .into(imgView)
    }
}