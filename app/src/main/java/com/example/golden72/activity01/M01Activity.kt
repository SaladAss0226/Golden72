package com.example.golden72.activity01

import android.animation.ObjectAnimator
import android.animation.ValueAnimator
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.example.golden72.R
import kotlinx.android.synthetic.main.activity_m01.*

class M01Activity : AppCompatActivity() {

    val fragment01 = Fragment01()
    val fragment02 = Fragment02()
    val fragment03 = Fragment03()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_m01)

        val adpt = VPA(supportFragmentManager, 3)
        vp_activity01.adapter = adpt

    }

    //宣告一個類別VPA 繼承FragmentPagerAdapter
    inner class VPA(f: FragmentManager, bh:Int) : FragmentPagerAdapter(f,bh){
        override fun getItem(position: Int): Fragment {
            return when(position){
                0 -> fragment01
                1 -> fragment02
                else -> fragment03
            }
        }
        override fun getCount(): Int = 3 //直接回傳fragment頁數

    }
}
