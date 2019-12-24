package com.example.golden72.room

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.golden72.R
import com.example.golden72.backpack.BackpackActivity
import kotlinx.android.synthetic.main.activity_store_room.*

class StoreRoomActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_store_room)

        btn_back_store_room.setOnClickListener { this.finish() }

        btn_backpack_store_room.setOnClickListener { startActivity(Intent(this,BackpackActivity::class.java)) }

        imgv_background_store_room.setOnClickListener { tv_content_store_room.setText(R.string.str_store_room) }

    }
}
