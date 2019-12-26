package com.example.golden72.room

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.golden72.R
import com.example.golden72.backpack.MyPackage
import com.example.golden72.publicFunction.putIn
import kotlinx.android.synthetic.main.activity_garage.*
import kotlinx.android.synthetic.main.dialog_only_text.*

class GarageActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_garage)

        btn_back_garage.setOnClickListener { this.finish() }

        imgv_chevrlet.setOnClickListener {
                val dialog = DialogOnlyText(this,"確定要啟程離開這裡嗎?")
                dialog.show()
                dialog.btn_accept.setOnClickListener {
                    putIn(MyPackage(R.drawable.chevrolet, "雪弗蘭Suburban","一輛越野性能卓越的SUV(高速油耗0.102L/km)", false, 99),imgv_chevrlet)

                    //啟程!!
                    //startActivity(Intent())

                    dialog.dismiss()
                }
        }
    }
}
