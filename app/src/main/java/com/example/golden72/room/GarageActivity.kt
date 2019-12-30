package com.example.golden72.room

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.golden72.R
import com.example.golden72.onTheWay.ToHoustonActivity
import com.example.golden72.backpack.MyPackage
import com.example.golden72.publicFunction.putIn
import com.example.golden72.room.RoomActivity.Companion.bgm_room
import kotlinx.android.synthetic.main.activity_garage.*
import kotlinx.android.synthetic.main.dialog_only_text.*
import kotlinx.android.synthetic.main.dialog_only_text.btn_accept
import kotlinx.android.synthetic.main.dialog_take_it.*

class GarageActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_garage)

        btn_back_garage.setOnClickListener { this.finish() }

        imgv_gas_42.setOnClickListener {
            val dialog = DialogTakeIt(this,R.drawable.galllons_42)
            dialog.show()
            dialog.btn_accept.setOnClickListener {
                putIn(MyPackage(R.drawable.galllons_42,"一大桶汽油",resources.getString(R.string.str_gas_42),false,1,1),imgv_gas_42)
                dialog.dismiss()
            }
        }

        imgv_chevrlet.setOnClickListener {
                val dialog = DialogOnlyText(this,"確定要啟程離開這裡嗎?")
                dialog.show()
                dialog.btn_accept.setOnClickListener {
                    putIn(MyPackage(R.drawable.chevrolet, "雪弗蘭Suburban",resources.getString(R.string.str_car), false, 99,2),imgv_chevrlet)

                    Thread{
                        Thread.sleep(500)
                        runOnUiThread {
                            //bgm_room.release()
                            startActivity(Intent(this,  ToHoustonActivity::class.java))
                            overridePendingTransition(0,android.R.anim.fade_out)
                            //畫面淡出
                        }
                    }.start()

                    dialog.dismiss()
                }
        }
    }
}
