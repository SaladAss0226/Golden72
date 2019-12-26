package com.example.golden72.room

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.golden72.R
import com.example.golden72.backpack.MyPackage
import com.example.golden72.publicFunction.putIn
import kotlinx.android.synthetic.main.activity_library.*
import kotlinx.android.synthetic.main.dialog_only_text.*

class LibraryActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_library)

        btn_back_library.setOnClickListener { this.finish() }

        imgv_search_left_bookcase.setOnClickListener {
            val dialog = DialogOnlyText(this,"確定要搜索左側書櫃嗎?")
            dialog.show()
            dialog.btn_accept.setOnClickListener {
                tv_content_library.setText(R.string.str_magazine)
                dialog.dismiss()
            }
        }

        imgv_search_center_bookcase.setOnClickListener {
            val dialog = DialogOnlyText(this,"確定要搜索中間書櫃嗎?")
            dialog.show()
            dialog.btn_accept.setOnClickListener {
                tv_content_library.setText(R.string.str_usa_map)
                imgv_usa_map.visibility = View.VISIBLE
                dialog.dismiss()
            }
        }

        imgv_search_right_bookcase.setOnClickListener {
            val dialog = DialogOnlyText(this,"確定要搜索右側書櫃嗎?")
            dialog.show()
            dialog.btn_accept.setOnClickListener {
                tv_content_library.setText(R.string.str_you_lose)
                dialog.dismiss()
            }
        }

        imgv_usa_map.setOnClickListener {
            val dialog = DialogTakeIt(this,R.drawable.usa_map)
            dialog.show()
            dialog.btn_accept.setOnClickListener {
                putIn(MyPackage(R.drawable.usa_map, "美國地圖","一張美國行政區地圖。", false, 99),imgv_usa_map)
                dialog.dismiss()
            }
        }



    }
}
