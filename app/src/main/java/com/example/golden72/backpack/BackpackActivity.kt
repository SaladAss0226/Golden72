package com.example.golden72.backpack

import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.golden72.building.BuildingActivity.Companion.key
import com.example.golden72.R
import kotlinx.android.synthetic.main.activity_backpack.*
import kotlinx.android.synthetic.main.dialog_take_it.*

class BackpackActivity : AppCompatActivity() {

    val backpackAdapter = BackpackAdapter()
    lateinit var bgm_backpack: MediaPlayer


    override fun onResume() {
        super.onResume()
        bgm_backpack.start()
        bgm_backpack.isLooping = true

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_backpack)

        bgm_backpack = MediaPlayer.create(this,R.raw.suspense)     //載入音樂檔(需要時間)

        recyclerview_backpack.layoutManager = LinearLayoutManager(this)
        recyclerview_backpack.adapter = backpackAdapter


        btn_back.setOnClickListener {
            this.finish()
            bgm_backpack.pause()

        }

        BackpackAdapter.setToClick(object :BackpackAdapter.ItemClickListener{
            override fun toClick(item: MyPackage) {

                if(item.availableUseTime>0) {
                    val dialog = DialogUseIt(this@BackpackActivity, item)
                    dialog.show()
                    dialog.btn_accept.setOnClickListener {
                        key = item.itemName
                        item.availableUseTime--
                        if (item.availableUseTime <= 0) {
                            item.done = true
                            Toast.makeText(this@BackpackActivity, "${item.itemName}已用盡。", Toast.LENGTH_SHORT).show()
                        }
                        else Toast.makeText(this@BackpackActivity, "您使用了一次${item.itemName}", Toast.LENGTH_SHORT).show()
                        backpackAdapter.notifyDataSetChanged()
                        dialog.dismiss()
                    }
                }
                else Toast.makeText(this@BackpackActivity,"此物品已無法使用。",Toast.LENGTH_SHORT).show()



            }
        })
    }

    override fun onBackPressed() {}
}
