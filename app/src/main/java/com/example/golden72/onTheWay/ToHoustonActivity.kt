package com.example.golden72.onTheWay

import android.animation.ObjectAnimator
import android.animation.ValueAnimator
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.example.golden72.R
import com.example.golden72.toyotaCenter.TCenterOutsideActivity
import com.example.golden72.room.DialogEditTextMap
import kotlinx.android.synthetic.main.activity_to_houston.*
import kotlinx.android.synthetic.main.dialog_edit_text_map.*

class ToHoustonActivity : AppCompatActivity() {

    var flagNext = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_to_houston)

        var animator = ObjectAnimator.ofFloat(tv_next,"alpha",0f,1f,0f)
        animator.apply {
            duration = 2000
            repeatCount = ValueAnimator.INFINITE
            repeatMode = ValueAnimator.RESTART
            start()
        }


        tv_next.setOnClickListener {
            if(flagNext==0) {
                layout_first_to_Houston.visibility = View.GONE
                flagNext = 1
            }
            else if(flagNext==1){
                layout_second_to_Houston.visibility = View.GONE
                flagNext = 2
            }
            else if(flagNext==2){
                startActivity(Intent(this,
                    TCenterOutsideActivity::class.java))
            }



        }

        btn_supply_station_to_houston.setOnClickListener {
            val dialog = DialogEditTextMap(this,"補給站等級")
            dialog.show()
            dialog.btn_accept.setOnClickListener {
                if(dialog.dialog_edittext.text.length>0){
                    val b = Bundle()
                    b.putString("level",dialog.dialog_edittext.text.toString())
                    startActivity(Intent(this,SupplyActivity::class.java).putExtras(b))
                    dialog.dismiss()
                }
                else Toast.makeText(this,"請輸入補給站等級",Toast.LENGTH_SHORT).show()

            }


        }
        btn_contact_station_to_houston.setOnClickListener {
            startActivity(Intent(this,ContactActivity::class.java))
        }

    }
}
