package com.example.golden72.building

import android.animation.ObjectAnimator
import android.content.Intent
import android.media.MediaPlayer
import android.media.SoundPool
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.view.View
import android.widget.Toast
import com.example.golden72.R
import com.example.golden72.backpack.BackpackActivity
import com.example.golden72.backpack.MyPackage
import com.example.golden72.desert.DesertActivity
import com.example.golden72.publicFunction.putIn
import com.example.golden72.room.RoomActivity
import kotlinx.android.synthetic.main.activity_building.*
import kotlinx.android.synthetic.main.dialog_only_text.*

class BuildingActivity : AppCompatActivity() {

    lateinit var bgm_building: MediaPlayer
    var m = 9
    var s = 60
    var timeIsPlaying = true
    companion object{
        var key = ""
        var explosionSound = 0
        var soundPool = SoundPool.Builder().setMaxStreams(8).build()
    }
    var flag = ""

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
            if(m==0) DesertActivity.sp.play(DesertActivity.warning_alarm,1.0f,1.0f,2,0,1.0f)   //最後一分鐘的倒數計時聲
            if(m==5 && s==0) soundPool.play(explosionSound,1.0f,1.0f,2,0,1.0f)     //殭屍破門而入的爆炸聲
        }
    }



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_building)

        bgm_building = MediaPlayer.create(this,R.raw.all_start)     //載入音樂檔(需要時間)
        explosionSound = soundPool.load(this, R.raw.explosion, 1)

        escapeTime.start()

        btn_next.setOnClickListener {
            if(key =="破舊公事包"){   //公事包解鎖
                imgv_bg_building.visibility = View.GONE
                imgv_maze.visibility = View.VISIBLE
                imgv_bandages.visibility = View.VISIBLE
                imgv_eagal.visibility = View.VISIBLE
                imgv_knife.visibility = View.VISIBLE
                btn_take_it.visibility = View.VISIBLE
                btn_next.setText("逃離迷宮")
                key = "還未使用迷宮平面圖"
            }
            else if(key=="迷宮平面圖"){
                startActivity(Intent(this,RoomActivity::class.java))
                bgm_building.release()
                escapeTime.cancel()
            }
            else if(key=="還未使用迷宮平面圖") Toast.makeText(this,"你們還未使用迷宮平面圖",Toast.LENGTH_SHORT).show()
            else{
                val dialog = DialogNextStep(this)
                dialog.show()
                dialog.btn_accept.setOnClickListener {
                    tv_content_building.setText(R.string.str_enter_maze)
                    dialog.dismiss()
                }
            }

        }

        btn_play_and_stop.setOnClickListener {
            if(timeIsPlaying) escapeTime.cancel()
            else escapeTime.start()
            timeIsPlaying = !timeIsPlaying
        }

        tv_countdown.setOnClickListener { imgv_flash_light.visibility = View.VISIBLE }


        btn_backpack.setOnClickListener {
            startActivity(Intent(this,BackpackActivity::class.java))
            bgm_building.pause()
        }

        imgv_eagal.setOnClickListener {
            tv_content_building.text = resources.getString(R.string.str_eagal)
            flag = "eagal"
        }
        imgv_bandages.setOnClickListener {
            tv_content_building.text = resources.getString(R.string.str_bandages)
            flag = "bandages"
        }
        imgv_maze.setOnClickListener {
            tv_content_building.text = resources.getString(R.string.str_maze)
            flag = "maze"
        }
        imgv_knife.setOnClickListener {
            tv_content_building.text = resources.getString(R.string.str_knife)
            flag = "knife"
        }
        imgv_flash_light.setOnClickListener {
            tv_content_building.text = resources.getString(R.string.str_flash_light)
            flag = "flashLight"
        }

        btn_take_it.setOnClickListener {
            when(flag){
                "eagal" -> putIn(MyPackage(R.drawable.eagal, "沙漠之鷹", resources.getString(R.string.str_eagal), false, 21),imgv_eagal)
                "bandages" -> putIn(MyPackage(R.drawable.bandages, "紗布、酒精", resources.getString(R.string.str_bandages), false, 2),imgv_bandages)
                "maze" -> putIn(MyPackage(R.drawable.maze, "迷宮平面圖", resources.getString(R.string.str_maze), false, 1),imgv_maze)
                "knife" -> putIn(MyPackage(R.drawable.machete, "野戰開山刀", resources.getString(R.string.str_knife), false, 3),imgv_knife)
                "flashLight" -> putIn(MyPackage(R.drawable.flash_light, "戰術手電筒", resources.getString(R.string.str_flash_light), false, 4),imgv_flash_light)
            }
        }


    }

    override fun onResume() {
        super.onResume()
        bgm_building.start()
        bgm_building.isLooping = true


    }


}
