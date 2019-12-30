package com.example.golden72.room

import android.animation.ObjectAnimator
import android.animation.ValueAnimator
import android.content.Context
import android.content.Intent
import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.golden72.R
import com.example.golden72.backpack.BackpackActivity
import kotlinx.android.synthetic.main.activity_room.*

class RoomActivity : AppCompatActivity() {

    companion object{
        lateinit var bgm_room: MediaPlayer
    }

    var musicFlag = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_room)

        bgm_room = MediaPlayer.create(this,R.raw.don_t_look_inside)     //載入音樂檔(需要時間)

        ObjectAnimator.ofFloat(tv_next,"alpha",0f,1f,0f).apply {
            duration = 2000
            repeatCount = ValueAnimator.INFINITE
            repeatMode = ValueAnimator.RESTART
            start()
        }

        tv_next.setOnClickListener {
            tv_next.visibility = View.GONE
            imgv_arrow_forward.visibility = View.GONE
            imgv_bg_room.visibility = View.GONE
            tv_content_room.setText(R.string.str_room_screen)
            imgv_store_room.visibility = View.VISIBLE
            imgv_library.visibility = View.VISIBLE
            imgv_garage.visibility = View.VISIBLE
            imgv_basement.visibility = View.VISIBLE
            musicFlag = true
            bgm_room.start()
            bgm_room.isLooping = true
        }


        //進入各個房間
        btn_backpack_room.setOnClickListener {
            startActivity(Intent(this, BackpackActivity::class.java))
            bgm_room.pause()
        }
        imgv_garage.setOnClickListener { startActivity(Intent(this,GarageActivity::class.java)) }
        imgv_store_room.setOnClickListener { startActivity(Intent(this,StoreRoomActivity::class.java)) }
        imgv_library.setOnClickListener { startActivity(Intent(this,LibraryActivity::class.java)) }
        imgv_basement.setOnClickListener { startActivity(Intent(this,BasementActivity::class.java)) }



    }

    override fun onResume() {
        super.onResume()
        if(musicFlag==true){
            bgm_room.start()
            bgm_room.isLooping = true
        }



    }
}
