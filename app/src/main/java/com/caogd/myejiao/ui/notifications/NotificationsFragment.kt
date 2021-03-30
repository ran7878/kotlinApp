package com.caogd.myejiao.ui.notifications

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import androidx.appcompat.app.ActionBar
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.caogd.myejiao.R
import com.caogd.myejiao.databinding.FragmentNotificationsBinding
import com.google.android.material.appbar.AppBarLayout

class NotificationsFragment : Fragment() {

    private lateinit var notificationsViewModel: NotificationsViewModel

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        notificationsViewModel =
                ViewModelProvider(this).get(NotificationsViewModel::class.java)

        val binding = FragmentNotificationsBinding.inflate(inflater)

        val mActivity = activity as AppCompatActivity
        mActivity.setSupportActionBar(binding.toolbar)
        val actionBar : ActionBar? = mActivity.supportActionBar
        actionBar?.title = ""

        val totalHeight = resources.getDimension(R.dimen.bar_height)
        val toolBarHeight = resources.getDimension(R.dimen.action_height)
        val photoHeight = resources.getDimension(R.dimen.photo_height_out)
        val offSetHeight = totalHeight - toolBarHeight
        val tmp = (toolBarHeight - photoHeight) / 2
        var rlOffDistance = 0;
        binding.appbar.addOnOffsetChangedListener(AppBarLayout.OnOffsetChangedListener { appBarLayout, verticalOffset ->
            val layoutParam: FrameLayout.LayoutParams = binding.llUser.layoutParams as FrameLayout.LayoutParams
            Log.i("tag", "verticalOffset = $verticalOffset , $tmp")
            //计算margin top值
            if (rlOffDistance == 0){
                rlOffDistance = layoutParam.topMargin
            }

            //得到滑动比值
            val rlOffDistanceScale = rlOffDistance / offSetHeight

            //计算margin top值
            var distance = rlOffDistance - (-verticalOffset) * rlOffDistanceScale
            Log.i("tag", "distance = $distance")
            if (distance <= tmp){
                distance = tmp
            }
            layoutParam.topMargin = distance.toInt()

            binding.llUser.layoutParams = layoutParam
        })

        return binding.root
    }
}