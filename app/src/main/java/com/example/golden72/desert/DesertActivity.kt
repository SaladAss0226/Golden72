package com.example.golden72.desert

import android.animation.ObjectAnimator
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.view.View
import com.example.golden72.building.BuildingActivity
import com.example.golden72.R
import com.example.golden72.backpack.BackpackActivity
import com.example.golden72.backpack.BackpackAdapter.Companion.unAssignList
import com.example.golden72.backpack.Package
import kotlinx.android.synthetic.main.activity_desert.*
import kotlinx.android.synthetic.main.dialog_take_it.*

class DesertActivity : AppCompatActivity() {

    var countDown = 30

    val zombiesComing = object : CountDownTimer(30000,1000){
        override fun onFinish() {
            layout_you_lost.visibility = View.VISIBLE
            ObjectAnimator.ofFloat(layout_you_lost,"alpha",0f,0.8f,0.8f).apply {
                duration = 2000
                start()
            }
        }
        override fun onTick(millisUntilFinished: Long) {
            countDown -= 1
            tv_countdown.text = countDown.toString()
            //倒數音效
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_desert)

        var movement = 0

        val dialog = DialogTakeIt(this)

        imgv_box.setOnClickListener {
            tv_content_desert.setText(R.string.str_box)
            dialog.show()
            dialog.btn_accept.setOnClickListener {
                unAssignList.add(
                    Package(
                        R.drawable.box,
                        "破舊公事包",
                        "埃及法老的子民啊，獻出心臟、佐以泉湧鮮血，解放封印在內之靈。",
                        false
                    )
                )
                imgv_box.visibility = View.GONE
                dialog.dismiss()
            }

        }
        imgv_boy.setOnClickListener {
            tv_content_desert.setText(R.string.str_boy)
        }
        imgv_girl.setOnClickListener {
            tv_content_desert.setText(R.string.str_girl)
        }
        btn_backpack.setOnClickListener {
            startActivity(Intent(this,BackpackActivity::class.java))
        }

        btn_movement.setOnClickListener {
            if (movement<3){
                movement++
                btn_movement.text = "MOVEMENT:${movement}"
            }
            else if(movement==3){
                movement++
                btn_movement.text= "該怎麼做?"
                tv_content_desert.text = ""
                tv_countdown.visibility = View.VISIBLE
                imgv_zombies_army.visibility = View.VISIBLE
                ObjectAnimator.ofFloat(imgv_zombies_army,"alpha",0f,1f,1f).apply {
                    duration = 2000
                    start()
                }
                zombiesComing.start()
                //殭屍音效
            }
            else if(movement==4){
                movement++
                btn_movement.text= "就這麼辦!!"
            }
            else startActivity(Intent(this,
                BuildingActivity::class.java))

        }


    }
}
