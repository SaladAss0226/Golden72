package com.example.golden72.backpack

import android.animation.ObjectAnimator
import android.animation.ValueAnimator
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.golden72.R
import kotlinx.android.synthetic.main.item_example.view.*

class BackpackAdapter: RecyclerView.Adapter<BackpackAdapter.mViewHolder>() {

    companion object{
        var unAssignList = arrayListOf<MyPackage>()
        private var clickListener : ItemClickListener? = null
        fun setToClick(listener: ItemClickListener){
            clickListener = listener
        }
    }

    interface ItemClickListener{
        fun toClick(item: MyPackage)
    }


    inner class mViewHolder(itemView:View):
        RecyclerView.ViewHolder(itemView){
        val itemPhoto = itemView.imgv_item_photo
        val itemName = itemView.tv_item_name
        val itemDescribe = itemView.tv_item_describe
        val tvUse = itemView.tv_use_item
        val availableUseTime = itemView.tv_available_use_time
        val itemLayout = itemView.item_layout
        val doneLayout = itemView.item_layout_done
        fun bind(item: MyPackage){
            itemName.text = item.itemName
            itemDescribe.text = item.describe
            if(item.type==1) availableUseTime.text = "可用次數:${item.availableUseTime}"
            else availableUseTime.text = "無使用限制"

            itemLayout.setOnClickListener{
                clickListener?.toClick(item)
            }

            Glide.with(itemView)
                .load(item.img)
                .into(itemPhoto)

            ObjectAnimator.ofFloat(tvUse,"alpha",0f,1f,0f).apply {
                duration = 2000
                repeatCount = ValueAnimator.INFINITE
                repeatMode = ValueAnimator.RESTART
                start()
            }
            if(item.done) {
                doneLayout.visibility = View.VISIBLE
                tvUse.visibility = View.GONE
            }
            else {
                doneLayout.visibility = View.GONE
                tvUse.visibility = View.VISIBLE
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): mViewHolder {
                val inflater = LayoutInflater.from(parent.context)
                val example = inflater.inflate(R.layout.item_example, parent, false)
                return  mViewHolder(example)
    }

    override fun getItemCount() = unAssignList.size

    override fun onBindViewHolder(holder: mViewHolder, position: Int) {
        holder.bind(unAssignList[position])

    }
}