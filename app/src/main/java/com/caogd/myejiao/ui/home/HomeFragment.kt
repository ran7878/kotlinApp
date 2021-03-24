package com.caogd.myejiao.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.viewpager2.widget.ViewPager2
import androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
import com.caogd.myejiao.adapter.BannerAdapter
import com.caogd.myejiao.adapter.FuliaoAdapter
import com.caogd.myejiao.bean.BannerBean
import com.caogd.myejiao.databinding.FragmentHomeBinding
import kotlin.math.abs

class HomeFragment : Fragment() {

    private lateinit var homeViewModel: HomeViewModel
    private lateinit var fuliaoAdapter: FuliaoAdapter
    private var imgs:List<String> = mutableListOf()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        homeViewModel = ViewModelProvider(this).get(HomeViewModel::class.java)

        //val fragmentHomeBinding = DataBindingUtil.inflate<FragmentHomeBinding>(inflater,R.layout.fragment_home, container,false);
        val fragmentHomeBinding = FragmentHomeBinding.inflate(inflater,container,false);

        /*val textView: TextView = root.findViewById(R.id.text_home)
        homeViewModel.text.observe(viewLifecycleOwner, Observer {
            textView.text = it
        })*/

        fragmentHomeBinding.rvFuliao.layoutManager=GridLayoutManager(context,3)
        fuliaoAdapter = FuliaoAdapter(imgs)
        fragmentHomeBinding.rvFuliao.adapter = fuliaoAdapter

        homeViewModel.imgsLiveData.observe(viewLifecycleOwner, Observer {data->
            imgs = data;
            fuliaoAdapter.notify(imgs)
            //fuliaoAdapter.notifyDataSetChanged()
        })

        homeViewModel.getImgs()

        val bannerList = mutableListOf<BannerBean>()
        bannerList.add(
            BannerBean(
                "http://cms-bucket.ws.126.net/2021/0323/a04eaba6p00qqf5xw0074c000s600e3c.png",
                1
            )
        )
        bannerList.add(
            BannerBean(
                "http://cms-bucket.ws.126.net/2021/0322/77a2c53ej00qqd925001ec000cl0069c.jpg",
                1
            )
        )
        bannerList.add(
            BannerBean(
                "http://cms-bucket.ws.126.net/2021/0323/c6dd6725j00qqev3n00akc000cl0069c.jpg",
                1
            )
        )

        val adapter = BannerAdapter(bannerList)
        val vpBase = fragmentHomeBinding.vp2Banner
        vpBase.adapter = adapter

        //禁止滚动true为可以滑动false为禁止
        //禁止滚动true为可以滑动false为禁止
        vpBase.setUserInputEnabled(true)
        //设置垂直滚动ORIENTATION_VERTICAL，横向的为
        //设置垂直滚动ORIENTATION_VERTICAL，横向的为
        vpBase.setOrientation(ViewPager2.ORIENTATION_HORIZONTAL)
        //切换到指定页，是否展示过渡中间页
        //切换到指定页，是否展示过渡中间页
        vpBase.setCurrentItem(1, true)
        //设置一个缩放动画
        //设置一个缩放动画
        vpBase.setPageTransformer(mAnimator)
        //滑动监听
        //滑动监听
        vpBase.registerOnPageChangeCallback(object : OnPageChangeCallback() {
            override fun onPageScrolled(
                position: Int,
                positionOffset: Float,
                positionOffsetPixels: Int
            ) {
                super.onPageScrolled(position, positionOffset, positionOffsetPixels)
            }

            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
            }

            override fun onPageScrollStateChanged(state: Int) {
                super.onPageScrollStateChanged(state)
            }
        })

        return fragmentHomeBinding.root;
    }

    private val mAnimator = ViewPager2.PageTransformer { page, position ->
        val absPos = abs(position);
        val scaleX: Float;
        val scaleY: Float;
        if (absPos > 1){
            scaleX=   0F;
            scaleY=   0F;

        }else{
            scaleX= 1 - absPos ;
            scaleY= 1 - absPos ;
        }
        page.scaleX = scaleX;
        page.scaleY = scaleY;
    }
}