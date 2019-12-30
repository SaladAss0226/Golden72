package com.example.golden72.room

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.golden72.R
import com.example.golden72.backpack.MyPackage
import com.example.golden72.publicFunction.putIn
import kotlinx.android.synthetic.main.activity_basement.*
import kotlinx.android.synthetic.main.dialog_only_text.*

class BasementActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_basement)

        btn_back_basement.setOnClickListener { this.finish() }

        imgv_search_left_sundries.setOnClickListener {
            val dialog = DialogOnlyText(this,"確定要搜索左側平台下的雜物嗎?")
            dialog.show()
            dialog.btn_accept.setOnClickListener {
                tv_content_basement.setText(R.string.str_newspaper)
                dialog.dismiss()
            }
            imgv_search_left_sundries.isEnabled = false
        }
        imgv_search_right_sundries.setOnClickListener {
            val dialog = DialogOnlyText(this,"確定要搜索右側三層櫃嗎?")
            dialog.show()
            dialog.btn_accept.setOnClickListener {
                tv_content_basement.setText(R.string.str_mos_code)
                imgv_mos_code.visibility = View.VISIBLE
                dialog.dismiss()
            }
            imgv_search_right_sundries.isEnabled = false
        }

        imgv_search_supply_station_map.setOnClickListener {
            val dialog = DialogOnlyText(this,"確定要搜索牆壁上的地圖嗎?")
            dialog.show()
            dialog.btn_accept.setOnClickListener {
                tv_content_basement.setText(R.string.str_supply_station_map)
                imgv_supply_station_map.visibility = View.VISIBLE
                dialog.dismiss()
            }
            imgv_search_supply_station_map.isEnabled = false
        }

        imgv_mos_code.setOnClickListener {
            val dialog = DialogTakeIt(this,R.drawable.mos_code)
            dialog.show()
            dialog.btn_accept.setOnClickListener {
                putIn(MyPackage(R.drawable.mos_code, "摩斯密碼表", resources.getString(R.string.str_mos_code), false, 999,2), imgv_mos_code)
                dialog.dismiss()
            }
        }
        imgv_supply_station_map.setOnClickListener {
            val dialog = DialogTakeIt(this, R.drawable.rocket)
            dialog.show()
            dialog.btn_accept.setOnClickListener {
                putIn(MyPackage(R.drawable.rocket, "補給站位置圖",resources.getString(R.string.str_supply_station_map), false, 999,2), imgv_supply_station_map)
                dialog.dismiss()
            }
        }



    }
}
