package com.caogd.myejiao.ui.notifications

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.ActionBar
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.caogd.myejiao.databinding.FragmentNotificationsBinding

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
        actionBar?.title = "Notification!"
        return binding.root
    }
}