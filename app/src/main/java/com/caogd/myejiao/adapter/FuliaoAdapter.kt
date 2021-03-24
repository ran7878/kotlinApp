package com.caogd.myejiao.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.caogd.myejiao.databinding.FuliaoItemBinding
import com.caogd.myejiao.utils.GlideUtil

/**
 * 辅料展示的adapter
 */
class FuliaoAdapter(private var imgs:List<String>): RecyclerView.Adapter<FuliaoAdapter.ViewHolder>() {

    inner class ViewHolder(private val binding: FuliaoItemBinding) :RecyclerView.ViewHolder(binding.root){

        fun bind(position: Int){
            GlideUtil.loadImg(binding.ivFuliao,imgs[position])
            binding.ivFuliao.setOnClickListener {
                Toast.makeText(binding.ivFuliao.context, "pos = $position", Toast.LENGTH_SHORT).show()
            }
        }
    }

    fun notify(list:List<String>){
        imgs = list;
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = FuliaoItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)

        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(position)
    }

    override fun getItemCount(): Int {
       return imgs.size
    }
}