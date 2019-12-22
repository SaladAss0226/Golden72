package com.example.golden72.building

import android.animation.ObjectAnimator
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.view.View
import android.widget.Toast
import com.example.golden72.R
import com.example.golden72.backpack.BackpackActivity
import kotlinx.android.synthetic.main.activity_building02.*
import kotlinx.android.synthetic.main.dialog_next_step.*

class BuildingActivity : AppCompatActivity() {

    var m = 9
    var s = 60
    companion object{
        var key = ""
    }

    val escapeTime = object : CountDownTimer(600000,1000){
        override fun onFinish() {
            layout_you_lost.visibility = View.VISIBLE
            tv_countdown.visibility = View.GONE
            ObjectAnimator.ofFloat(layout_you_lost,"alpha",0f,0.8f,0.8f).apply {
                duration = 2000
                start()
            }
        }
        override fun onTick(millisUntilFinished: Long) {
            if(s>0) {
                s--
                tv_countdown.text = "%02d:%02d".format(m,s)
            }
            else if(s==0){
                if(m>0){
                    s = 59
                    m--
                    tv_countdown.text = "%02d:%02d".format(m,s)
                }
            }
            //倒數音效
        }
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_building02)

        escapeTime.start()

        btn_next.setOnClickListener {
            if(key =="破舊公事包"){
                imgv_maze.visibility = View.VISIBLE
                imgv_bandages.visibility = View.VISIBLE
                imgv_eagal.visibility = View.VISIBLE
            }

            else{
                val dialog = DialogNextStep(this)
                dialog.show()
                dialog.btn_accept.setOnClickListener {
                    tv_content_building.setText(R.string.str_enter_maze)
                    dialog.dismiss()
                }
            }

        }


        btn_backpack.setOnClickListener { startActivity(Intent(this,BackpackActivity::class.java)) }

        imgv_eagal.setOnClickListener { tv_content_building.text = "一把上膛的沙漠之鷹(7發)，以及兩個彈夾。" }
        imgv_bandages.setOnClickListener { tv_content_building.text = "三綑紗布及一小瓶酒精，急救時可以派上用場。" }
        imgv_maze.setOnClickListener { tv_content_building.text = "迷宮平面圖。" }
    }
}
