package com.example.golden72.toyotaCenter

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.golden72.R
import com.example.golden72.backpack.BackpackActivity
import com.example.golden72.onTheWay.ToWilliamsActivity
import com.example.golden72.room.DialogOnlyText
import kotlinx.android.synthetic.main.activity_t_center_outside.*
import kotlinx.android.synthetic.main.dialog_only_text.*

class TCenterOutsideActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_t_center_outside)

        imgv_seach_wall_toyota_outside.setOnClickListener {
            val dialog = DialogOnlyText(this,"確定要查看牆壁上的噴漆嗎?")
            dialog.show()
            dialog.btn_accept.setOnClickListener {
                tv_content_toyota_center_outside.setText(R.string.str_wall_toyota_outside)
                dialog.dismiss()
            }
        }

        imgv_enter_toyota_outside.setOnClickListener {
            val dialog = DialogOnlyText(this,"確定要進入場館嗎?")
            dialog.show()
            dialog.btn_accept.setOnClickListener {
                startActivity(Intent(this, TCenterInsideActivity::class.java))
                dialog.dismiss()
            }
        }

        btn_backpack_tcenter_outside.setOnClickListener { startActivity(Intent(this,BackpackActivity::class.java)) }

        btn_leave.setOnClickListener { startActivity(Intent(this, ToWilliamsActivity::class.java)) }

    }
}
