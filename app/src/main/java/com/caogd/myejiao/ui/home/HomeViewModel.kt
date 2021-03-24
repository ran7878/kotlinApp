package com.caogd.myejiao.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class HomeViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is home Fragment"
    }
    val text: LiveData<String> = _text

    //图片集合
    val imgsLiveData = MutableLiveData<List<String>>()

    fun getImgs(){
        val imgs = mutableListOf<String>()
        imgs.add("http://www.dwrc.com.cn/Web/Resource/Image/2021Banner/enterprise.JPG")
        imgs.add("http://www.dwrc.com.cn/Web/Resource/Image/Home/pic/05.jpg")
        imgs.add("http://www.dwrc.com.cn/Web/Resource/Image/SchoolRecruit/banner_default.png")
        imgs.add("http://www.dwrc.com.cn/Web/Resource/Image/Home/pic/05.jpg")
        imgs.add("http://www.dwrc.com.cn/Web/Resource/Image/2021Banner/enterprise.JPG")
        imgs.add("http://www.dwrc.com.cn/Web/Resource/Image/SchoolRecruit/banner_default.png")
        imgs.add("http://www.dwrc.com.cn/Web/Resource/Image/Home/pic/05.jpg")
        imgs.add("http://www.dwrc.com.cn/Web/Resource/Image/SchoolRecruit/banner_default.png")
        imgs.add("http://www.dwrc.com.cn/Web/Resource/Image/Home/pic/05.jpg")
        imgs.add("http://www.dwrc.com.cn/Web/Resource/Image/2021Banner/enterprise.JPG")

        imgsLiveData.postValue(imgs);
    }
}