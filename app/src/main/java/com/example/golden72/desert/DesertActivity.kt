package com.example.golden72.desert

import android.animation.ObjectAnimator
import android.content.Intent
import android.media.MediaPlayer
import android.media.SoundPool
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.view.View
import com.example.golden72.building.BuildingActivity
import com.example.golden72.R
import com.example.golden72.backpack.BackpackActivity
import com.example.golden72.backpack.MyPackage
import com.example.golden72.publicFunction.putIn
import kotlinx.android.synthetic.main.activity_desert.*
import kotlinx.android.synthetic.main.dialog_take_it.*

class DesertActivity : AppCompatActivity() {

    lateinit var bgm_nervous: MediaPlayer
    var countDown = 30
    var movement = 0
    companion object{
        var warning_alarm = 0
        var sp = SoundPool.Builder().setMaxStreams(8).build()
    }

    override fun onResume() {
        super.onResume()
        if(movement>=4) bgm_nervous.start()

    }


    val zombiesComing = object : CountDownTimer(30000,1000){
        override fun onFinish() {
            layout_you_lost.visibility = View.VISIBLE
            ObjectAnimator.ofFloat(layout_you_lost,"alpha",0f,0.8f,0.8f).apply {
                duration = 2000
                start()
            }
        }
        override fun onTick(millisUntilFinished: Long) {
            countDown -= 1
            tv_countdown.text = countDown.toString()
            if(countDown<=20) sp.play(warning_alarm,1.0f,1.0f,2,0,1.0f)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_desert)

        bgm_nervous = MediaPlayer.create(this,R.raw.nervous02)     //載入音樂檔(需要時間)

        warning_alarm = sp.load(this, R.raw.warning_alarm, 1)        //載入音效 參數由左至右是(context,音訊檔位置,優先級(最小為0,預設為0))

        imgv_box.setOnClickListener {
            tv_content_desert.setText(R.string.str_box)
            btn_take_it.visibility = View.VISIBLE

        }
        imgv_boy.setOnClickListener {
            tv_content_desert.setText(R.string.str_boy)
            btn_take_it.visibility = View.INVISIBLE
        }
        imgv_girl.setOnClickListener {
            tv_content_desert.setText(R.string.str_girl)
            btn_take_it.visibility = View.INVISIBLE
        }
        btn_backpack.setOnClickListener {
            startActivity(Intent(this,BackpackActivity::class.java))
            if(movement>=4) bgm_nervous.pause()
        }

        btn_take_it.setOnClickListener {
            putIn(MyPackage(R.drawable.box, "破舊公事包", resources.getString(R.string.str_box_detail), false, 1,1),imgv_box)
            btn_take_it.visibility = View.GONE
        }

        btn_movement.setOnClickListener {
            if (movement<3){
                movement++
                btn_movement.text = "MOVEMENT:${movement}"
            }
            else if(movement==3){
                movement++
                btn_movement.text= "該怎麼做?"
                tv_content_desert.text = ""
                tv_countdown.visibility = View.VISIBLE
                imgv_zombies_army.visibility = View.VISIBLE
                ObjectAnimator.ofFloat(imgv_zombies_army,"alpha",0f,1f,1f).apply {
                    duration = 2000
                    start()
                }
                zombiesComing.start()
                //殭屍配樂
                bgm_nervous.start()
            }
            else if(movement==4){
                movement++
                btn_movement.text= "就這麼辦!!"
            }
            else {
                startActivity(Intent(this, BuildingActivity::class.java))
                bgm_nervous.release()
                zombiesComing.cancel()
                btn_movement.isEnabled = false

            }

        }


    }

//    private fun initKeyListener(soundPool: SoundPool) {
//        soundPool.play(pianoSound_c,1.0f,1.0f,2,0,1.0f)
//    }


}
