package com.example.golden72.room

import android.content.Intent
import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.golden72.R
import com.example.golden72.backpack.BackpackActivity
import kotlinx.android.synthetic.main.activity_room.*

class RoomActivity : AppCompatActivity() {

    lateinit var bgm_room: MediaPlayer


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_room)

        bgm_room = MediaPlayer.create(this,R.raw.don_t_look_inside)     //載入音樂檔(需要時間)

        btn_backpack_room.setOnClickListener {
            startActivity(Intent(this, BackpackActivity::class.java))
            bgm_room.pause()
        }

        imgv_garage.setOnClickListener {
            startActivity(Intent(this,GarageActivity::class.java))
        }
        imgv_store_room.setOnClickListener {
            startActivity(Intent(this,StoreRoomActivity::class.java))
        }
        imgv_library.setOnClickListener {
            startActivity(Intent(this,LibraryActivity::class.java))
        }

        tv_content_room.setText(R.string.str_room_screen)

    }

    override fun onResume() {
        super.onResume()
        bgm_room.start()
        bgm_room.isLooping = true


    }
}
