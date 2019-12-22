package com.example.golden72

import android.animation.ObjectAnimator
import android.animation.ValueAnimator
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.golden72.desert.DesertActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var animator = ObjectAnimator.ofFloat(tv_get_start,"alpha",0f,1f,0f)
        animator.apply {
            duration = 2000
            repeatCount = ValueAnimator.INFINITE
            repeatMode = ValueAnimator.RESTART
            //interpolator= LinearInterpolator()
            start()
        }

        tv_get_start.setOnClickListener {
            startActivity(Intent(this,
                DesertActivity::class.java))

        }
    }
}
