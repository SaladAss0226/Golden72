package com.example.golden72.room

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.golden72.R
import com.example.golden72.backpack.BackpackAdapter.Companion.unAssignList
import com.example.golden72.backpack.MyPackage
import com.example.golden72.publicFunction.putIn
import kotlinx.android.synthetic.main.activity_store_room.*
import kotlinx.android.synthetic.main.dialog_edit_text.*
import kotlinx.android.synthetic.main.dialog_only_text.btn_accept

class StoreRoomActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_store_room)

        btn_back_store_room.setOnClickListener { this.finish() }

        imgv_background_store_room.setOnClickListener { tv_content_store_room.setText(R.string.str_store_room) }

        imgv_search_sundries.setOnClickListener {
            val dialog = DialogOnlyText(this,"確定要搜索雜物嗎?")
            dialog.show()
            dialog.btn_accept.setOnClickListener {
                tv_content_store_room.setText(R.string.str_advertisment)
                imgv_furniture.visibility = View.VISIBLE
                dialog.dismiss()
            }

        }
        imgv_search_board.setOnClickListener {
            val dialog = DialogOnlyText(this,"確定要搜索白板嗎?")
            dialog.show()
            dialog.btn_accept.setOnClickListener {
                imgv_houston.visibility = View.VISIBLE
                tv_content_store_room.setText(R.string.str_houston)
                dialog.dismiss()
            }
        }
        imgv_search_wall.setOnClickListener {
            val dialog = DialogOnlyText(this,"確定要查看牆壁嗎?")
            dialog.show()
            dialog.btn_accept.setOnClickListener {
                tv_content_store_room.setText(R.string.str_blood_words)
                dialog.dismiss()
            }
        }

        imgv_furniture.setOnClickListener {
            //跳出editText窗輸入名稱後加入背包
            val dialog = DialogEditText(this)
            dialog.show()
            dialog.btn_accept.setOnClickListener {
                unAssignList.add(MyPackage(R.drawable.question_mark,dialog.et_name.text.toString(),dialog.et_describe.text.toString(),false,dialog.et_available_use_time.text.toString().toInt(),1))
                dialog.dismiss()
            }
        }
        imgv_houston.setOnClickListener {
            val dialog = DialogTakeIt(this,R.drawable.ic_houston)
            dialog.show()
            dialog.btn_accept.setOnClickListener {
                putIn(MyPackage(R.drawable.ic_houston, "不知名的地圖","應該是某種線索", false, 999,2),imgv_houston)
                dialog.dismiss()
            }
        }




    }
}
